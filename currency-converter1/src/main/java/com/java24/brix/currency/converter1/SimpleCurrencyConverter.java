package com.java24.brix.currency.converter1;

import com.java24.brix.service.currency.ConverterName;
import com.java24.brix.service.currency.Currency;
import com.java24.brix.service.currency.CurrencyConverter;

    @ConverterName("EUR,USD Converter")
    @Currency({ "USD", "EUR"})
    public class SimpleCurrencyConverter implements CurrencyConverter {
        private static final double USD_TO_EUR = 0.85;
        private static final double EUR_TO_USD = 1.18;

        @Override
        public double convert(double amount, String fromCurrency, String toCurrency) {
            if (fromCurrency.equalsIgnoreCase("USD") && toCurrency.equalsIgnoreCase("EUR")) {
                return amount * USD_TO_EUR;
            } else if (fromCurrency.equalsIgnoreCase("EUR") && toCurrency.equalsIgnoreCase("USD")) {
                return amount * EUR_TO_USD;
            }
            throw new IllegalArgumentException("Unsupported currency pair");
        }

        @Override
        public String getConverterName() {
            return "Simple Converter with fixed rates";
        }
    }
