package ru.home.socksinstock.api;

import ru.home.socksinstock.dto.SockDto;
import ru.home.socksinstock.entity.SockEntity;

public interface SockInterface {
    SockEntity createSock(SockDto sockDto);


}
