package com.epam.cinema.models;

import lombok.Data;

@Data
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int roleId;

    public User(int id, String firstName, String lastName, String email, String password, int roleId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

}
