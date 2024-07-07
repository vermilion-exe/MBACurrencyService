package org.mba.api.service;

import org.mba.api.dto.ResponseCurrency;

import java.util.List;

public interface CurrencyService {

    List<ResponseCurrency> getAllCurrencies();

}
