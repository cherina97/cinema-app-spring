package com.epam.cinema.mappers;

import com.epam.cinema.dtos.GenreDto;
import com.epam.cinema.models.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperGenre {

    MapperGenre INSTANCE = Mappers.getMapper(MapperGenre.class);

    GenreDto fromGenreToDTO(Genre genre);
    Genre fromDTOtoGenre(GenreDto genreDto);
}
