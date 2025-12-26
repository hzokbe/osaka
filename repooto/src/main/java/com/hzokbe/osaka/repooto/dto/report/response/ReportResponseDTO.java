package com.hzokbe.osaka.repooto.dto.report.response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class ReportResponseDTO {
    private UUID id;

    private UUID proposalId;

    private String customerName;

    private BigDecimal tons;

    private BigDecimal pricePerTon;

    private Timestamp createdAt;

    public ReportResponseDTO(UUID id, UUID proposalId, String customerName, BigDecimal tons, BigDecimal pricePerTon, Timestamp createdAt) {
        this.id = id;

        this.proposalId = proposalId;

        this.customerName = customerName;

        this.tons = tons;

        this.pricePerTon = pricePerTon;

        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProposalId() {
        return proposalId;
    }

    public void setProposalId(UUID proposalId) {
        this.proposalId = proposalId;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
