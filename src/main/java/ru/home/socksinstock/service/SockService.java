package ru.home.socksinstock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.home.socksinstock.api.SockInterface;
import ru.home.socksinstock.model.Sock;
import ru.home.socksinstock.repository.SockRepository;

import java.util.Collection;

@Service
public class SockService implements SockInterface {

    private final SockRepository sockRepository;

    public SockService(SockRepository sockRepository) {
        this.sockRepository = sockRepository;
    }

    /***
     * Метод создающий носки
     */

    @Override
    public Sock createdSock(Sock sock) {
        return sockRepository.save(sock);
    }

    /***
     * Метод ищущий носки
     */

    public Sock findSock(Long id){
        return sockRepository.findById(id).get();
    }

    /***
     * Метод редактирования носка по id
     */

    public Sock editSock(Sock sock){
        return sockRepository.save(sock);

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

    public Collection<Sock> getAllSock(){
        return sockRepository.findAll();
    }

}
