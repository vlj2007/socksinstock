package ru.home.socksinstock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.home.socksinstock.api.SockInterface;
import ru.home.socksinstock.model.Sock;
import ru.home.socksinstock.repository.SockRepository;

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

    // Метод создания носков
    @Override
    public Sock createdSock(Sock sock) {
        sock.setId(++count);
        socksMap.put(sock.getId(), sock);
        return sock;
    }

    // метод поиска носков
    public Sock findSock(Long id){
        return socksMap.get(id);
    }

    // метод редактирования носков
    public Sock editSock(Sock sock){
        socksMap.put(sock.getId(), sock);
        return sock;
    }
    // Метод удаления носков
    public Sock deleteSock(Long id){
        return socksMap.remove(id);
    }

    // Метод получения всех носков
    public Collection<Sock> getAllSock(){
        return socksMap.values();
    }

}
