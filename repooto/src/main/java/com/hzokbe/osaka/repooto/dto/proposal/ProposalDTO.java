package com.hzokbe.osaka.repooto.dto.proposal;

import com.hzokbe.osaka.repooto.model.proposal.Proposal;

import java.math.BigDecimal;
import java.util.UUID;

public class ProposalDTO {
    private UUID id;

    private String customerName;

    private BigDecimal tons;

    private BigDecimal pricePerTon;

    private Proposal.Country country;

    public ProposalDTO() {
    }

    public ProposalDTO(UUID id, String customerName, BigDecimal tons, BigDecimal pricePerTon, Proposal.Country country) {
        this.id = id;

        this.customerName = customerName;

        this.tons = tons;

        this.pricePerTon = pricePerTon;

        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getTons() {
        return tons;
    }

    public void setTons(BigDecimal tons) {
        this.tons = tons;
    }

    public BigDecimal getPricePerTon() {
        return pricePerTon;
    }

    public void setPricePerTon(BigDecimal pricePerTon) {
        this.pricePerTon = pricePerTon;
    }

    public Proposal.Country getCountry() {
        return country;
    }

    public void setCountry(Proposal.Country country) {
        this.country = country;
    }
}
