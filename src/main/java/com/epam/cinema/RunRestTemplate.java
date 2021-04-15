package com.epam.cinema;

import com.epam.cinema.dtos.UserDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RunRestTemplate {
    static final String URL_GET_USER = "http://localhost:8080/api/v1/users/email@mail.com";
    static final String URL_CREATE_USER = "http://localhost:8080/api/v1/users";
    static final String URL_DELETE_USER = "http://localhost:8080/api/v1/users/email@mail.com";

    public static void main(String[] args) {

        //get user
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto> entity = restTemplate.getForEntity(URL_GET_USER, UserDto.class);
        System.out.println(entity);

        //create user
        UserDto userDto = new UserDto.Builder()
                .withId(1)
                .withFirstName("fn")
                .withLastName("ln")
                .withEmail("email@mail.com")
                .withPassword("passw")
                .withRepeatPassword("passw")
                .withRoleId(1)
                .build();
        HttpEntity<UserDto> requestBody = new HttpEntity<>(userDto);
        ResponseEntity<UserDto> result = restTemplate.postForEntity(URL_CREATE_USER, requestBody, UserDto.class);
        System.out.println("Status code:" + result.getStatusCode());

        if (result.getStatusCode() == HttpStatus.OK) {
            UserDto body = result.getBody();
            System.out.println("(Client Side) UserDto Created: "+ body);
        }

        //delete user
        restTemplate.delete(URL_DELETE_USER);
        ResponseEntity<UserDto> user = restTemplate.getForEntity(URL_DELETE_USER, UserDto.class);
        System.out.println("(Client side) Employee after delete: ");
        System.out.println("UserDto: " + user);

    }
}
