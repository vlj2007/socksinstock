package ru.home.socksinstock.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.home.socksinstock.model.Sock;
import ru.home.socksinstock.service.SockService;

import java.util.Collection;

@RestController
@RequestMapping("/api/socks")
@Tag(
        name = "Носки",
        description = "Все методы для работы с носками"
)
public class SockController {

    private final SockService sockService;


    public SockController(SockService sockService){
        this.sockService = sockService;
    }

    /***
     * Сюда попадают запросы на создание носков
     */

    @PostMapping //POST localhost:8080/api/socks/1
    @Operation(summary = "Создать носок")
    public Sock createSock(@RequestBody Sock sock){
        return sockService.createdSock(sock);
    }

    /***
     * Сюда попадают запросы по поиску носков
     */

    @GetMapping("/info/{id}") // http://localhost:8080/api/socks/info/1
    @Operation(
            summary = "Получить информацию о носках по его id",
            description = "Get endpoint for manager"
    )
    //@Parameter(description = "id носка")
    public ResponseEntity<Sock> getSockInfo(@PathVariable Long id){
        Sock sock = sockService.findSock(id);
        if(sock == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sock);
    }

    /***
     * Сюда попадают запросы на редактирование носка по id
     */

    @PutMapping("/edit/{id}") // http://localhost:8080/api/socks/edit/1
    @Operation(summary = "Отредактировать информацию о носках")
    public ResponseEntity<Sock> editSock(@RequestBody Sock sock){
        Sock foundSock = sockService.editSock(sock);
        if (foundSock == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundSock);
    }

    /***
     * Сюда попадают запросы на удаление носка по его id
     */

    @DeleteMapping("/delete/{id}") // http://localhost:8080/api/socks/delete/1
    @Operation(summary = "Удалить информацию о носках по его id")
    public ResponseEntity deleteSock(@PathVariable Long id){
        sockService.deleteSock(id);
        return ResponseEntity.ok().build();
    }

    /***
     * Сюда попадают запросы на вывод всей информации о носках
     */

    @GetMapping(path = "/all") // http://localhost:8080/api/socks/all
    @Operation(summary = "Вывести всю информацию о носках")
    public ResponseEntity<Collection<Sock>> getAllSock(){
        return ResponseEntity.ok(sockService.getAllSock());
    }






}
