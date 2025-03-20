package repository;

import config.DatabaseConfig;
import logistics.Car;

import java.sql.*;

public class CarRepository {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS cars" +
                "(carId int PRIMARY KEY AUTO_INCREMENT, name varchar(30), capacity double, disponibility tinyint)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCar(String name, int capacity, double disponibility) {
        String insertPersonSql = "INSERT INTO Car(Name, Capacity, Disponibility) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, capacity);
            preparedStatement.setDouble(3, disponibility);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/*
    public static void deleteCar(int carId) {
        String insertPersonSql = "DELETE FROM Car WHERE idCar = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, carId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCar(int carId,String name, int capacity, boolean disponibility) {
        String insertPersonSql = "UPDATE Car SET Name = ?, Capacity = ?, Disponibiblity = ? WHERE idCar = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, capacity);
            preparedStatement.setString(3, disponibility);
            preparedStatement.setString(4, carId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getCars(int idCar) {
        String insertPersonSql = "SELECT * FROM Car where carId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, idCar);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

}
