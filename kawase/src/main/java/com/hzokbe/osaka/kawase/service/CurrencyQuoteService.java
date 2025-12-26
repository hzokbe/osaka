package com.hzokbe.osaka.kawase.service;

import com.hzokbe.osaka.kawase.client.ExchangeRateClient;
import com.hzokbe.osaka.kawase.dto.CurrencyQuoteDTO;
import com.hzokbe.osaka.kawase.model.CurrencyQuote;
import com.hzokbe.osaka.kawase.producer.CurrencyQuoteProducer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;

@ApplicationScoped
public class CurrencyQuoteService {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyQuoteService.class);

    @Inject
    private CurrencyQuoteProducer producer;

    @Inject
    @RestClient
    private ExchangeRateClient client;

    @ConfigProperty(name = "exchange-rate-api.key")
    private String key;

    @Transactional
    public void getCurrencyQuote() {
        try {
            var dto = client.getLatestRate(key, "USD");

            if (!shouldUpdateCurrencyQuote(dto.getConversionRates().get("BRL"))) {
                return;
            }

            logger.info("É preciso atualizar a lista de cotações");

            var currencyQuote = new CurrencyQuote();

            currencyQuote.from = CurrencyQuote.Currency.USD;

            currencyQuote.to = CurrencyQuote.Currency.BRL;

            currencyQuote.rate = dto.getConversionRates().get("BRL");

            currencyQuote.quotedAt = new Timestamp(dto.getTimeLastUpdateUnix() * 1_000);

            CurrencyQuote.persist(currencyQuote);

            producer.sendCurrencyQuote(new CurrencyQuoteDTO(
                    currencyQuote.from,
                    currencyQuote.to,
                    currencyQuote.rate ,
                    currencyQuote.quotedAt
            ));
        } catch (Exception exception) {
            logger.error("Não foi possível obter a cotação atual");
        }
    }

    public boolean shouldUpdateCurrencyQuote(BigDecimal rate) {
        var currencyQuoteStream = CurrencyQuote.streamAll().map(e -> (CurrencyQuote) e);

        var currencyQuotes = currencyQuoteStream.toList();

        if (currencyQuotes.isEmpty()) {
            return true;
        }

        var lastCurrencyQuote = currencyQuotes.getLast();

        return lastCurrencyQuote.rate.compareTo(rate) < 0;
    }
}
