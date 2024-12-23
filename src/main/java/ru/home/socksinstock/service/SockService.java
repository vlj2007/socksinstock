package ru.home.socksinstock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.home.socksinstock.api.SockInterface;
import ru.home.socksinstock.exception.BadRequestException;
import ru.home.socksinstock.model.Sock;
import ru.home.socksinstock.repository.SockRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Collection;

@Service
public class SockService implements SockInterface {

    @Autowired
    private final SockRepository sockRepository;
    private final HashMap<Long, Sock> socksMap = new HashMap<>();
    private long count = 0;

    public SockService(SockRepository sockRepository) {
        this.sockRepository = sockRepository;
    }

    /***
     * Метод создающий носки
     */

    @Override
    public Sock createdSock(Sock sock) {
        sock.setId(++count);
        socksMap.put(sock.getId(), sock);
        return sock;
    }

    /***
     * Метод ищущий носки
     */

    public Sock findSock(Long id){
        if(id == null){
            return sockRepository.findById(id).orElseThrow(() -> new BadRequestException("Отсутствует id"));
        }
        return sockRepository.findById(id).get();
    }

    /***
     * Метод редактирования носка по id
     */

    public Sock editSock(Sock sock){
        socksMap.put(sock.getId(), sock);
        return sock;
    }

    /***
     * Метод удаления носка по id
     */

    // Метод удаления носков
    public Sock deleteSock(Long id){
        return socksMap.remove(id);
    }

    /***
     * Метод получения всех коллекции носков
     */

    public Collection<Sock> getAllSock(){
        return socksMap.values();
    }

}
