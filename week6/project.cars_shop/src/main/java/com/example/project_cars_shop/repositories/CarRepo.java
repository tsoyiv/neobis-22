package com.example.project_cars_shop.repositories;

import com.example.project_cars_shop.entities.CarsEntity;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface CarRepo {

    List<CarsEntity> findAllByCarStatus;

    List<CarsEntity> findAllByCarType;

    List<CarsEntity> findAllByCarStatusAndCarType;
}
