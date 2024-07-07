package org.mba.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.mba.api.dto.ResponseCurrency;
import org.mba.api.properties.MbaData;
import org.mba.api.service.CbrService;
import org.mba.api.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CbrService cbrService;
    private final MbaData mbaData;

    @Override
    public List<ResponseCurrency> getAllCurrencies() {
        List<ResponseCurrency> currencies = cbrService.getQueryResult().getCurrencies();
        ResponseCurrency usd = currencies.stream().filter(currency -> currency.getCharCode().equals("USD")).findFirst().get();
        ResponseCurrency eur = currencies.stream().filter(currency -> currency.getCharCode().equals("EUR")).findFirst().get();
        ResponseCurrency azn = currencies.stream().filter(currency -> currency.getCharCode().equals("AZN")).findFirst().get();

        currencies.clear();
        usd.setVUnitRate(round(usd.getVUnitRate()*((Double.parseDouble(mbaData.getUsd())+100)/100), 4, true));
        eur.setVUnitRate(round(eur.getVUnitRate()*((Double.parseDouble(mbaData.getEur())+100)/100), 4, true));
        azn.setVUnitRate(round(azn.getVUnitRate()*((Double.parseDouble(mbaData.getAzn())+100)/100), 4, true));
        usd.setValue(usd.getVUnitRate()*usd.getNominal());
        eur.setValue(eur.getVUnitRate()*eur.getNominal());
        azn.setValue(azn.getVUnitRate()*azn.getNominal());
        currencies.add(usd);
        currencies.add(eur);
        currencies.add(azn);

        return currencies;
    }

    public static double round(double value, int places, boolean roundUp) {
        if (places < 0) throw new IllegalArgumentException();

        double factor = Math.pow(10, places);
        if (roundUp) {
            return Math.ceil(value * factor) / factor;
        } else {
            return Math.floor(value * factor) / factor;
        }
    }

}
