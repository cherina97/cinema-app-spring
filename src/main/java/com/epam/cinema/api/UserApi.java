package com.epam.cinema.api;

import com.epam.cinema.controllers.models.UserModel;
import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.validation.AdvanceInfo;
import com.epam.cinema.validation.BasicInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "User management API")
@RequestMapping(value = "/api/v1/users")
@Validated({BasicInfo.class, AdvanceInfo.class})
public interface UserApi {

    @ApiOperation("Get user from Database")
    @GetMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    UserModel getUser(@PathVariable String email);

    @ApiOperation("Creating user")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    UserModel createUser(@Valid @RequestBody UserDto userDto);

    @ApiOperation("Update user")
    @PutMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    UserModel updateUser(@Valid @RequestBody UserDto userDto,
                         @PathVariable String email);

    @ApiOperation("Delete user from Database")
    @DeleteMapping(value = "/{email}")
    ResponseEntity<Void> deleteUser(@PathVariable String email);
}
