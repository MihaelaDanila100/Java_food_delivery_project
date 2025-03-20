package repository;
import config.DatabaseConfig;
import products.Drink;

import java.sql.*;

public class DrinkRepository {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS drinks" +
                "(drinkId int PRIMARY KEY AUTO_INCREMENT, name varchar(30), quanity int)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getDrinkId(Drink d){
        String selectSql = "SELECT drinkId FROM drinks where name = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        String name = d.getName();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery(selectSql);
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public void insertDrink(Drink d) {
        String insertDrinkSql = "INSERT INTO drinks(name, quantity) VALUES(?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        String name = d.getName();
        int quantity = d.getQuanity();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertDrinkSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, quantity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteDrink(Drink d) {
        String deleteDrinkSql = "DELETE FROM drinks WHERE drinkId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        int drinkId = this.getDrinkId(d);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteDrinkSql);
            preparedStatement.setInt(1, drinkId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateDrink(int id, String nume, int quantity) {
        String deleteDrinkSql = "UPDATE drinks SET name = ?, quantity = ? WHERE drinkId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteDrinkSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
