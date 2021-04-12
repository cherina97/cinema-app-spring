package com.epam.cinema.services;

import com.epam.cinema.models.Genre;

public interface GenreService {
    Genre getGenre(String genreName);

    Genre createGenre(Genre film);

    Genre updateGenre(Genre film, String genreName);

    void deleteGenre(String genreName);
}
