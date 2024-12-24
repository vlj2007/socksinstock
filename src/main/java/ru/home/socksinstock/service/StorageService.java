package ru.home.socksinstock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.home.socksinstock.model.Storage;
import ru.home.socksinstock.repository.StorageRepository;

@Service
public class StorageService {

    private final StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public Storage createdSock(Storage storage) {
        return storageRepository.save(storage);
    }

}
