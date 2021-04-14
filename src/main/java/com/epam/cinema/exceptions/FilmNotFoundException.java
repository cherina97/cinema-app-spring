package com.epam.cinema.exceptions;

import com.epam.cinema.models.enums.ErrorType;

public class FilmNotFoundException extends ServiceException{
    private static final String DEFAULT_MASSAGE = "Film is not found!";

    public FilmNotFoundException() {
    }

    public FilmNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
