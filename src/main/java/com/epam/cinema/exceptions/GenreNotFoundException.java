package com.epam.cinema.exceptions;

import com.epam.cinema.models.enums.ErrorType;

public class GenreNotFoundException extends ServiceException{
    private static final String DEFAULT_MASSAGE = "Genre is not found!";

    public GenreNotFoundException() {
    }

    public GenreNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
