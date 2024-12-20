package ru.home.socksinstock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "SOCK")
public class Sock {
    @Id
    private Long id;
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "COTTON")
    private int percentageOfCotton;
    @Column(name = "QUANTITY")
    private int quantity;

    public Sock() {
    }

    public Sock(Long id, String manufacturer, String color, int percentageOfCotton, int quantity) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.color = color;
        this.percentageOfCotton = percentageOfCotton;
        this.quantity = quantity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sock sock = (Sock) o;
        return percentageOfCotton == sock.percentageOfCotton && quantity == sock.quantity && Objects.equals(id, sock.id) && Objects.equals(manufacturer, sock.manufacturer) && Objects.equals(color, sock.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manufacturer, color, percentageOfCotton, quantity);
    }

    @Override
    public String toString() {
        return "Sock{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", color='" + color + '\'' +
                ", percentageOfCotton=" + percentageOfCotton +
                ", quantity=" + quantity +
                '}';
    }
}
