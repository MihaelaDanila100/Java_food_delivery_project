package repository;
import config.DatabaseConfig;
import products.Drink;
import pubs.Bar;

import java.sql.*;
import java.util.List;

public class BarRepository {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS bars" +
                "(barId int PRIMARY KEY AUTO_INCREMENT, idDrinks varchar(100))";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertBar(List<Drink> drinks) {
        String insertBarSql = "INSERT INTO bars(idDrinks) VALUES(?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        DrinkRepository drinkRepository = new DrinkRepository();

        String myDrinks = "";

        for(Drink d:drinks){
            int id = drinkRepository.getDrinkId(d);
            myDrinks = myDrinks + "," + id;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertBarSql);
            preparedStatement.setString(1, myDrinks);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteBar(int barId) {
        String deleteBarSql = "DELETE FROM bars WHERE barId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteBarSql);
            preparedStatement.setInt(1, barId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateBar(int idBar, List<Drink> drinks) {
        String deleteDrinkSql = "UPDATE bars SET idDrinks = ? WHERE barId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        DrinkRepository drinkRepository = new DrinkRepository();

        String myDrinks = "";

        for(Drink d:drinks){
            int id = drinkRepository.getDrinkId(d);
            myDrinks = myDrinks + "," + id;
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteDrinkSql);
            preparedStatement.setString(1, myDrinks);
            preparedStatement.setInt(2, idBar);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
