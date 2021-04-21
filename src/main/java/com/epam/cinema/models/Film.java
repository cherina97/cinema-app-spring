package com.epam.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "films")
@Data
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "film_title")
    private String filmTitle;
    private String description;
    private Time duration;
    @ManyToMany
    @JoinTable(name = "genre_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @JsonIgnore
    private List<Genre> genres;


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

        public Builder withGenres(List<Genre> genres) {
            film.genres = genres;
            return this;
        }

        public Film build() {
            return film;
        }
    }


}
