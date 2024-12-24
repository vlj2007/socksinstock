package ru.home.socksinstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.socksinstock.model.Sock;
import java.util.List;

@Repository
public interface SockRepository extends JpaRepository<Sock, Long> {
//    List<Sock> findSockById(Long id);
//    List<Sock> findSockByColor(String color);
//    List<Sock> findSockByManufacturer(String manufacturer);
//    List<Sock> findSockByPercentageOfCotton(int percentageOfCotton);
}
