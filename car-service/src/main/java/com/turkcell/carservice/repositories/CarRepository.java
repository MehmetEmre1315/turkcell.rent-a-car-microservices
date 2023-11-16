package com.turkcell.carservice.repositories;

import com.turkcell.carservice.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, Integer> {

    //{"_id": ObjectId("your_id_here")}
    @Query("{'id': ?0 }")
    Car findbyIdQuery(int myId);

    //Optional<Car> findById(String id);

    @Query("{ }")
    List<Car> findAllQuery();




}
