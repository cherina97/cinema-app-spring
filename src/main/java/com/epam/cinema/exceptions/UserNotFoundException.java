package com.epam.cinema.exceptions;

import com.epam.cinema.models.enums.ErrorType;

public class UserNotFoundException extends ServiceException{

    private static final String DEFAULT_MASSAGE = "User is not found!";

    public UserNotFoundException() {
        super(DEFAULT_MASSAGE);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
