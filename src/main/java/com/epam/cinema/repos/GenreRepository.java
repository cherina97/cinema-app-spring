package com.epam.cinema.repos;

import com.epam.cinema.models.Genre;

public interface GenreRepository {
    Genre getGenre(String genreName);

    Genre createGenre(Genre genre);

    Genre updateGenre(Genre genre, String genreName);

    void deleteGenre(String genreName);
}
