package ru.home.socksinstock.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class SockDto {
    private Long id;
    private String manufacturer;
    private String color;
    private int percentageOfCotton;
    private int quantity;
}
