package com.hzokbe.osaka.teian.service;

import com.hzokbe.osaka.teian.dto.ProposalDTO;
import com.hzokbe.osaka.teian.dto.request.ProposalRequestDTO;
import com.hzokbe.osaka.teian.dto.response.ProposalResponseDTO;
import com.hzokbe.osaka.teian.exception.proposal.InvalidCustomerNameException;
import com.hzokbe.osaka.teian.exception.proposal.InvalidPricePerTonException;
import com.hzokbe.osaka.teian.exception.proposal.InvalidValueForTonsException;
import com.hzokbe.osaka.teian.model.Proposal;
import com.hzokbe.osaka.teian.producer.ProposalProducer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;

@ApplicationScoped
public class ProposalService {
    @Inject
    private ProposalProducer producer;

    @Transactional
    public ProposalResponseDTO createProposal(ProposalRequestDTO dto) {
        var customerName = dto.getCustomerName();

        if (customerName == null || customerName.isBlank()) {
            throw new InvalidCustomerNameException("Customer name cannot be null or blank");
        }

        var tons = dto.getTons();

        if (tons == null || tons.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidValueForTonsException("Tons must be greater than zero");
        }

        var pricePerTon = dto.getPricePerTon();

        if (pricePerTon == null || pricePerTon.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPricePerTonException("Price per ton must be greater than zero");
        }

        var proposal = new Proposal();

        proposal.customerName = customerName;

        proposal.tons = tons;

        proposal.pricePerTon = pricePerTon;

        proposal.country = dto.getCountry();

        Proposal.persist(proposal);

        producer.sendProposal(new ProposalDTO(
                proposal.id,
                proposal.customerName,
                proposal.tons,
                proposal.pricePerTon,
                proposal.country
        ));

        return new ProposalResponseDTO(
                proposal.id,
                proposal.customerName,
                proposal.tons,
                proposal.pricePerTon,
                proposal.country
        );
    }
}
