package com.pluralsight.dealership.CarDealershipAPI.Controller;

import com.pluralsight.dealership.CarDealershipAPI.DaoModel.VehicleDAO;
import com.pluralsight.dealership.CarDealershipAPI.Model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {
    private VehicleDAO dao;

    @Autowired
    public VehicleController(VehicleDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "/vehicles/year", method = RequestMethod.GET)
    public Vehicle getYear(@RequestParam int minYear, int maxYear) {
        Vehicle vehicle = dao.getByYear(minYear, maxYear);
        return vehicle;
    }

    @RequestMapping(path = "/vehicles/make", method = RequestMethod.GET)
    public Vehicle getMake(@RequestParam String make) {
        Vehicle vehicle = dao.getByMake(make);
        return vehicle;
    }

    @RequestMapping(path = "/vehicles/model", method = RequestMethod.GET)
    public Vehicle getModel(@RequestParam String model) {
        Vehicle vehicle = dao.getByModel(model);
        return vehicle;
    }

    @RequestMapping(path = "/vehicles/type", method = RequestMethod.GET)
    public Vehicle getType(@RequestParam String type) {
        Vehicle vehicle = dao.getByType(type);
        return vehicle;
    }

    @RequestMapping(path = "/vehicles/color", method = RequestMethod.GET)
    public Vehicle getColor(@RequestParam String color) {
        Vehicle vehicle = dao.getByColor(color);
        return vehicle;
    }

    @RequestMapping(path = "/vehicles/miles", method = RequestMethod.GET)
    public Vehicle getMiles(@RequestParam int minMiles, int maxMiles) {
        Vehicle vehicle = dao.getByMiles(minMiles, maxMiles);
        return vehicle;
    }

    @RequestMapping(path = "/vehicles/price", method = RequestMethod.GET)
    public Vehicle getPrice(@RequestParam int minPrice, int maxPrice) {
        Vehicle vehicle = dao.getByPrice(minPrice, maxPrice);
        return vehicle;
    }
    @RequestMapping(path="/vehicles/add",method= RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vehicle addVehicle (@RequestBody String vin, int price, String make, String model, int year, String color, int miles, String type)
    {
        Vehicle newVehicle = VehicleDAO.insert(vin, price, make, model, year, color, miles, type);
        return newVehicle;
    }
}