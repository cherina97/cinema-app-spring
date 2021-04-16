package com.epam.cinema.dtos;

import com.epam.cinema.models.Film;
import lombok.Data;

import java.util.List;

@Data
public class GenreDto {

    private int id;
    private String genreName;
    private List<Film> films;

    public static class Builder{
        private final GenreDto genreDto;

        public Builder() {
            genreDto = new GenreDto();
        }

        public Builder withId(int id){
            genreDto.id = id;
            return this;
        }

        public Builder withGenreName(String genreName){
            genreDto.genreName = genreName;
            return this;
        }

        public Builder withFilms(String genreName){
            genreDto.genreName = genreName;
            return this;
        }

        public GenreDto build(){
            return genreDto;
        }
    }
}
