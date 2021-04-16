package com.epam.cinema.services;

import com.epam.cinema.dtos.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUser(String email);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, String email);

    void deleteUser(String email);

    List<UserDto> getAllUsers();
}
