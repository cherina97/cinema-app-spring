package com.epam.cinema.repos.impl;

import com.epam.cinema.models.User;
import com.epam.cinema.repos.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public User getUser(String email){
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User createUser(User user){
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user, String email){
        boolean userRemoved = users.removeIf(user1 -> user1.getEmail().equals(email));

        if (userRemoved){
            users.add(user);
        } else {
            throw new NoSuchElementException("No such user");
        }
        return user;
    }

    @Override
    public void deleteUser(String email){
        users.removeIf(user1 -> user1.getEmail().equals(email));
    }
}
