package com.java24.brix.service;

public interface CurrencyConverter {
    double convert(double amount, String fromCurrency, String toCurrency);
    String getConverterName();
}
