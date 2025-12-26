package com.hzokbe.osaka.repooto.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzokbe.osaka.repooto.dto.proposal.ProposalDTO;
import com.hzokbe.osaka.repooto.dto.report.response.ReportResponseDTO;
import com.hzokbe.osaka.repooto.model.report.Report;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class ReportService {
    private final ObjectMapper mapper = new ObjectMapper();

    @Incoming("proposal")
    @Transactional
    public ReportResponseDTO generateReport(String message) throws Exception {
        var dto = mapper.readValue(message, ProposalDTO.class);

        var report = new Report();

        report.proposalId = dto.getId();

        report.customerName = dto.getCustomerName();

        report.tons = dto.getTons();

        report.pricePerTon = dto.getPricePerTon();

        Report.persist(report);

        return new ReportResponseDTO(
                report.id,
                dto.getId(),
                report.customerName,
                report.tons,
                report.pricePerTon,
                report.createdAt
        );
    }
}
