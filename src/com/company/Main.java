package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    var loader = new ConfigurationLoader();
	    var config = loader.load();

	    var prod1 = new Product("Maize",1d, 2d);
        var prod2 = new Product("Piens",2d, 1d);
        var prod3 = new Product("Saldējums",1d, 5d);

        TaxCalculator calculator = new CountryTaxCalculator(config.getDefaultTax());

        var basket = new Basket(calculator);

        basket.addToBasket(prod1);
        basket.addToBasket(prod2);
        basket.addToBasket(prod3);

        System.out.println("PVN:" + basket.getTax());
        System.out.println("Basket total:" + basket.getTotal());

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter desired country: ");

        var country = input.nextLine();

        var taxForCountry = config.getTaxForCountry(country);

        var basket2 = new Basket(new CountryTaxCalculator(taxForCountry));

        basket2.addToBasket(prod1);
        basket2.addToBasket(prod2);
        basket2.addToBasket(prod3);

        System.out.println("PVN:" + basket2.getTax());
        System.out.println("Basket total:" + basket2.getTotal());

    }
}
