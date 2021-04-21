package com.epam.cinema.services.impl;

import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.models.User;
import com.epam.cinema.repos.UserRepository;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.cinema.test.util.TestDataUtil.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void getUserTest() {
        User user = createUser();
        when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(Optional.of(user));

        UserDto userDto = userService.getUser(TEST_EMAIL);

//        assertEquals(userDto.getEmail(), user.getEmail());
        MatcherAssert.assertThat(userDto, allOf(
                hasProperty("email", equalTo(user.getEmail())),
                hasProperty("firstName", equalTo(user.getFirstName()))
        ));
    }

    @Test
    void createUserTest() {
//        when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(null);

        User user = createUser();
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        UserDto userDto = userService.createUser(createUserDTO());

//        verify(userRepository, times(1)).save(Mockito.any(User.class));
//        assertEquals(userDto.getEmail(), user.getEmail());
        MatcherAssert.assertThat(userDto, allOf(
                hasProperty("email", equalTo(user.getEmail())),
                hasProperty("firstName", equalTo(user.getFirstName()))
        ));
    }


    @Test
    void updateUserTest() {
        User user = createUser();
        when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(Optional.of(user));

        UserDto userDTO = createUserDTO();
        userDTO = userService.updateUser(userDTO, TEST_EMAIL_UPDATE);

        assertNotEquals(userDTO.getEmail(), user.getEmail());
    }

    @Test
    void deleteUserTest() {
        User user = createUser();
        when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(Optional.of(user));

        userService.deleteUser(user.getEmail());

        verify(userRepository, times(1)).delete(user);
    }

    @Test
    void getAllUsersTest() {
        List<User> users = new ArrayList<>();
        User user = createUser();
        User user2 = createUser();
        users.add(user);
        users.add(user2);

        when(userRepository.findAll()).thenReturn(users);

        userService.getAllUsers();

        verify(userRepository).findAll();
    }
}