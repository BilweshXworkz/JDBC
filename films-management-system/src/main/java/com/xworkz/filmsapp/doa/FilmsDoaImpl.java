package com.xworkz.filmsapp.doa;

import java.sql.*;

public class FilmsDoaImpl implements Films, Actors {

    static private String url = "jdbc:mysql://localhost:3306/FilmsAndActors";
    static private String user = "root";
    static private String pass = "bilwesh";

    public boolean addFilms(String title, int releaseYear, String genre, String director, int rating) {
        boolean isAdded = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Database Loading...");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Database is connected");
            String query = "insert into films values(?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1,0);
            statement.setString(2, title);
            statement.setInt(3, releaseYear);
            statement.setString(4, genre);
            statement.setString(5, director);
            statement.setInt(6, rating);
            int row = statement.executeUpdate();
            System.out.println(row+" is inserted");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return isAdded;
    }


    @Override
    public ResultSet getFilmsDetails() {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            String query = "SELECT * FROM films";
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int getUpdateFilmsById(String title, int releaseYear, int filmId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            statement =connection.prepareStatement("Update sports set title = ?, releaseYear = ? where filmId = ?");
            connection.setAutoCommit(false);
            statement.setString(1, title);
            statement.setInt(2, releaseYear);
            statement.setInt(3, filmId);
            int row = statement.executeUpdate();
            connection.commit();
            return row;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            try{
                connection.rollback();
            }catch (SQLException error){
                System.out.println(error.getMessage());
            }
        }
        return 0;
    }

    @Override
    public ResultSet getByReleaseYearANDRating(int releaseYear, int rating) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url, user,pass);
            String query = "SELECT * FROM films WHERE releaseYear < ? AND rating >= ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, releaseYear);
            statement.setInt(2, rating);
            return statement.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getByReleaseYearORRating(int releaseYear, int rating) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url, user, pass);
            String query = "SELECT * FROM films WHERE releaseYear > ? OR rating <=";
            statement.setInt(1, releaseYear);
            statement.setInt(2, rating);
            return statement.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean addActors(String actorName, int age, String nationality) {
        boolean isAdded = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Database is connected");
            String query = "insert into actors values(?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1,0);
            statement.setString(2, actorName);
            statement.setInt(3,age);
            statement.setString(4, nationality);
            int row = statement.executeUpdate();
            System.out.println(row+" is inserted");
        }catch (ClassNotFoundException |SQLException e){
            System.out.println(e.getMessage());
        }
        return isAdded;
    }

    @Override
    public ResultSet getActorsDetails() {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            String query = "SELECT * FROM actors";
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int getUpdateActorsById(String actorName, int age, int actorId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            statement =connection.prepareStatement("Update actors set actor_name = ?, age = ? where actor_id = ?");
            connection.setAutoCommit(false);
            statement.setString(1, actorName);
            statement.setInt(2, age);
            statement.setInt(3, actorId);
            int row = statement.executeUpdate();
            connection.commit();
            return row;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            try{
                connection.rollback();
            }catch (SQLException error){
                System.out.println(error.getMessage());
            }
        }
        return 0;
    }
}
