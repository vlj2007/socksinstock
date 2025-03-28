package ru.home.socksinstock.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.socksinstock.api.SockInterface;
import ru.home.socksinstock.dto.SockDto;
import ru.home.socksinstock.entity.SockEntity;
import ru.home.socksinstock.repository.SockRepository;

import java.util.Collection;

@NoArgsConstructor
@Service
public class SockService implements SockInterface {

    private SockRepository sockRepository;

    public SockService(SockRepository sockRepository) {
        this.sockRepository = sockRepository;
    }

    /***
     * Метод создающий носки
     */

    @Override
    public SockDto createdSock(SockDto sock) {
        //return sockRepository.save(sock);
        return null;
    }

    /***
     * Метод ищущий носки
     */

    public SockDto findSock(Long id){
//        return sockRepository.findById(id).get();
        return null;
    }

    /***
     * Метод редактирования носка по id
     */

    public SockDto editSock(SockDto sockDto){
//        return sockRepository.save(sockDto);
        return null;

    }

    /***
     * Метод удаления носка по id
     */

    // Метод удаления носков
    public void deleteSock(Long id){
        sockRepository.deleteById(id);
    }

    /***
     * Метод получения всех коллекции носков
     */

    public Collection<SockDto> getAllSock(){
//        return sockRepository.findAll();
        return null;
    }


}
