package org.mba.api.config;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class DoubleAdapter extends XmlAdapter<String, Double> {
    private final NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMANY);

    @Override
    public Double unmarshal(String v) throws Exception {
        if (v == null) {
            return null;
        }
        try {
            return numberFormat.parse(v).doubleValue();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid number format", e);
        }
    }

    @Override
    public String marshal(Double v) throws Exception {
        if (v == null) {
            return null;
        }
        return numberFormat.format(v);
    }
}
