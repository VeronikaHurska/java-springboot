package com.veronika.javaspringboot.models;


import com.fasterxml.jackson.annotation.JsonView;
import com.veronika.javaspringboot.views.Views;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
@AllArgsConstructor

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(value = {Views.Level1.class})
    private int id;

    @JsonView(value = {Views.Level1.class, Views.Level2.class,Views.Level3.class})
    private String model;

    @JsonView(value = {Views.Level1.class, Views.Level2.class,Views.Level3.class})
    private String producer;


    @NotNull(message = "enter power")
    @Min(value = 0,message = "too small")
    @Max(value = 1100,message = "to big")

    @JsonView(value = {Views.Level1.class, Views.Level2.class})
    private int power;

    public Car(String model, String producer, int power) {
        this.model = model;
        this.producer = producer;
        this.power = power;
    }
}
