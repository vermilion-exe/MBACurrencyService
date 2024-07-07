package org.mba.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.mba.api.dto.ResponseResult;
import org.mba.api.properties.CbrApi;
import org.mba.api.properties.CbrClient;
import org.mba.api.service.CbrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class CbrServiceImpl implements CbrService {

    private final CbrApi cbrApi;
    private final WebClient webClient;

    @Autowired
    public CbrServiceImpl(CbrClient cbrClient, CbrApi cbrApi) {
        this.cbrApi = cbrApi;
        this.webClient = WebClient
                .builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().jaxb2Decoder(new Jaxb2XmlDecoder()))
                        .build())
                .baseUrl(cbrClient.getBaseUrl())
                .build();
    }

    @Override
    public ResponseResult getQueryResult() {
        return webClient
                .get()
                .uri(cbrApi.getGetCurrencies())
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(ResponseResult.class)
                .block();
    }
}
