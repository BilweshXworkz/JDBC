package com.xworkz.sportapp.dao;

import java.sql.ResultSet;

public interface SportDao {
    public boolean addSportsDetails(String sportName, int playerCount, String originCountry, int popularity, String  olympic_sport);
    public ResultSet getSportsDetails();
    public int updateById(String sportName, int playerCount, int sportId);
    public ResultSet getByPlayersCountANDPopularity(int playerCount, int popularity);
    public ResultSet getByPlayersCountORPopularity(int playerCount, int popularity);
}
