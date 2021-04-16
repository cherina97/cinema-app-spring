package com.epam.cinema.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(name = "role_id")
    private int roleId;

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
