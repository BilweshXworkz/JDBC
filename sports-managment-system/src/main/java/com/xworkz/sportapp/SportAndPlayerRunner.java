package com.xworkz.sportapp;

import com.xworkz.sportapp.dao.PlayerDoaImpl;
import com.xworkz.sportapp.dao.Sport;
import com.xworkz.sportapp.dao.SportDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SportAndPlayerRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SportDaoImpl sportDao = new SportDaoImpl();
        System.out.println("Choose :");
        String val = null;
        do {
            System.out.println("1 Sport Details Entering");
            System.out.println("2 Sports Details");
            System.out.println("3 Update Sport");
            System.out.println("4 Get By number of Players AND Popularity");
            System.out.println("5 Get By number of Players OR Popularity");
            System.out.println("6 Player Details Entering");
            System.out.println("7 Player Details");
            System.out.println("8 Update Player");

            int option = scanner.nextInt();

            switch (option){
                case 1 :
                    Sport sport = new Sport();
                    System.out.println("Enter the Sport : ");
                    sport.setSportName(scanner.next());
                    System.out.println("Enter Number of Players : ");
                    sport.setPlayerCount(scanner.nextInt());
                    System.out.println("Enter the origin Country : ");
                    sport.setOriginCountry(scanner.next());
                    System.out.println("Enter the number of the sports popularity");
                    sport.setPopularity(scanner.nextInt());
                    System.out.println("Is it olympic sport");
                    sport.setOlympic_sport(scanner.next());
                    sportDao.addSportsDetails(
                            sport.getSportName(),
                            sport.getPlayerCount(),
                            sport.getOriginCountry(),
                            sport.getPopularity(),
                            sport.getOlympic_sport()
                    );
                    break;
                case 2:
                    ResultSet resultSet = sportDao.getSportsDetails();
                    try{
                        boolean checkData =resultSet.next();
                        if (checkData){
                            while (resultSet.next()){
                                System.out.println("Sport ID : "+resultSet.getInt(1)+", " +
                                        "Sport Name : "+resultSet.getString(2)+", "+
                                        "Player Count : "+resultSet.getInt(3)+", "+
                                        "Origin Country : "+resultSet.getString(4)+", "+
                                        "Popularity : "+resultSet.getInt(5)+", "+
                                        "Olympic Sport : "+resultSet.getString(6));
                            }
                        }
                        else System.out.println("Data Not Found");
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter the Id of the sports to be updated : ");
                    int  sportId = scanner.nextInt();
                    System.out.println("Enter the sport name : ");
                    String sportName = scanner.next();
                    System.out.println("Enter the number of player count");
                    int playerCount = scanner.nextInt();
                    int updateById = sportDao.updateById(sportName, playerCount, sportId);
                    System.out.println("Number of rows affected "+updateById);
                    break;
                case 4:
                    System.out.println("Enter the players ");
                    int playerCount1 = scanner.nextInt();
                    System.out.println("Enter the Popularity");
                    int popularity = scanner.nextInt();
                    ResultSet resultSet1 = sportDao.getByPlayersCountANDPopularity(playerCount1, popularity);
                    try{
                        boolean checkData = false;
                        while (resultSet1 != null && resultSet1.next()){
                            checkData = true;
                            System.out.println("Sport ID : "+resultSet1.getInt(1)+", " +
                                        "Sport Name : "+resultSet1.getString(2)+", "+
                                        "Player Count : "+resultSet1.getInt(3)+", "+
                                        "Origin Country : "+resultSet1.getString(4)+", "+
                                        "Popularity : "+resultSet1.getInt(5)+", "+
                                        "Olympic Sport : "+resultSet1.getString(6));

                        }
                        if (!checkData){
                            System.out.println("Data Not Found");
                        }
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter the players");
                    int playerCount2 = scanner.nextInt();
                    System.out.println("Enter the Popularity");
                    int popularity2 = scanner.nextInt();
                    ResultSet resultSet2 = sportDao.getByPlayersCountORPopularity(playerCount2, popularity2);
                    try {
                        boolean checkData = false;
                        while (resultSet2 != null && resultSet2.next()) {
                            checkData = true;
                            System.out.println("Sport ID : " + resultSet2.getInt(1) + ", " +
                                    "Sport Name : " + resultSet2.getString(2) + ", " +
                                    "Player Count : " + resultSet2.getInt(3) + ", " +
                                    "Origin Country : " + resultSet2.getString(4) + ", " +
                                    "Popularity : " + resultSet2.getInt(5) + ", " +
                                    "Olympic Sport : " + resultSet2.getString(6));
                        }
                        if (!checkData) {
                            System.out.println("Data Not Found");
                        }
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    PlayerDoaImpl player = new PlayerDoaImpl();
                    System.out.println("Enter the Player Name : ");
                    player.setPlayerName(scanner.next());
                    System.out.println("Enter Players age : ");
                    player.setAge(scanner.nextInt());
                    System.out.println("Enter the team player plays : ");
                    player.setTeamName(scanner.next());
                    System.out.println("Enter Nationality of player");
                    player.setNationality(scanner.next());
                    System.out.println("Enter the sports the player plays");
                    player.setSportName(scanner.next());
                    sportDao.addPlayerDetails(
                            player.getPlayerName(),
                            player.getAge(),
                            player.getTeamName(),
                            player.getNationality(),
                            player.getSportName()
                    );
                case 7:
                    ResultSet resultSet3 = sportDao.getPlayerDetails();
                    try{
                        boolean checkData =resultSet3.next();
                        if (checkData){
                            while (resultSet3.next()){
                                System.out.println("Sport ID : "+resultSet3.getInt(1)+", " +
                                        "Player Name : "+resultSet3.getString(2)+", "+
                                        "Player Age : "+resultSet3.getInt(3)+", "+
                                        "Team Name : "+resultSet3.getString(4)+", "+
                                        "Nationality : "+resultSet3.getString(5)+", "+
                                        "Sport Name : "+resultSet3.getString(6));
                            }
                        }
                        else System.out.println("Data Not Found");
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Enter the Id of the Player to be updated : ");
                    int  playerId = scanner.nextInt();
                    System.out.println("Enter the sport name : ");
                    String playerName = scanner.next();
                    System.out.println("Enter the player age : ");
                    int playerAge = scanner.nextInt();
                    int updateByPlayerId = sportDao.updatePlayerById(playerName, playerAge, playerId);
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
