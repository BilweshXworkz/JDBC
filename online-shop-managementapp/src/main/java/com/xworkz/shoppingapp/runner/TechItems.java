package com.xworkz.shoppingapp.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TechItems {
    public static void main(String[] args) {
        System.out.println("Main Started");
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Database Connected");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shopping", "root", "bilwesh");
            String insert1 = "insert into Tech_Item values (101, 'Wireless Mouse', 700.00)";
            String insert2 = "insert into Tech_Item (Tech_Items , price) values ('Laptop Cooling Pad', 1200.00)";
            String insert3 = "insert into Tech_Item (Tech_Items , price) values ('External Hard Drive (1TB)', 4500.00)";
            String insert4 = "insert into Tech_Item (Tech_Items , price) values ('Bluetooth Headphones', 2000.00)";
            String insert5 = "insert into Tech_Item (Tech_Items , price) values ('USB-C Charger (Fast Charging)', 1500.00)";
            Statement statement = connection.createStatement();
            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            statement.addBatch(insert4);
            statement.addBatch(insert5);
            int[] row = statement.executeBatch();
            System.out.println(+row.length+ " Row is inserted");
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Database not Connected "+e.getMessage());
        }
        finally {
            try {
                connection.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Main Ended");
    }
}
