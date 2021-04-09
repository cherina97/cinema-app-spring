package com.epam.cinema.repos;

import com.epam.cinema.models.User;

public interface UserRepository {

    User getUser(String email);

    User createUser(User user);

    User updateUser(User user, String email);

    void deleteUser(String email);
}
