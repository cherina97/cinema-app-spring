package com.epam.cinema.test.util;

import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.models.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDataUtil {

    public static final String TEST_EMAIL = "email@mail.com";
    public static final String TEST_EMAIL_UPDATE = "email@mail.com";

    public static User createUser() {
        return new User.Builder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .withEmail(TEST_EMAIL)
                .withPassword("password")
                .build();
    }

    public static UserDto createUserDTO() {
        return new UserDto.Builder()
                .withFirstName("firstName")
                .withLastName("lastName")
                .withEmail(TEST_EMAIL)
                .withPassword("password")
                .withRepeatPassword("password")
                .build();


    }
}
