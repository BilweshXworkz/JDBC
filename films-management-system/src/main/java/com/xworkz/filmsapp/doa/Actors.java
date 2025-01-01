package com.xworkz.filmsapp.doa;

import java.sql.ResultSet;

public interface Actors {
    public boolean addActors( String actorName, int age, String nationality);
    public ResultSet getActorsDetails();
    public int getUpdateActorsById(String actorName, int age, int actorId);
}
