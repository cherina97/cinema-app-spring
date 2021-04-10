package com.epam.cinema.dtos;

import com.epam.cinema.constraints.EqualFields;
import com.epam.cinema.validation.AdvanceInfo;
import com.epam.cinema.validation.BasicInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualFields(baseField = "password", matchField = "repeatPassword")
public class UserDto {

    @NotNull(groups = AdvanceInfo.class)
    @Positive(groups = AdvanceInfo.class)
    private int id;

    @NotBlank(groups = BasicInfo.class)
    private String firstName;

    @NotBlank(groups = BasicInfo.class)
    private String lastName;

    @NotNull(groups = {BasicInfo.class, AdvanceInfo.class})
    @Email(groups = AdvanceInfo.class)
    private String email;

    @NotNull(groups = BasicInfo.class)
    @Size(min = 4, message = "Psw should`t be less than 4", groups = BasicInfo.class)
    private String password;

    @NotNull(groups = BasicInfo.class)
    private String repeatPassword;

    @NotNull(groups = AdvanceInfo.class)
    private int roleId;

    public UserDto(int id, String firstName, String lastName, String email, int roleId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleId = roleId;
    }
}
