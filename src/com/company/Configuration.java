package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "configuration")
@JsonPropertyOrder({"country", "current_country"})
public class Configuration {

    //@JacksonXmlProperty(localName = "current_country")
    @JsonProperty("current_country")
    private String currentCountry;

    //@JacksonXmlProperty(localName = "countries")
    //@JacksonXmlElementWrapper(useWrapping = true)
    @JsonProperty("countries")
    private List<Country> countries;

    public String getCurrentCountry() {
        return currentCountry;
    }

    public void setCurrentCountry(String currentCountry) {
        this.currentCountry = currentCountry;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public double getDefaultTax() {
        var result = countries.stream().filter(c->c.getName().equals(currentCountry)).findFirst();

        if(result.isPresent()) {
            return result.get().getVat();
        }

        return 0.0;
    }

    public double getTaxForCountry(String countryName) {
        var result = countries.stream().filter(c->c.getName().equals(countryName)).findFirst();

        if(result.isPresent()) {
            return result.get().getVat();
        }

        return 0.0;
    }
}
