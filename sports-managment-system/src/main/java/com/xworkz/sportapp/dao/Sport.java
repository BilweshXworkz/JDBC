package com.xworkz.sportapp.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Sport {
    private int sportId;
    private String sportName;
    private int playerCount;
    private String originCountry;
    private int popularity;
    private String olympic_sport;
}
