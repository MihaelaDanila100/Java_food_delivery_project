package repository;

import config.DatabaseConfig;
import products.Drink;
import users.BarOrder;

import java.sql.*;
import java.util.List;

public class OrdersRepository {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS orders" +
                "(orderId int PRIMARY KEY AUTO_INCREMENT, drinks varchar(30))";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertOrder(List<Drink> myDrinks) {
        String insertOrder = "INSERT INTO orders(drinks) VALUES(?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        String drinkNames = "";
        for(Drink drink:myDrinks){
            drinkNames = drinkNames + "," + drink.getName();
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertOrder);
            preparedStatement.setString(1, drinkNames);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String getDrinksFromOrder(int nr){
        String selectSql = "SELECT * FROM order where orderId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, nr);
            ResultSet resultSet = preparedStatement.executeQuery(selectSql);
            return resultSet.getString(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void deleteOrder(int orderId) {
        String deleteOrderSql = "DELETE FROM orders WHERE orderId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteOrderSql);
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateOrder(int orderId, List<Drink>drinks) {
        String updateOrderSql = "UPDATE Order SET drinks = ? WHERE orderId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        String myDrinks = "";
        for(Drink drink:drinks){
            myDrinks = myDrinks + "," + drink.getName();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateOrderSql);
            preparedStatement.setString(1, myDrinks);
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
