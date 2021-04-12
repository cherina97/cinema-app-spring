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

    @NotNull(message = "{id.notnull}", groups = AdvanceInfo.class)
    @Positive(message = "{id.positive}", groups = AdvanceInfo.class)
    private int id;

    @NotBlank(message = "{firstName.notblank}", groups = BasicInfo.class)
    private String firstName;

    @NotBlank(message = "{lastName.notblank}", groups = BasicInfo.class)
    private String lastName;

    @NotNull(groups = {BasicInfo.class, AdvanceInfo.class})
    @Email(message = "{email.email}", groups = AdvanceInfo.class)
    private String email;

    @NotNull(groups = BasicInfo.class)
    @Size(min = 4, message = "{password.size}", groups = BasicInfo.class)
    private String password;

    @NotNull(groups = BasicInfo.class)
    private String repeatPassword;

    @NotNull(groups = AdvanceInfo.class)
    private int roleId;

//    public UserDto(int id, String firstName, String lastName, String email, int roleId) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.roleId = roleId;
//    }

    public static class Builder{
        private final UserDto userDto;

        public Builder() {
            userDto = new UserDto();
        }

        public UserDto.Builder withId(int id){
            userDto.id = id;
            return this;
        }

        public UserDto.Builder withFirstName(String firstName){
            userDto.firstName = firstName;
            return this;
        }

        public UserDto.Builder withLastName(String lastName){
            userDto.lastName = lastName;
            return this;
        }

        public UserDto.Builder withEmail(String email){
            userDto.email = email;
            return this;
        }

        public UserDto.Builder withPassword(String password){
            userDto.password = password;
            return this;
        }

        public UserDto.Builder withRepeatPassword(String repeatPassword){
            userDto.repeatPassword = repeatPassword;
            return this;
        }

        public UserDto.Builder withRoleId(int roleId){
            userDto.roleId = roleId;
            return this;
        }

        public UserDto build(){
            return userDto;
        }
    }
}
