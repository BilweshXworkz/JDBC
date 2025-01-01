package com.xworkz.sportapp.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PlayerDoaImpl {
    private int playerId;
    private String playerName;
    private int age;
    private String teamName;
    private String nationality;
    private String sportName;
}
