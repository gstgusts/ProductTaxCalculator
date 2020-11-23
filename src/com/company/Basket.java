package com.company;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> products = new ArrayList<>();
    private TaxCalculator taxCalculator;

    public Basket(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void addToBasket(Product product) {
        products.add(product);
    }

    public double getTax() {
        return taxCalculator.getTax(getProductTotal());
    }

    public double getTotal() {
         return getProductTotal() + getTax();
    }

    private double getProductTotal() {
        var sum = 0d;
        for (var product :
                products) {
            sum += product.getPrice() * product.getQuantity();
        }

        return sum;
    }
}
