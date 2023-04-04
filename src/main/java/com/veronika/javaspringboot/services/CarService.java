package com.veronika.javaspringboot.services;

import com.veronika.javaspringboot.dao.CarDAO;
import com.veronika.javaspringboot.models.Car;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private CarDAO carDAO;
    private MailService mailService;

    public ResponseEntity<List<Car>> getAllCars() {
        ResponseEntity<List<Car>> listResponseEntity = new ResponseEntity<>(carDAO.findAll(), HttpStatus.OK);
        return listResponseEntity;
    }

    public void saveCar(Car car) {
        if (car == null) {
            throw new RuntimeException();
        } else {
            carDAO.save(car);
            mailService.sendEmail(car);
        }
    }

    public Car getById(int id) {
        return carDAO.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        carDAO.deleteById(id);
    }

    public ResponseEntity<List<Car>> getCarsByPower(int value) {
        ResponseEntity<List<Car>> responseEntity = new ResponseEntity<>(carDAO.getCarByPower(value), HttpStatus.OK);
        return responseEntity;
    }

    public ResponseEntity<List<Car>> getCarsByProducer(String name) {
        ResponseEntity<List<Car>> responseEntity = new ResponseEntity<>(carDAO.getCarByProducer(name), HttpStatus.OK);
        return responseEntity;
    }
}
