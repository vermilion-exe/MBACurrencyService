package org.mba.api.controller;

import lombok.RequiredArgsConstructor;
import org.mba.api.dto.ResponseCurrency;
import org.mba.api.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public List<ResponseCurrency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

}
