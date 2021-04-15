package com.epam.cinema.dtos;

import com.epam.cinema.constraints.EqualFields;
import com.epam.cinema.validation.AdvanceInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualFields(baseField = "password", matchField = "repeatPassword")
public class UserDto {

   private int id;
    private String firstName;
    private String lastName;
    @Email(message = "{email.email}", groups = AdvanceInfo.class)
    private String email;
    private String password;
    private String repeatPassword;
    private int roleId;

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
