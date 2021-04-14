package com.epam.cinema.controllers;

import com.epam.cinema.api.UserApi;
import com.epam.cinema.controllers.assemblers.UserAssembler;
import com.epam.cinema.controllers.models.UserModel;
import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(String email) {
        UserDto user = userService.getUser(email);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        log.info("Create user: {}", userDto);
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel updateUser(UserDto userDto,
                                String email) {
        log.info("Update user: {} to user {}", email, userDto);
        UserDto user = userService.updateUser(userDto, email);
        return userAssembler.toModel(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String email) {
        log.info("Delete user by email: {}", email);
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

}
