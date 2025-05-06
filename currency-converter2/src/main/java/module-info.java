import com.java24.brix.currency.converter2.AdvancedCurrencyConverter;
import com.java24.brix.service.CurrencyConverter;

module com.java24.brix.AdvancedCurrencyConverter {
    requires com.java24.brix.service;
    provides CurrencyConverter with AdvancedCurrencyConverter;
}