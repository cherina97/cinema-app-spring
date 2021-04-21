package com.epam.cinema.repos;

import com.epam.cinema.dtos.SessionDto;
import com.epam.cinema.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    Optional<Session> findById(int id);
}
