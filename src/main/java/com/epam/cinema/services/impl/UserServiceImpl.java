package com.epam.cinema.services.impl;

import com.epam.cinema.dtos.MapperUserToDto;
import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.models.User;
import com.epam.cinema.repos.UserRepository;
import com.epam.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements MapperUserToDto, UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        User user = userRepository.getUser(email);
        return MapperUserToDto.INSTANCE.fromUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = MapperUserToDto.INSTANCE.fromUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        return MapperUserToDto.INSTANCE.fromUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String email) {
        User user = MapperUserToDto.INSTANCE.fromUserDtoToUser(userDto);
        user = userRepository.updateUser(user, email);
        return MapperUserToDto.INSTANCE.fromUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }

    //use MapStruct for mapping
    @Override
    public UserDto fromUserToUserDto(User user) {
        if (user == null) {
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .roleId(user.getRoleId())
                .build();
    }

    @Override
    public User fromUserDtoToUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        return new User(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getRoleId());
    }
}
