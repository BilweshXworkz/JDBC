package com.xworkz.filmsapp;

import com.xworkz.filmsapp.doa.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class FilmsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilmsDoaImpl filmsDoa = new FilmsDoaImpl();
        System.out.println("Choose :");
        String val = null;
        do {
            System.out.println("1 Film Details Entering");
            System.out.println("2 Film Details");
            System.out.println("3 Update Film");
            System.out.println("4 Get By number of Film AND Rating");
            System.out.println("5 Get By number of Film OR Rating");
            System.out.println("6 Actors Details Entering");
            System.out.println("7 Actors Details");
            System.out.println("8 Update Actors");

            int option = scanner.nextInt();

            switch (option){
                case 1 :
                    FilmsDoa films = new FilmsDoa();
                    System.out.println("Enter the Films : ");
                    films.setTitle(scanner.next());
                    System.out.println("Enter the Year release : ");
                    films.setReleaseYear(scanner.nextInt());
                    System.out.println("Enter the genre : ");
                    films.setGenre(scanner.next());
                    System.out.println("Enter the Director Name : ");
                    films.setDirector(scanner.next());
                    System.out.println("Rating :");
                    films.setRating(scanner.nextInt());
                    filmsDoa.addFilms(
                            films.getTitle(),
                            films.getReleaseYear(),
                            films.getDirector(),
                            films.getGenre(),
                            films.getRating()
                    );
                    break;
                case 2:
                    ResultSet resultSet = filmsDoa.getFilmsDetails();
                    try{
                        boolean checkData =resultSet.next();
                        if (checkData){
                            while (resultSet.next()){
                                System.out.println("Film ID : "+resultSet.getInt(1)+", " +
                                        "Title : "+resultSet.getString(2)+", "+
                                        "Release Year : "+resultSet.getInt(3)+", "+
                                        "Director : "+resultSet.getString(4)+", "+
                                        "Genre : "+resultSet.getString(5)+", "+
                                        "Rating : "+resultSet.getString(6));
                            }
                        }
                        else System.out.println("Data Not Found");
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter the Id of the Film to be updated : ");
                    int  filmId = scanner.nextInt();
                    System.out.println("Enter the Film Title : ");
                    String filmName = scanner.next();
                    System.out.println("Enter the Release Year");
                    int releaseYear = scanner.nextInt();
                    int updateById = filmsDoa.getUpdateFilmsById(filmName, releaseYear, filmId);
                    System.out.println("Number of rows affected "+updateById);
                    break;
                case 4:
                    System.out.println("Enter the release year ");
                    int releaseYear1 = scanner.nextInt();
                    System.out.println("Enter Rating");
                    int rating1 = scanner.nextInt();
                    ResultSet resultSet1 = filmsDoa.getByReleaseYearANDRating(releaseYear1, rating1);
                    try{
                        boolean checkData = false;
                        while (resultSet1 != null && resultSet1.next()){
                            checkData = true;
                            System.out.println("Film ID : "+resultSet1.getInt(1)+", " +
                                    "Title : "+resultSet1.getString(2)+", "+
                                    "Release Year : "+resultSet1.getInt(3)+", "+
                                    "Director : "+resultSet1.getString(4)+", "+
                                    "Genre : "+resultSet1.getString(5)+", "+
                                    "Rating : "+resultSet1.getString(6));
                        }
                        if (!checkData){
                            System.out.println("Data Not Found");
                        }
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter the release year");
                    int releaseYear2 = scanner.nextInt();
                    System.out.println("Enter Rating");
                    int rating2 = scanner.nextInt();
                    ResultSet resultSet2 = filmsDoa.getByReleaseYearORRating(releaseYear2, rating2);
                    try {
                        boolean checkData = false;
                        while (resultSet2 != null && resultSet2.next()) {
                            checkData = true;
                            System.out.println("Film ID : "+resultSet2.getInt(1)+", " +
                                    "Title : "+resultSet2.getString(2)+", "+
                                    "Release Year : "+resultSet2.getInt(3)+", "+
                                    "Director : "+resultSet2.getString(4)+", "+
                                    "Genre : "+resultSet2.getString(5)+", "+
                                    "Rating : "+resultSet2.getInt(6));
                        }
                        if (!checkData) {
                            System.out.println("Data Not Found");
                        }
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    ActorsDoa actorsDoa  = new ActorsDoa();
                    System.out.println("Enter the Actor Name : ");
                    actorsDoa.setActorName(scanner.next());
                    System.out.println("Enter Actor age : ");
                    actorsDoa.setActorAge(scanner.nextInt());
                    System.out.println("Enter Nationality of Actors");
                    actorsDoa.setNationality(scanner.next());
                    filmsDoa.addActors(
                            actorsDoa.getActorName(),
                            actorsDoa.getActorAge(),
                            actorsDoa.getNationality()
                    );
                case 7:
                    ResultSet resultSet3 = filmsDoa.getActorsDetails();
                    try{
                        boolean checkData =resultSet3.next();
                        if (checkData){
                            while (resultSet3.next()){
                                System.out.println("ActorsId : "+resultSet3.getInt(1)+", " +
                                        "Actor Name : "+resultSet3.getString(2)+", "+
                                        "Age : "+resultSet3.getInt(3)+", "+
                                        "Nationality : "+resultSet3.getString(4));
                            }
                        }
                        else System.out.println("Data Not Found");
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Enter the Id of the Actors to be updated : ");
                    int  actorsId = scanner.nextInt();
                    System.out.println("Enter the sport name : ");
                    String actorName = scanner.next();
                    System.out.println("Enter the player age : ");
                    int actorAge = scanner.nextInt();
                    int updateByPlayerId = filmsDoa.getUpdateActorsById(actorName, actorAge, actorsId);
                    System.out.println("Number of rows affected "+updateByPlayerId);
                    break;
                default:
                    System.out.println("Please Enter the valid number");
            }
            System.out.println("Do you want to continue? (Type Yes or No)");
            val = scanner.next();
        }
        while(val.equalsIgnoreCase("Yes"));
        System.out.println("Thank You for Your Co-operation... ");
    }
}
