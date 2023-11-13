package com.premraj.service;

import com.premraj.helper.JsonHelper;
import com.premraj.helper.RunHelper;
import com.premraj.model.Car;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowroomService {

    @Value("${showroom.service.api.url}")
    private String url;

    Car[] showroomCars;
    public void retreiveCars(String model_type) {
        RunHelper.addRunData("modelType",model_type);
        showroomCars =
        RestAssured.given()
                .contentType(ContentType.JSON)
                .get(url+model_type)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(Car[].class);
    }


    public void validateCarDetails() {
        String modelType = ((String) RunHelper.getRunData("modelType"));
        Car[] expectedCars = JsonHelper.convertJsonFileToObject("src/test/resources/data/ExpectedCars.json",Car[].class);
        List<Car> exCarsLst = Arrays.stream(expectedCars)
                .filter(car -> car.getType().equals(modelType))
                .sorted()
                .collect(Collectors.toList());

        List<Car> actualCarLst = Arrays.stream(showroomCars)
                .sorted()
                .collect(Collectors.toList());

        Assert.assertTrue(exCarsLst.size() == actualCarLst.size() && exCarsLst.containsAll(actualCarLst)
        && actualCarLst.containsAll(exCarsLst));
    }
    Response response;
    public void triggerWithInvalidFRequest(String model_type) {
       response =
               RestAssured.given()
                       .contentType(ContentType.JSON)
                       .get(url+model_type);
    }

    public void validateCarDetailsNotReturned(int httpStatus) {
        Assert.assertEquals(response.getStatusCode(),httpStatus);
    }
}
