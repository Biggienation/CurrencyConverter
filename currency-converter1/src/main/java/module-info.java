import com.java24.brix.currency.converter1.SimpleCurrencyConverter;
import com.java24.brix.service.CurrencyConverter;

module com.java24.brix.SimpleCurrencyconverter {
    requires com.java24.brix.service;
    provides CurrencyConverter with SimpleCurrencyConverter;
}