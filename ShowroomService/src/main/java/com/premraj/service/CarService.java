package com.premraj.service;

import com.premraj.model.Car;
import com.premraj.repository.CarJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarJpaRepository carJpaRepository;

    public List<Car> getCars(String type){
        return carJpaRepository.findByType(type);
    }
}
