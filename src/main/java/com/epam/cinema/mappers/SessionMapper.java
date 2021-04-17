package com.epam.cinema.mappers;

import com.epam.cinema.dtos.SessionDto;
import com.epam.cinema.models.Session;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SessionMapper {
    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    SessionDto fromSessionToDTO(Session session);

    Session fromDTOtoSession(SessionDto sessionDto);
}
