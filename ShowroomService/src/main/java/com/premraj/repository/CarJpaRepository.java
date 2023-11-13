package com.premraj.repository;

import com.premraj.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarJpaRepository extends JpaRepository<Car,String> {
    List<Car> findByType(String type);
}
