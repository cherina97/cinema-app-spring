package com.epam.cinema.mappers;

import com.epam.cinema.dtos.FilmDto;
import com.epam.cinema.models.Film;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperFilm {
    MapperFilm INSTANCE = Mappers.getMapper(MapperFilm.class);

    FilmDto fromFilmToFilmDto(Film film);

    Film fromFilmDtoToFilm(FilmDto filmDto);
}
