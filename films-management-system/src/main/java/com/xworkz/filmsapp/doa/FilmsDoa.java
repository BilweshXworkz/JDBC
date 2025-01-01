package com.xworkz.filmsapp.doa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FilmsDoa {
    private int filmId;
    private String title;
    private int releaseYear;
    private String genre;
    private String director;
    private int rating;
}
