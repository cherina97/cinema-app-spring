package com.epam.cinema.exceptions;

import com.epam.cinema.models.enums.ErrorType;

public class SessionNotFoundException extends ServiceException{
    private static final String DEFAULT_MASSAGE = "Session is not found!";

    public SessionNotFoundException() {
    }

    public SessionNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
