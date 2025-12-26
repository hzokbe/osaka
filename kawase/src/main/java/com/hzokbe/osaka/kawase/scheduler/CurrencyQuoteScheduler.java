package com.hzokbe.osaka.kawase.scheduler;

import com.hzokbe.osaka.kawase.service.CurrencyQuoteService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CurrencyQuoteScheduler {
    @Inject
    private CurrencyQuoteService service;

    @Scheduled(every = "60s")
    public void fetchCurrencyQuote() {
        service.getCurrencyQuote();
    }
}
