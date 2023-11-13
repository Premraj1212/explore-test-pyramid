package com.premraj.unit;

import com.premraj.model.Car;
import com.premraj.repository.CarJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    CarJpaRepository carJpaRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void should_get_car_based_on_type(){
        List<Car> findByType = carJpaRepository.findByType("Suv");
        Assertions.assertTrue(findByType.size() == 1);
        Assertions.assertEquals("Suv",findByType.stream().findFirst().get().getType());
    }
}
