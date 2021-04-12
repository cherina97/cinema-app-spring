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

//    public User(int id, String firstName, String lastName, String email, String password, int roleId) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.roleId = roleId;
//    }

    public static class Builder{
        private final User user;

        public Builder() {
            user = new User();
        }

        public Builder withId(int id){
            user.id = id;
            return this;
        }

        public Builder withFirstName(String firstName){
            user.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            user.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email){
            user.email = email;
            return this;
        }

        public Builder withPassword(String password){
            user.password = password;
            return this;
        }

        public Builder withRoleId(int roleId){
            user.roleId = roleId;
            return this;
        }

        public User build(){
            return user;
        }
    }

}
