package com.example.week67.repositories;

import com.example.week67.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepositories extends JpaRepository<Car, Long> {
    List<Car> findByTitle(String title);
}

