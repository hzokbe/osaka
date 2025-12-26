package com.hzokbe.osaka.repooto.model.report;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "reports")
public class Report extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(name = "proposal_id", nullable = false)
    public UUID proposalId;

    @Column(name = "customer_name", nullable = false)
    public String customerName;

    @Column(nullable = false, precision = 19, scale = 5)
    public BigDecimal tons;

    @Column(name = "price_per_ton", nullable = false, precision = 19, scale = 5)
    public BigDecimal pricePerTon;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    public Timestamp createdAt;
}
