package ru.home.socksinstock.controller;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.socksinstock.model.Sock;
import ru.home.socksinstock.service.SockService;

import java.util.Collection;

@RestController
@RequestMapping("/api/socks")
public class SockController {

    private final SockService sockService;


    public SockController(SockService sockService){
        this.sockService = sockService;
    }
    // Метод создания носков
    @PostMapping("{id}") //POST localhost:8080/sock/1
    public Sock createSock(@RequestBody Sock sock) {
        return sockService.createdSock(sock);
    }
    // Метод редактирования носков
    @PostMapping
    public ResponseEntity<Sock> editSock(@RequestBody Sock sock){
        Sock foundSock = sockService.editSock(sock);
        if (foundSock == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundSock);
    }
    // Метод удаления носков
    @DeleteMapping
    public Sock deleteSock(@PathVariable Long id){
        return sockService.deleteSock(id);
    }
    @GetMapping
    public ResponseEntity<Collection<Sock>> getAllSock(){
        return ResponseEntity.ok(sockService.getAllSock());
    }

}
