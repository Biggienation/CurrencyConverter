package com.java24.brix.service.currency;

public interface CurrencyConverter {
    double convert(double amount, String fromCurrency, String toCurrency);
    String getConverterName();
}
