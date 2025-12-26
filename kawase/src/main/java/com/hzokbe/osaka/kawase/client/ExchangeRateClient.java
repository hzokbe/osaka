package com.hzokbe.osaka.kawase.client;

import com.hzokbe.osaka.kawase.dto.ExchangeRateResponseDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://v6.exchangerate-api.com")
@Path("/v6/{key}")
public interface ExchangeRateClient {
    @GET
    @Path("/latest/{code}")
    ExchangeRateResponseDTO getLatestRate(@PathParam("key") String key, @PathParam("code") String code);
}
