package com.demoblaze.automation.models;


public class Data {
    private String name;
    private String cardNumber;
    private String country;
    private String city;
    private String month;
    private String year;


    public Data(String name, String cardNumber, String country, String city,
                String month, String year) {

        this.name = name;
        this.cardNumber = cardNumber;
        this.country = country;
        this.city = city;
        this.month = month;
        this.year = year;

    }


    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }


}