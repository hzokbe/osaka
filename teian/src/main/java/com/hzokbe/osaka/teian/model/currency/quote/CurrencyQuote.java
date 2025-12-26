package com.hzokbe.osaka.teian.model.currency.quote;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class CurrencyQuote {
    public enum Currency {
        BRL,
        USD
    }

    private UUID id;

    public Currency from;

    public Currency to;

    public BigDecimal rate;

    public Timestamp quotedAt;
}
