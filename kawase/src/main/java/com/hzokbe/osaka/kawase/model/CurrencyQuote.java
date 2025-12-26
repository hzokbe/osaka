package com.hzokbe.osaka.kawase.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "currency_quotes")
public class CurrencyQuote extends PanacheEntityBase {
    public enum Currency {
        BRL,
        USD
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, name = "'from'")
    @Enumerated(EnumType.STRING)
    public Currency from;

    @Column(nullable = false, name = "'to'")
    @Enumerated(EnumType.STRING)
    public Currency to;

    @Column(nullable = false, precision = 19, scale = 5)
    public BigDecimal rate;

    @Column(nullable = false, name = "quoted_at")
    @CreationTimestamp
    public Timestamp quotedAt;
}
