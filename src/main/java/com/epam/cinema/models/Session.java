package com.epam.cinema.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "sessions")
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "film_id")
    private int filmId;
    @Column(name = "start_at")
    private Time startAt;
    private Date date;

    public static class Builder {
        private final Session session;

        public Builder() {
            session = new Session();
        }

        public Builder withId(int id) {
            session.id = id;
            return this;
        }

        public Builder withTimeStartAt(Time startAt) {
            session.startAt = startAt;
            return this;
        }

        public Builder withDate(Date date){
            session.date = date;
            return this;
        }

        public Session build() {
            return session;
        }
    }

}
