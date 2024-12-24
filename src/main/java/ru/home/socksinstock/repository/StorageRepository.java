package ru.home.socksinstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.socksinstock.model.Storage;

import java.util.List;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
    List<Storage> findStorageById (Long id);
    //List<Storage> findStorageByStreet(Storage storage);
}
