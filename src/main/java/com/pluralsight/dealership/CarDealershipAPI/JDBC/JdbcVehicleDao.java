package com.pluralsight.dealership.CarDealershipAPI.JDBC;

import com.pluralsight.dealership.CarDealershipAPI.DaoModel.VehicleDAO;
import com.pluralsight.dealership.CarDealershipAPI.Model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class JdbcVehicleDao implements VehicleDAO {
    private final DataSource dataSource;

    @Autowired
    public JdbcVehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Vehicle vehicleValues(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        if (resultSet.next()) {
            vehicle.setVin(resultSet.getString("Vin"));
            vehicle.setYear(resultSet.getInt("Year"));
            vehicle.setMake(resultSet.getString("Make"));
            vehicle.setModel(resultSet.getString("Model"));
            vehicle.setType(resultSet.getString("Type"));
            vehicle.setColor(resultSet.getString("Color"));
            vehicle.setMiles(resultSet.getInt("Mileage"));
            vehicle.setPrice(resultSet.getInt("Price"));
        }
        return vehicle;
    }

    @Override
    public Vehicle getByYear(int minYear, int maxYear) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Vehicles WHERE Year BETWEEN ? AND ?")
        ) {
            preparedStatement.setInt(1, minYear);
            preparedStatement.setInt(2, maxYear);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return vehicleValues(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle getByMake(String make) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Vehicles WHERE Make = ?")
        ) {
            preparedStatement.setString(1, make);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return vehicleValues(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle getByModel(String model) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Vehicles WHERE Model = ?")
        ) {
            preparedStatement.setString(1, model);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return vehicleValues(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle getByType(String type) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Vehicles WHERE Type = ?")
        ) {
            preparedStatement.setString(1, type);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return vehicleValues(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle getByColor(String color) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Vehicles WHERE Color = ?")
        ) {
            preparedStatement.setString(1, color);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return vehicleValues(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle getByMiles(int minMiles, int maxMiles) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Vehicles WHERE Mileage BETWEEN ? AND ?")
        ) {
            preparedStatement.setInt(1, minMiles);
            preparedStatement.setInt(2, maxMiles);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return vehicleValues(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle getByPrice(int minPrice, int maxPrice) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Vehicles WHERE Price BETWEEN ? AND ?")
        ) {
            preparedStatement.setInt(1, minPrice);
            preparedStatement.setInt(2, maxPrice);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return vehicleValues(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle insert(String vin, int price, String make, String model, int year, String color, int miles, String type) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO vehicles (VIN, Price, Make, Model, Year, Color, Mileage, Type) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, vin);
            preparedStatement.setInt(2, price);
            preparedStatement.setString(3, make);
            preparedStatement.setString(4, model);
            preparedStatement.setInt(5, year);
            preparedStatement.setString(6, color);
            preparedStatement.setInt(7, miles);
            preparedStatement.setString(8, type);

            int rows = preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                if (resultSet.next()) {
                    return new Vehicle(
                            resultSet.getLong("Vin"),
                            vin, price, make, model, year, color, miles, type);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void udpate(String vin, Vehicle vehicle) {

    }

    @Override
    public void delete(String vin) {

    }
}