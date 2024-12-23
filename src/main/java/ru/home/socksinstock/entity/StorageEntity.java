package ru.home.socksinstock.entity;

import jakarta.persistence.*;
import ru.home.socksinstock.model.Sock;

import java.util.List;

@Entity
@Table(name = "STORAGE")
public class StorageEntity {

    @Id
    private Long id;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "COTTON")
    private int percentageOfCotton;
    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToMany
    List<Sock> likesSock;


}
