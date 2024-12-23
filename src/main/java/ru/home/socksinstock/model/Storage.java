package ru.home.socksinstock.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Schema(description = "Информация о складе")
@Entity
@Table(name = "STORAGE")
public class Storage {

    @Id
    @Schema(description = "Идентификатор")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "STREET")
    @Schema(description = "Улица")
    private String Street;

    @ManyToMany
    List<Sock> likedSock;


    public Storage() {
    }

    public Storage(Long id, String street, List<Sock> likedSock) {
        this.id = id;
        Street = street;
        this.likedSock = likedSock;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public List<Sock> getLikedSock() {
        return likedSock;
    }

    public void setLikedSock(List<Sock> likedSock) {
        this.likedSock = likedSock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return Objects.equals(id, storage.id) && Objects.equals(Street, storage.Street) && Objects.equals(likedSock, storage.likedSock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Street, likedSock);
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", Street='" + Street + '\'' +
                ", likedSock=" + likedSock +
                '}';
    }
}
