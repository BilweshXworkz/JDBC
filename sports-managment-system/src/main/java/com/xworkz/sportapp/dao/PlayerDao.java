package com.xworkz.sportapp.dao;

import java.sql.ResultSet;

public interface PlayerDao {

    public boolean addPlayerDetails(String playerName, int age, String teamName, String nationality, String sportName);
    public ResultSet getPlayerDetails();
    public int updatePlayerById(String playerName, int age, int playerId);
}
