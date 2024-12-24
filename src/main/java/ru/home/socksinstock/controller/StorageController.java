package ru.home.socksinstock.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.socksinstock.model.Storage;
import ru.home.socksinstock.service.StorageService;

@RestController
@RequestMapping("/api/storage")
@Tag(
        name = "Склад",
        description = "Все методы для работы со складом"
)
public class StorageController {

    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }


    @PostMapping //POST localhost:8080/api/socks/1
    @Operation(summary = "Создать склада")
    public Storage createSock(@RequestBody Storage storage){
        return storageService.createdSock(storage);
    }
}
