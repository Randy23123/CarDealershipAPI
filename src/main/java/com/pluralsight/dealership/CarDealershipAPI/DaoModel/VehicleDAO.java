package com.pluralsight.dealership.CarDealershipAPI.DaoModel;

import com.pluralsight.dealership.CarDealershipAPI.Model.Vehicle;

public interface VehicleDAO {
    Vehicle getByYear(int minYear,int maxYear);
    Vehicle getByMake(String make);
    Vehicle getByModel(String model);
    Vehicle getByType(String type);
    Vehicle getByColor(String color);
    Vehicle getByMiles(int minMiles,int maxMiles);
    Vehicle getByPrice(int minPrice,int maxPrice);
    Vehicle insert(String vin, int price, String make, String model, int year, String color, int miles, String type);
    void udpate(String vin, Vehicle vehicle);
    void delete(String vin);
}