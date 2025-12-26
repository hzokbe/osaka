package com.hzokbe.osaka.teian.dto.request;

import com.hzokbe.osaka.teian.model.Proposal;

import java.math.BigDecimal;

public class ProposalRequestDTO {
    private String customerName;

    private BigDecimal tons;

    private BigDecimal pricePerTon;

    private Proposal.Country country;

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
