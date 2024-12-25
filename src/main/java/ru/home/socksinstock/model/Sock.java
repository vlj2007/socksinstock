package ru.home.socksinstock.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Schema(description = "Информация о носке")
@Entity
@Table(name = "SOCK")
public class Sock {
    @Id
    @Schema(description = "Идентификатор")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MANUFACTURER")
    @Schema(description = "Производитель")
    private String manufacturer;

    @Column(name = "COLOR")
    @Schema(description = "Цвет")
    private String color;

    @Column(name = "COTTON")
    @Schema(description = "Процентное содержание хлопка")
    private int percentageOfCotton;

    @Column(name = "QUANTITY")
    @Schema(description = "Количество")
    private int quantity;


//    @ManyToMany//(mappedBy = "storageList",fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "storage_like",
//            joinColumns = @JoinColumn(name = "sock_id"),
//            inverseJoinColumns = @JoinColumn(name = "storage_id"))

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Storage> likedStorage;

    public Sock() {
    }

    public Sock(Long id, String manufacturer, String color, int percentageOfCotton, int quantity, List<Storage> likedStorage) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.color = color;
        this.percentageOfCotton = percentageOfCotton;
        this.quantity = quantity;
        this.likedStorage = likedStorage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPercentageOfCotton() {
        return percentageOfCotton;
    }

    public void setPercentageOfCotton(int percentageOfCotton) {
        this.percentageOfCotton = percentageOfCotton;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Storage> getLikedStorage() {
        return likedStorage;
    }

    public void setLikedStorage(List<Storage> likedStorage) {
        this.likedStorage = likedStorage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sock sock = (Sock) o;
        return percentageOfCotton == sock.percentageOfCotton && quantity == sock.quantity && Objects.equals(id, sock.id) && Objects.equals(manufacturer, sock.manufacturer) && Objects.equals(color, sock.color) && Objects.equals(likedStorage, sock.likedStorage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manufacturer, color, percentageOfCotton, quantity, likedStorage);
    }

    @Override
    public String toString() {
        return "Sock{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", color='" + color + '\'' +
                ", percentageOfCotton=" + percentageOfCotton +
                ", quantity=" + quantity +
                ", likedStorage=" + likedStorage +
                '}';
    }
}
