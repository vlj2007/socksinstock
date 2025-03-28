package ru.home.socksinstock.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ru.home.socksinstock.dto.SockDto;
import ru.home.socksinstock.entity.SockEntity;

@Mapper(componentModel = "spring")
@Component
public interface SockMapper {

    SockMapper INSTANCE = Mappers.getMapper(SockMapper.class);
    SockDto sockEntityToSockDto(SockEntity sockEntity);
    SockEntity sockDtoToSockEntity(SockDto sockDto);
}
