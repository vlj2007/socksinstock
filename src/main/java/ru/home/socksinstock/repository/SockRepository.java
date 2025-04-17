package ru.home.socksinstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.socksinstock.entity.SockEntity;
import ru.home.socksinstock.model.SockModel;

import java.util.List;

@Repository
public interface SockRepository extends JpaRepository<SockEntity, Long> {
//    List<SockModel> findSockById(Long id);
//    List<SockModel> findSockByColor(String color);
//    List<SockModel> findSockByManufacturer(String manufacturer);
//    List<SockModel> findSockByPercentageOfCotton(int percentageOfCotton);
}
