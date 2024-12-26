package com.xworkz.shoppingapp.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Books {
    public static void main(String[] args) {
        System.out.println("Main Started");
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");// load/register
            System.out.println("class loaded");
            String url = "jdbc:mysql://localhost:3306/Shopping";
            String userName = "root";
            String password = "bilwesh";
            connection = DriverManager.getConnection(url, userName, password);
//            String insert = "insert into Books values(101,'The Alchemist','Paulo Coelho', 399.00)";
//            String insert = "insert into Books values(102,'Ikiga','Hector Garcia, Francesc Miralles', 350.00)";
//            String insert = "insert into Books values(103,'Sapiens: A Brief History of Humankind','Yuval Noah Harari', 499.99)";
//            String insert = "insert into Books values(104,'Rich Dad Poor Dad','Robert T. Kiyosaki', 450.00)";
            String insert = "insert into Books values(105,'Think and Grow Rich','Napoleon Hill', 299.00)";
            Statement statement =connection.createStatement();
            int row = statement.executeUpdate(insert);
            System.out.println(row+" Row is inserted.");
            System.out.println("DataBase connected");
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("DataBase not Connected."+e.getMessage());
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Main Ended");
    }
}
