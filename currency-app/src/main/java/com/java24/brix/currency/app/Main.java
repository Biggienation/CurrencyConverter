package com.java24.brix.currency.app;

import com.java24.brix.service.currency.ConverterName;
import com.java24.brix.service.currency.Currency;
import com.java24.brix.service.currency.CurrencyConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);
        List<CurrencyConverter> converters = new ArrayList<>();
        loader.forEach(converters::add);

        if (converters.isEmpty()) {
            System.out.println("No currency converters found!");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Currency Converters:");
        for (int i = 0; i < converters.size(); i++) {
            ConverterName annotation = converters.get(i).getClass().getAnnotation(ConverterName.class);
            String name = annotation != null ? annotation.value() : converters.get(i).getConverterName();
            System.out.printf("%d. %s%n", i + 1, name);
        }

        System.out.print("Select a converter (1-" + converters.size() + "): ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > converters.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        CurrencyConverter converter = converters.get(choice - 1);

        Currency currency = converter.getClass().getAnnotation(Currency.class);
        String currencyOptions = "";
        for (String c : currency.value()) {
            currencyOptions = String.join(",", currency.value());
        }

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        System.out.print("From currency (" + currencyOptions + "): ");
        String from = scanner.next();

        System.out.print("To currency (" + currencyOptions + "): ");
        String to = scanner.next();

        try {
            double result = converter.convert(amount, from, to);
            System.out.printf("%.2f %s = %.2f %s%n", amount, from, result, to);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
