package ru.home.socksinstock.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.socksinstock.dto.SockDto;
import ru.home.socksinstock.entity.SockEntity;
import ru.home.socksinstock.service.SockService;

import java.util.Collection;
@NoArgsConstructor
@RestController
@RequestMapping("/api/socks")
@Tag(
        name = "Носки",
        description = "Все методы для работы с носками"
)
public class SockController {
    @Autowired
    private SockService sockService;

    public SockController(SockService sockService) {
        this.sockService = sockService;
    }

    /***
     * Сюда попадают запросы на создание носков
     */

    @PostMapping("/income") //POST localhost:8080/api/socks/1
    @Operation(summary = "Регистрация прихода носков")
    public SockEntity createSock(@RequestBody SockDto sockDto){
        return sockService.createSock(sockDto);
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
    public ResponseEntity<SockDto> getSockInfo(@PathVariable Long id){
        SockDto sockDto = sockService.findSock(id);
        if(sockDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sockDto);
    }

    /***
     * Сюда попадают запросы на редактирование носка по id
     */

    @PutMapping("/{id}") // http://localhost:8080/api/socks/edit/1
    @Operation(summary = "Отредактировать информацию о носках")
    public ResponseEntity<SockDto> editSock(@RequestBody SockDto sockDto){
        SockDto foundSock = sockService.editSock(sockDto);
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
    public ResponseEntity<Collection<SockDto>> getAllSock(){
        return ResponseEntity.ok(sockService.getAllSock());
    }
}
