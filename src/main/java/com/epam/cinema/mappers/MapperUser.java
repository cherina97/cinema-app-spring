package com.epam.cinema.mappers;

import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperUser {

    MapperUser INSTANCE = Mappers.getMapper(MapperUser.class);

    @Mapping(target = "password", ignore = true)
    UserDto fromUserToUserDto(User user);

    User fromUserDtoToUser(UserDto userDto);
}
