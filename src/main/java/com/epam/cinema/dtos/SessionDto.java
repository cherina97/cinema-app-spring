package com.epam.cinema.dtos;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class SessionDto {

    private int id;
    private int filmId;
    private Time startAt;
    private Date date;

    public static class Builder {
        private final SessionDto sessionDto;

        public Builder() {
            sessionDto = new SessionDto();
        }

        public Builder withId(int id) {
            sessionDto.id = id;
            return this;
        }

        public Builder withTimeStartAt(Time startAt) {
            sessionDto.startAt = startAt;
            return this;
        }

        public Builder withDate(Date date){
            sessionDto.date = date;
            return this;
        }

        public SessionDto build() {
            return sessionDto;
        }
    }

}
