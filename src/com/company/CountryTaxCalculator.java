package com.company;

public class CountryTaxCalculator implements TaxCalculator {

    private double countryTax;

    public CountryTaxCalculator(double countryTax) {
        this.countryTax = countryTax;
    }

    @Override
    public double getTax(double price) {
        return price * countryTax * 0.01;
    }
}
