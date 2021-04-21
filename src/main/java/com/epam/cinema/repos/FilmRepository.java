package com.epam.cinema.repos;

import com.epam.cinema.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    Optional<Film> findByFilmTitle (String filmTitle);
}
