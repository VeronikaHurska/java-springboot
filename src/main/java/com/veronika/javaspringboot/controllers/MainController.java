package com.veronika.javaspringboot.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.veronika.javaspringboot.dao.CarDAO;
import com.veronika.javaspringboot.models.Car;
import com.veronika.javaspringboot.views.Views;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private CarDAO carDAO;

    @GetMapping("/cars")
    @JsonView(value = Views.Level3.class)
    private ResponseEntity<List<Car>> getCars() {
        ResponseEntity<List<Car>> listResponseEntity = new ResponseEntity<>(carDAO.findAll(), HttpStatus.OK);
        return listResponseEntity;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/cars")
    @JsonView(value = Views.Level3.class)
    private void addCar(@Valid @RequestBody Car car) {

        carDAO.save(car);
    }

    @GetMapping("cars/{id}")
    @JsonView(value = Views.Level1.class)
    private Car carById(@PathVariable int id) {
        return carDAO.findById(id).get();
    }

    @DeleteMapping("cars/{id}")
    @JsonView(value = Views.Level1.class)
    private ResponseEntity<List<Car>> deleteCar(@PathVariable int id) {
        carDAO.deleteById(id);
        ResponseEntity<List<Car>> response = new ResponseEntity<>(carDAO.findAll(), HttpStatus.OK);
        return response;
    }

    @GetMapping("cars/power/{value}")
    @JsonView(value = Views.Level2.class)

    private ResponseEntity<List<Car>> carsByPower(@PathVariable int value) {

        ResponseEntity<List<Car>> responseEntity = new ResponseEntity<>(carDAO.getCarByPower(value), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("cars/producer/{value}")
    @JsonView(value = Views.Level2.class)
    private ResponseEntity<List<Car>> carsByProducer(@PathVariable String value) {
        ResponseEntity<List<Car>> responseEntity = new ResponseEntity<>(carDAO.getCarByProducer(value), HttpStatus.OK);
        return responseEntity;
    }
}
