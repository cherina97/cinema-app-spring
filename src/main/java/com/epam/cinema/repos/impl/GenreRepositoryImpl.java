package com.epam.cinema.repos.impl;

import com.epam.cinema.models.Genre;
import com.epam.cinema.repos.GenreRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class GenreRepositoryImpl implements GenreRepository {

    private final List<Genre> genres = new ArrayList<>();

    @Override
    public Genre getGenre(String genreName){
        return genres.stream()
                .filter(genre -> genre.getGenreName().equals(genreName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Genre createGenre(Genre genre){
        genres.add(genre);
        return genre;
    }

    @Override
    public Genre updateGenre(Genre genre, String genreName){
        boolean genreRemoved = genres
                .removeIf(genre1 -> genre1.getGenreName().equals(genreName));

        if (genreRemoved){
            genres.add(genre);
        } else {
            throw new NoSuchElementException("No such genre");
        }
        return genre;
    }

    @Override
    public void deleteGenre(String genreName){
        genres.removeIf(genre -> genre.getGenreName().equals(genreName));
    }
}
