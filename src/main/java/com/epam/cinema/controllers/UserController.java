package com.epam.cinema.controllers;

import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("Create user: {}", userDto);
        return userService.createUser(userDto);
    }

    @PutMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@RequestBody UserDto userDto,
                              @PathVariable String email) {
        return userService.updateUser(userDto, email);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

}
