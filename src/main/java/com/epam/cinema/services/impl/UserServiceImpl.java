package com.epam.cinema.services.impl;

import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.exceptions.UserNotFoundException;
import com.epam.cinema.mappers.MapperUser;
import com.epam.cinema.models.User;
import com.epam.cinema.repos.UserRepository;
import com.epam.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements MapperUser, UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return MapperUser.INSTANCE.fromUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = MapperUser.INSTANCE.fromUserDtoToUser(userDto);
        user = userRepository.save(user);
        return MapperUser.INSTANCE.fromUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String email) {
        User user = MapperUser.INSTANCE.fromUserDtoToUser(userDto);
        if (userRepository.findByEmail(email).isPresent()) {
            userRepository.save(user);
        } else {
            throw new UserNotFoundException();
        }
        return MapperUser.INSTANCE.fromUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(MapperUser.INSTANCE::fromUserToUserDto)
                .collect(Collectors.toList());
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
