package com.epam.cinema.controllers;

import com.epam.cinema.api.UserApi;
import com.epam.cinema.controllers.assemblers.UserAssembler;
import com.epam.cinema.controllers.models.UserModel;
import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.services.UserService;
import com.epam.cinema.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;
    private final UserValidator userValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(userValidator);
    }

    @Override
    public UserModel getUser(String email) {
        UserDto user = userService.getUser(email);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel createUser(@Valid UserDto userDto) {
        log.info("Create user: {}", userDto);
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel updateUser(@Valid UserDto userDto,
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

    @Override
    public List<UserModel> getAllUsers(){
        log.info("Getting all users from DB");
        return userService.getAllUsers()
                .stream()
                .map(userAssembler::toModel)
                .collect(Collectors.toList());
    }

}
