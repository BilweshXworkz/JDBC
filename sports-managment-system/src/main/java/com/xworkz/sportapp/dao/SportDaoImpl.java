package com.xworkz.sportapp.dao;

import java.sql.*;

public class SportDaoImpl implements SportDao, PlayerDao {

    static private String url = "jdbc:mysql://localhost:3306/SportsAndPlayers";
    static private String user = "root";
    static private String pass = "bilwesh";

    @Override
    public boolean addSportsDetails(String sportName, int playerCount, String originCountry, int popularity, String  olympic_sport) {
        boolean isAdded = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Database Loading...");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Database is connected");
            String query = "insert into sports values(?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1,0);
            statement.setString(2, sportName);
            statement.setInt(3,playerCount);
            statement.setString(4,originCountry);
            statement.setInt(5, popularity);
            statement.setString(6, olympic_sport);
            int row = statement.executeUpdate();
            System.out.println(row+" is inserted");
        }catch (ClassNotFoundException |SQLException e){
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
    public ResultSet getSportsDetails() {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            String query = "SELECT * FROM sports";
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int updateById(String sportName, int playerCount, int sportId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            statement =connection.prepareStatement("Update sports set sport_name = ?, player_count = ? where sport_id = ?");
            connection.setAutoCommit(false);
            statement.setString(1, sportName);
            statement.setInt(2, playerCount);
            statement.setInt(3, sportId);
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
    public ResultSet getByPlayersCountANDPopularity(int playerCount, int popularity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url, user,pass);
            String query = "SELECT * FROM sports WHERE player_count < ? AND popularity >= ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, playerCount);
            statement.setInt(2, popularity);
            return statement.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getByPlayersCountORPopularity(int playerCount, int popularity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url, user, pass);
            String query = "SELECT * FROM sports WHERE playerCount > ? OR popularity <=";
            statement.setInt(1, playerCount);
            statement.setInt(2, popularity);
            return statement.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean addPlayerDetails(String playerName, int age, String teamName, String nationality, String sportName) {
        boolean isAdded = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Database is connected");
            String query = "insert into players values(?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1,0);
            statement.setString(2, playerName);
            statement.setInt(3,age);
            statement.setString(4, teamName);
            statement.setString(5, nationality);
            statement.setString(6, sportName);
            int row = statement.executeUpdate();
            System.out.println(row+" is inserted");
        }catch (ClassNotFoundException |SQLException e){
            System.out.println(e.getMessage());
        }
        return isAdded;
    }

    @Override
    public ResultSet getPlayerDetails() {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            String query = "SELECT * FROM players";
            statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int updatePlayerById(String playerName, int age, int playerId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            statement =connection.prepareStatement("Update players set playerName = ?, age = ? where playerId = ?");
            connection.setAutoCommit(false);
            statement.setString(1, playerName);
            statement.setInt(2, age);
            statement.setInt(3, playerId);
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
