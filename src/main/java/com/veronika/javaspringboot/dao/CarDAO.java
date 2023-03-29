package com.veronika.javaspringboot.dao;

import com.veronika.javaspringboot.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarDAO extends JpaRepository<Car, Integer> {

    @Query(" select  c from Car c where c.power =:power")
    List<Car> getCarByPower(@Param("power") int power);
    @Query("select  c from Car c where c.producer =:producer")
    List<Car> getCarByProducer(@Param("producer") String producer);
}
