package com.epam.cinema.validation;

import com.epam.cinema.dtos.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto userDto = (UserDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.notblank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.notblank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.notblank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.notblank");

        String password = userDto.getPassword();
        if (password.length() <= 4){
            errors.rejectValue("password", "password.size");
        }

    }
}
