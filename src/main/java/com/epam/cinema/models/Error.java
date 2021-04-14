package com.epam.cinema.models;

import com.epam.cinema.models.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {

    private String massage;
    private ErrorType errorType;
    private LocalDateTime timeStamp;

}
