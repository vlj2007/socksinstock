package ru.home.socksinstock.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.home.socksinstock.api.SockInterface;
import ru.home.socksinstock.dto.SockDto;
import ru.home.socksinstock.entity.SockEntity;
import ru.home.socksinstock.exception.SockEntityNotFoundException;
import ru.home.socksinstock.mapper.SockMapper;
import ru.home.socksinstock.repository.SockRepository;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class SockService implements SockInterface {
    Logger logger = LoggerFactory.getLogger(SockService.class);
    private final SockRepository sockRepository;
    private final SockMapper sockMapper;

    /***
     * Метод создающий носки
     */
    @Override
    public SockEntity createSock(SockDto sockDto) {
        logger.info("Was invoked method for added");
        return sockRepository.save(sockMapper.sockDtoToSockEntity(sockDto));
    }
    /***
     * Метод получающий носки по id
     */
    public SockDto getSockById(Long id) {
        logger.info("Was invoked method for find by id");
        return sockMapper.sockEntityToSockDto(
                sockRepository.
                        findById(id)
                        .orElseThrow(() -> new SockEntityNotFoundException("Sock not found with id: " + id))
        );
    }
    /***
     * Метод ищущий носки
     */
    public SockDto findSock(Long id) {
//
        return null;
    }

    /***
     * Метод редактирования носка по id
     */

    public SockDto editSock(SockDto sockDto) {
//        return sockRepository.save(sockDto);
        return null;

    }

    /***
     * Метод удаления носка по id
     */

    // Метод удаления носков
    public void deleteSock(Long id) {
        sockRepository.deleteById(id);
    }

    /***
     * Метод получения всех коллекции носков
     */

    public Collection<SockDto> getAllSock() {
//        return sockRepository.findAll();
        return null;
    }


}
