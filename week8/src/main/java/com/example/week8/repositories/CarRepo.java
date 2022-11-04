package com.example.week8.repositories;

import com.example.week8.entity.Cars;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepo extends CrudRepository<Cars, Long> {

    List<Cars> findByTag(String tag);

}
