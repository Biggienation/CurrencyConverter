import com.java24.brix.currency.converter2.AdvancedCurrencyConverter;
import com.java24.brix.service.currency.CurrencyConverter;

module com.java.brix.AdvancedCurrencyConverter {
    requires com.java.brix.service;
    provides CurrencyConverter with AdvancedCurrencyConverter;
}