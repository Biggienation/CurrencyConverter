package com.java24.brix.currency.converter2;

import com.java24.brix.service.currency.ConverterName;
import com.java24.brix.service.currency.Currency;
import com.java24.brix.service.currency.CurrencyConverter;

import java.util.HashMap;
import java.util.Map;

@ConverterName("EUR,USD,GBP Converter")
@Currency({ "USD", "EUR", "GBP"})
public class AdvancedCurrencyConverter implements CurrencyConverter {
    private final Map<String, Double> rates = new HashMap<>();

    public AdvancedCurrencyConverter() {
        rates.put("USD-EUR", 0.92);
        rates.put("EUR-USD", 1.09);
        rates.put("USD-GBP", 0.79);
        rates.put("GBP-USD", 1.27);
        rates.put("EUR-GBP", 0.86);
        rates.put("GBP-EUR", 1.16);
    }

    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        String key = fromCurrency.toUpperCase() + "-" + toCurrency.toUpperCase();
        if (rates.containsKey(key)) {
            return amount * rates.get(key);
        }
        throw new IllegalArgumentException("Unsupported currency pair: " + key);
    }

    @Override
    public String getConverterName() {
        return "Advanced Converter with multiple currencies";
    }
}
