package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Country {
    @JsonProperty("name")
    private String name;
    @JsonProperty("vat")
    private double vat;

    public Country() {

    }

    public Country(String name, double vat) {
        this.name = name;
        this.vat = vat;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
