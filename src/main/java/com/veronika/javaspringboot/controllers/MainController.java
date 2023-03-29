package com.veronika.javaspringboot.controllers;

import com.veronika.javaspringboot.dao.CarDAO;
import com.veronika.javaspringboot.models.Car;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private CarDAO carDAO;

    @GetMapping("/cars")
    private List<Car> getCars() {
        return carDAO.findAll();
    }

    @PostMapping("/cars")
    private void addCar(@RequestBody Car car) {
        carDAO.save(car);
    }

    @GetMapping("cars/{id}")
    private Car carById(@PathVariable int id) {
        return carDAO.findById(id).get();
    }

    @DeleteMapping("cars/{id}")
    private List<Car> deleteCar(@PathVariable int id) {
        carDAO.deleteById(id);
        return carDAO.findAll();
    }

    @GetMapping("cars/power/{value}")
    private List<Car> carsByPower(@PathVariable int value) {
        return carDAO.getCarByPower(value);
    }

    @GetMapping("cars/producer/{value}")
    private List<Car> carsByProducer(@PathVariable String value) {
        return carDAO.getCarByProducer(value);
    }
}
