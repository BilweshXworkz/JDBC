package com.xworkz.shoppingapp.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class Stationery {
    public static void main(String[] args) {
        Connection connection = null;
        System.out.println("Main Started");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");// load/register
            System.out.println("class loaded");
            String url = "jdbc:mysql://localhost:3306/Shopping";
            String userName = "root";
            String password = "bilwesh";
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("DataBase connected");
//            String insert = "insert into Stationery values(101,'NoteBook', 50.00)";
//            String insert = "insert into Stationery (Stationery_Item, Price ) values('Ballpoint Pen', 20.00)";
//            String insert = "insert into Stationery (Stationery_Item, Price ) values('Pencil (Pack of 10)', 40.00)";
//            String insert = "insert into Stationery (Stationery_Item, Price ) values('Eraser', 10.00)";
//            String insert = "insert into Stationery (Stationery_Item, Price ) values('Geometry Box', 150.00)";
//            String insert = "insert into Stationery (Stationery_Item, Price ) values('Highlighter (Pack of 3)', 120.00)";
//            String insert = "insert into Stationery (Stationery_Item, Price ) values('Spiral Notebook', 120.00)";
//            String insert = "insert into Stationery (Stationery_Item, Price ) values('Sticky Notes (Pack of 3)', 90.00)";
//            String insert = "insert into Stationery (Stationery_Item, Price ) values('Whiteboard Marker (Pack of 4)', 180.00)";
            String insert = "insert into Stationery (Stationery_Item, Price ) values('A4 Size Paper (500 sheets)', 400.00)";
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(insert);
            System.out.println(row+" Row is created.");
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("DataBase not Connected."+e.getMessage());
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
