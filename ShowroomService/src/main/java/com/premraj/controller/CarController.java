package com.premraj.controller;

import com.premraj.exceptions.CarNotFoundException;
import com.premraj.model.Car;
import com.premraj.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;


    @GetMapping(value = "/api/cars/{type}",produces = "application/json")
    public ResponseEntity<List<Car>> getCarByTheType(@PathVariable String type){
        List<Car> listOfCar = carService.getCars(type);
        if (listOfCar==null || listOfCar.isEmpty()) throw new CarNotFoundException("Car Type not found");
        else{
            return new ResponseEntity<>(listOfCar, HttpStatus.OK);
        }
    }
}
