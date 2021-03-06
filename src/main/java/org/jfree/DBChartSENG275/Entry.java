package org.jfree.DBChartSENG275;


//Myfanwy wrote this, with lots of help from Hint 1
//helper class to get each DB entry, each Entry object simply holds the country name its associated value
public class Entry {
    private String country;
    private double value;

    public Entry(String country, double value) {
        this.country = country;
        this.value = value;
    }

    //getters, we need no setters, these were generated by IntelliJ
    public String getCountry() {
        return country;
    }

    public double getValue() {
        return value;
    }
}
