package com.example.week67.service;

import com.example.week67.models.Car;
import com.example.week67.repositories.CarRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarsServices {
    private final CarRepositories carRepositories;

    public List<Car> listCar(String title) {
        List<Car> cars = carRepositories.findAll();
        if(title != null) return carRepositories.findByTitle(title);
        return carRepositories.findAll();
    }
    public void saveProduct(Car car) {
        log.info("Saving new {}", car);
        carRepositories.save(car);
    }

    public Car getProductById(Long id) {

        return carRepositories.findById(id).orElse(null);
    }
    public void deleteCar(Long id)
    {
        carRepositories.deleteById(id);
    }


}
