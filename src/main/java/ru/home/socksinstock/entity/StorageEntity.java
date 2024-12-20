package ru.home.socksinstock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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



}
