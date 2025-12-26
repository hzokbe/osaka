package com.hzokbe.osaka.kawase.producer;

import com.hzokbe.osaka.kawase.dto.CurrencyQuoteDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class CurrencyQuoteProducer {
    @Inject
    @Channel("currency-quote")
    private Emitter<CurrencyQuoteDTO> currencyQuoteEmitter;

    public void sendCurrencyQuote(CurrencyQuoteDTO dto) {
        currencyQuoteEmitter.send(dto);
    }
}
