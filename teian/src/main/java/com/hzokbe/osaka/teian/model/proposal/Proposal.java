package com.hzokbe.osaka.teian.model.proposal;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "proposals")
public class Proposal extends PanacheEntityBase {
    public enum Country {
        USA,
        BRAZIL,
        CANADA,
        MEXICO,
        ARGENTINA,
        CHILE,
        UK,
        FRANCE,
        GERMANY,
        SPAIN,
        PORTUGAL,
        ITALY,
        JAPAN,
        CHINA,
        SOUTH_KOREA,
        AUSTRALIA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(nullable = false)
    public String customerName;

    @Column(nullable = false, precision = 19, scale = 5)
    public BigDecimal tons;

    @Column(name = "price_per_ton",nullable = false, precision = 19, scale = 5)
    public BigDecimal pricePerTon;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public Country country;
}
