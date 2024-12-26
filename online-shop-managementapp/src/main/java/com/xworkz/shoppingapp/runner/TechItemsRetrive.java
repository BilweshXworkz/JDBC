package com.xworkz.shoppingapp.runner;

import java.sql.*;

public class TechItemsRetrive {
    public static void main(String[] args) {
        System.out.println("Main Started");
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("class loaded");
            String url = "jdbc:mysql://localhost:3306/Shopping";
            String userName = "root";
            String password = "bilwesh";
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("DataBase connected");
            statement = connection.createStatement(); // nullPointerException
            String query = "SELECT * FROM shopping.tech_item where Id = 103";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("ID : " + resultSet.getInt(1) + ", Tech_Name : " + resultSet.getString(2) + ", Price : " + resultSet.getInt(3));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("The JDBC is not connected" + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Main Ended");
    }
}
