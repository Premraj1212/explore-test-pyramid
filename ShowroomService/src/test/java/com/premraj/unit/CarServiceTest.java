package com.premraj.unit;

import com.premraj.model.Car;
import com.premraj.repository.CarJpaRepository;
import com.premraj.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    CarJpaRepository carJpaRepository;

    @InjectMocks
    CarService carService;

    @Test
    void getCarModelType(){
        Car car = Car.builder().carId(1).make("Fiat").model("138D").years("2022").type("Suv").zeroToSixty(new BigDecimal(6.80)).price(20000).build();
        List<Car> carLst = List.of(car);
        Mockito.when(carJpaRepository.findByType(anyString())).thenReturn(carLst);
        List<Car> serviceLst = carService.getCars("Suv");
        Assertions.assertEquals("Suv",serviceLst.stream().findFirst().get().getType());
        Assertions.assertEquals("Fiat",serviceLst.stream().findFirst().get().getMake());
        Assertions.assertEquals("138D",serviceLst.stream().findFirst().get().getModel());
        Assertions.assertEquals("2022",serviceLst.stream().findFirst().get().getYears());
        Assertions.assertEquals(20000,serviceLst.stream().findFirst().get().getPrice());
    }

}
