import com.java24.brix.currency.converter1.SimpleCurrencyConverter;
import com.java24.brix.service.currency.CurrencyConverter;

module com.java.brix.SimpleCurrencyconverter {
    requires com.java.brix.service;
    provides CurrencyConverter with SimpleCurrencyConverter;
}