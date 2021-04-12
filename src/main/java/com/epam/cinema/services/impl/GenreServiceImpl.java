package com.epam.cinema.services.impl;

import com.epam.cinema.models.Genre;
import com.epam.cinema.repos.GenreRepository;
import com.epam.cinema.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public Genre getGenre(String genreName) {
        return genreRepository.getGenre(genreName);
    }

    @Override
    public Genre createGenre(Genre film) {
        return genreRepository.createGenre(film);
    }

    @Override
    public Genre updateGenre(Genre film, String genreName) {
        return genreRepository.updateGenre(film, genreName);
    }

    @Override
    public void deleteGenre(String genreName) {
        genreRepository.deleteGenre(genreName);
    }
}
