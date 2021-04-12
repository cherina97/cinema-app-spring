package com.epam.cinema.services.impl;

import com.epam.cinema.mappers.MapperUser;
import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.models.User;
import com.epam.cinema.repos.UserRepository;
import com.epam.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements MapperUser, UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        User user = userRepository.getUser(email);
        return MapperUser.INSTANCE.fromUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = MapperUser.INSTANCE.fromUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        return MapperUser.INSTANCE.fromUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String email) {
        User user = MapperUser.INSTANCE.fromUserDtoToUser(userDto);
        user = userRepository.updateUser(user, email);
        return MapperUser.INSTANCE.fromUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }

    @Override
    public UserDto fromUserToUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto.Builder()
                .withId(user.getId())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmail(user.getEmail())
                .withRoleId(user.getRoleId())
                .build();
    }

    @Override
    public User fromUserDtoToUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        return new User.Builder()
                .withId(userDto.getId())
                .withFirstName(userDto.getFirstName())
                .withLastName(userDto.getLastName())
                .withEmail(userDto.getEmail())
                .withPassword(userDto.getPassword())
                .withRoleId(userDto.getRoleId())
                .build();
    }
}
