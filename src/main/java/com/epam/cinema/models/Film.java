package com.epam.cinema.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Time;

@Data
public class Film {

    @NotNull
    @Positive
    private int id;

    @NotBlank
    private String filmTitle;

    @NotBlank
    private String description;

    private Time duration;

//    private Blob poster;

    public static class Builder {
        private final Film film;

        public Builder() {
            film = new Film();
        }

        public Builder withId(int id) {
            film.id = id;
            return this;
        }

        public Builder withFilmTitle(String filmTitle) {
            film.filmTitle = filmTitle;
            return this;
        }

        public Builder withDescription(String description) {
            film.description = description;
            return this;
        }

        public Builder withDuration(Time duration) {
            film.duration = duration;
            return this;
        }

        public Film build() {
            return film;
        }
    }


}
