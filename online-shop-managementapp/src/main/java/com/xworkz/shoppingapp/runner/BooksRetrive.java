package com.xworkz.shoppingapp.runner;

import java.sql.*;

public class BooksRetrive {
    public static void main(String[] args) {
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
            String query = "select * from Shopping.books";
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            System.out.println("BookID : "+ resultSet.getInt(1)+ ", Book_Name : "+resultSet.getString(2)+ ", Author : "+resultSet.getString(3)+ ", Price : "+resultSet.getInt(4));

            resultSet.next();
            System.out.println("BookID : "+ resultSet.getInt(1)+ ", Book_Name : "+resultSet.getString(2)+ ", Author : "+resultSet.getString(3)+ ", Price : "+resultSet.getInt(4));

            resultSet.next();
            System.out.println("BookID : "+ resultSet.getInt(1)+ ", Book_Name : "+resultSet.getString(2)+ ", Author : "+resultSet.getString(3)+ ", Price : "+resultSet.getInt(4));

            resultSet.next();
            System.out.println("BookID : "+ resultSet.getInt(1)+ ", Book_Name : "+resultSet.getString(2)+ ", Author : "+resultSet.getString(3)+ ", Price : "+resultSet.getInt(4));

            resultSet.next();
            System.out.println("BookID : "+ resultSet.getInt(1)+ ", Book_Name : "+resultSet.getString(2)+ ", Author : "+resultSet.getString(3)+ ", Price : "+resultSet.getInt(4));

            resultSet.next();
            System.out.println("BookID : "+ resultSet.getInt(1)+ ", Book_Name : "+resultSet.getString(2)+ ", Author : "+resultSet.getString(3)+ ", Price : "+resultSet.getInt(4));


        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("The JDBC is not connected"+e.getMessage());
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
