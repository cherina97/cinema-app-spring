package com.epam.cinema.dtos;

import com.epam.cinema.models.Genre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Blob;
import java.sql.Time;
import java.util.List;

@Data
public class FilmDto {

    private int id;
    @NotBlank
    private String filmTitle;
    @NotBlank
    private String description;
    private Time duration;
    private Blob poster;
    private List<Genre> genres;

    public static class Builder {
        private final FilmDto filmDto;

        public Builder() {
            filmDto = new FilmDto();
        }

        public Builder withId(int id) {
            filmDto.id = id;
            return this;
        }

        public Builder withFilmTitle(String filmTitle) {
            filmDto.filmTitle = filmTitle;
            return this;
        }

        public Builder withDescription(String description) {
            filmDto.description = description;
            return this;
        }

        public Builder withDuration(Time duration) {
            filmDto.duration = duration;
            return this;
        }

        public Builder withPoster(Blob poster){
            filmDto.poster = poster;
            return this;
        }

        public Builder withGenres(List<Genre> genres){
            filmDto.genres = genres;
            return this;
        }

        public FilmDto build() {
            return filmDto;
        }
    }

}
