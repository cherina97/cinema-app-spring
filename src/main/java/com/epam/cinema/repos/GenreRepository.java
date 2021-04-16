package com.epam.cinema.repos;

import com.epam.cinema.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Optional<Genre> findByGenreName(String genreName);
}
