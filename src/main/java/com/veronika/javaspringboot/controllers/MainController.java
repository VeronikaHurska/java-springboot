package com.veronika.javaspringboot.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.veronika.javaspringboot.models.Car;
import com.veronika.javaspringboot.services.CarService;
import com.veronika.javaspringboot.views.Views;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private CarService carService;

    @GetMapping("/cars")
    @JsonView(value = Views.Level3.class)
    private ResponseEntity<List<Car>> getCars() {
        return carService.getAllCars();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cars")
    @JsonView(value = Views.Level3.class)
    private void addCar(@Valid @RequestBody Car car) {
        carService.saveCar(car);
    }

    @GetMapping("cars/{id}")
    @JsonView(value = Views.Level1.class)
    private Car carById(@PathVariable int id) {
        return carService.getById(id);
    }

    @DeleteMapping("cars/{id}")
    @JsonView(value = Views.Level1.class)
    @ResponseStatus(HttpStatus.OK)
    private void deleteCar(@PathVariable int id) {
        carService.deleteById(id);
    }

    @GetMapping("cars/power/{value}")
    @JsonView(value = Views.Level2.class)
    private ResponseEntity<List<Car>> carsByPower(@PathVariable int value) {
        return carService.getCarsByPower(value);
    }

    @GetMapping("cars/producer/{value}")
    @JsonView(value = Views.Level2.class)
    private ResponseEntity<List<Car>> carsByProducer(@PathVariable String value) {
        return carService.getCarsByProducer(value);
    }
}
