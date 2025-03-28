package ru.home.socksinstock.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Schema(description = "Информация о носке")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "SOCK")
public class SockEntity {
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

}
