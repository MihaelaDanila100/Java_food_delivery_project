package repository;
import config.DatabaseConfig;
import users.User;

import java.sql.*;
import java.util.List;

public class UserRepository {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS users" +
                "(userId int PRIMARY KEY AUTO_INCREMENT, firstName varchar(30), lastName varchar(30), city varchar(30), addresses varchar(100), orders varchar(100))";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getCityUser(int id){
        String selectSql = "SELECT * FROM users where userId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(selectSql);
            return resultSet.getString(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "-1";
    }

    public void insertUser(User user) {
        String insertPersonSql = "INSERT INTO users(firstName, lastName, city, addresses) VALUES(?, ?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        String firstN = user.getFirstName();
        String lastN = user.getLastName();
        String city = user.getCity();
        List<String> addresses = user.getAddresses();
        String adrese = "";
        for(String adresa: addresses){
            adrese = adrese + "," + adresa;
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, firstN);
            preparedStatement.setString(2, lastN);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, adrese);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deletUser(int nr) {
        String deleteUserSql = "DELETE FROM users WHERE userId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteUserSql);
            preparedStatement.setInt(1, nr);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateUser(int id, String firstName, String lastName, String city, List<String> addresses) {
        String deleteUserSql = "UPDATE users SET firstName = ?, lastName = ?, city = ?, addresses=? WHERE userId = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        String myAddress = "";
        for(String a:addresses){
            myAddress = myAddress + "," + a;
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteUserSql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, myAddress);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
