package com.hzokbe.osaka.teian.dto.currency.quote;

import com.hzokbe.osaka.teian.model.currency.quote.CurrencyQuote;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CurrencyQuoteDTO {
    private CurrencyQuote.Currency from;

    private CurrencyQuote.Currency to;

    private BigDecimal rate;

    private Timestamp quotedAt;

    public CurrencyQuoteDTO(CurrencyQuote.Currency from, CurrencyQuote.Currency to, BigDecimal rate, Timestamp quotedAt) {
        this.from = from;

        this.to = to;

        this.rate = rate;

        this.quotedAt = quotedAt;
    }

    public CurrencyQuote.Currency getFrom() {
        return from;
    }

    public void setFrom(CurrencyQuote.Currency from) {
        this.from = from;
    }

    public CurrencyQuote.Currency getTo() {
        return to;
    }

    public void setTo(CurrencyQuote.Currency to) {
        this.to = to;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Timestamp getQuotedAt() {
        return quotedAt;
    }

    public void setQuotedAt(Timestamp quotedAt) {
        this.quotedAt = quotedAt;
    }
}
