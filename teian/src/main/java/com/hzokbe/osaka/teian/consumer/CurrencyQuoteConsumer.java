package com.hzokbe.osaka.teian.consumer;

import com.hzokbe.osaka.teian.dto.currency.quote.CurrencyQuoteDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class CurrencyQuoteConsumer {
    @Incoming("currency-quote")
    public void consume(CurrencyQuoteDTO dto) {
        System.out.println(dto.getRate());
    }
}
