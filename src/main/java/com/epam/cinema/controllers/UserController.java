package com.epam.cinema.controllers;

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

    @GetMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        log.info("Create user: {}", userDto);
        return userService.createUser(userDto);
    }

    @PutMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@Valid @RequestBody UserDto userDto,
                              @PathVariable String email) {
        log.info("Update user: {} to user {}", email, userDto);
        return userService.updateUser(userDto, email);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        log.info("Delete user by email: {}", email);
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

}
