package com.epam.cinema.controllers;

import com.epam.cinema.controllers.assemblers.UserAssembler;
import com.epam.cinema.controllers.models.UserModel;
import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.services.UserService;
import com.epam.cinema.validation.AdvanceInfo;
import com.epam.cinema.validation.BasicInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
@Slf4j
@Validated({BasicInfo.class, AdvanceInfo.class})
public class UserController {

    private final UserService userService;
    private final UserAssembler userAssembler;

    @GetMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserModel getUser(@PathVariable String email) {
        UserDto user = userService.getUser(email);
        return userAssembler.toModel(user);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel createUser(@Valid @RequestBody UserDto userDto) {
        log.info("Create user: {}", userDto);
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @PutMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserModel updateUser(@Valid @RequestBody UserDto userDto,
                              @PathVariable String email) {
        log.info("Update user: {} to user {}", email, userDto);
        UserDto user = userService.updateUser(userDto, email);
        return userAssembler.toModel(user);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        log.info("Delete user by email: {}", email);
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

}
