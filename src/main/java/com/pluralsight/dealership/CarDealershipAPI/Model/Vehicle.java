package com.pluralsight.dealership.CarDealershipAPI.Model;

public class Vehicle {
    private String vin;
    private int year;
    private String make;
    private String model;
    private String type;
    private String color;
    private int miles;
    private double price;

    public Vehicle(String vin, double price, String make, String model, int year, String color, int miles, String type) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.miles = miles;
        this.price = price;
    }

    public Vehicle() {
    }

    public Vehicle(long vin, String vin1, int price, String make, String model, int year, String color, int miles, String type) {
    }


    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getMiles() {
        return miles;
    }

    public double getPrice() {
        return price;
    }
}
