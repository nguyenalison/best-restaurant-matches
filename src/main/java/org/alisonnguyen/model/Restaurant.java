package org.alisonnguyen.model;

public class Restaurant {
    public Restaurant(String name, int customerRating, double distance, double price, String cuisine) {
        this.name = name;
        this.customerRating = customerRating;
        this.distance = distance;
        this.price = price;
        this.cuisine = cuisine;
    }

    private String name;
    private int customerRating;
    private double distance;
    private double price;
    private String cuisine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(int customerRating) {
        this.customerRating = customerRating;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "\nRestaurant: " + name + '\'' +
                " Rating: " + customerRating +
                " Distance: " + distance +
                " Price: " + price +
                " Cuisine: '" + cuisine + '\'';
    }

}
