package com.premraj.unit;

import com.premraj.controller.CarController;
import com.premraj.model.Car;
import com.premraj.service.CarService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@WebMvcTest(CarController.class)
@ExtendWith(SpringExtension.class)
public class CarControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CarService carService;

    @Test
    @SneakyThrows
    void should_return_list_of_cars(){
        Car car = Car.builder().carId(1).make("Fiat").model("138D").years("2022").type("Suv").zeroToSixty(new BigDecimal(6.80)).price(20000).build();

        Mockito.when(carService.getCars(anyString())).thenReturn(List.of(car));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/Suv"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].make").value("Fiat"))
                .andDo(MockMvcResultHandlers.print());
    }
}
