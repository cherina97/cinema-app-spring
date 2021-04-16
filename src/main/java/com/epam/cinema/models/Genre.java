package com.epam.cinema.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "genre_name")
    private String genreName;
    @ManyToMany
    @JoinTable(name = "genre_film",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> films;

    public static class Builder{
        private final Genre genre;

        public Builder() {
            genre = new Genre();
        }

        public Builder withId(int id){
            genre.id = id;
            return this;
        }

        public Builder withGenreName(String genreName){
            genre.genreName = genreName;
            return this;
        }

        public Genre build(){
            return genre;
        }
    }

}
