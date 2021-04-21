package com.epam.cinema.services.impl;

import com.epam.cinema.dtos.GenreDto;
import com.epam.cinema.exceptions.GenreNotFoundException;
import com.epam.cinema.mappers.MapperGenre;
import com.epam.cinema.models.Genre;
import com.epam.cinema.repos.GenreRepository;
import com.epam.cinema.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService, MapperGenre {

    private final GenreRepository genreRepository;

    @Override
    public GenreDto getGenre(String genreName) {
        Genre genre = genreRepository.findByGenreName(genreName)
                .orElseThrow(GenreNotFoundException::new);
        return MapperGenre.INSTANCE.fromGenreToDTO(genre);
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        Genre genre = MapperGenre.INSTANCE.fromDTOtoGenre(genreDto);
        genre = genreRepository.save(genre);
        return MapperGenre.INSTANCE.fromGenreToDTO(genre);
    }

    @Override
    public GenreDto updateGenre(GenreDto genreDto, String genreName) {
        Genre genre = MapperGenre.INSTANCE.fromDTOtoGenre(genreDto);
        if (genreRepository.findByGenreName(genreName).isPresent()) {
            genreRepository.save(genre);
        } else {
            throw new GenreNotFoundException();
        }
        return MapperGenre.INSTANCE.fromGenreToDTO(genre);
    }


    @Override
    public void deleteGenre(String genreName) {
        Genre genre = genreRepository.findByGenreName(genreName)
                .orElseThrow(GenreNotFoundException::new);
        genreRepository.delete(genre);
    }

    @Override
    public List<GenreDto> getAllGenres() {
        return genreRepository.findAll()
                .stream()
                .map(MapperGenre.INSTANCE::fromGenreToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GenreDto fromGenreToDTO(Genre genre) {
        return new GenreDto.Builder()
                .withId(genre.getId())
                .withGenreName(genre.getGenreName())
                .build();
    }

    @Override
    public Genre fromDTOtoGenre(GenreDto genreDto) {
        return new Genre.Builder()
                .withId(genreDto.getId())
                .withGenreName(genreDto.getGenreName())
                .build();
    }
}
