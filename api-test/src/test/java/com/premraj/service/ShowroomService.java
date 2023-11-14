package com.premraj.service;

import com.premraj.helper.JsonHelper;
import com.premraj.helper.ReportHelper;
import com.premraj.helper.RunHelper;
import com.premraj.model.Car;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowroomService {
    private static final Logger logger = LoggerFactory.getLogger(ShowroomService.class);

    @Value("${showroom.service.api.url}")
    private String url;

    Car[] showroomCars;
    Response retrieveCarResponse = null;
    public void retrieveCars(String model_type) {
        RunHelper.addRunData("modelType",model_type);

        retrieveCarResponse =
        RestAssured.given()
                .contentType(ContentType.JSON)
                .get(url+model_type)
                .then()
                .statusCode(200)
                .extract().
                response();

        showroomCars = retrieveCarResponse.then().extract().body().as(Car[].class);

        logger.info("#############>> Retrieve Cars API Response"+retrieveCarResponse.prettyPrint());
        ReportHelper.addRequestResponseToHtmlReport(null,response,url+model_type);
    }


    public void validateCarDetails() {
        String modelType = ((String) RunHelper.getRunData("modelType"));
        Car[] expectedCars = JsonHelper.convertJsonFileToObject("src/test/resources/data/ExpectedCars.json",Car[].class);
        List<Car> exCarsLst = Arrays.stream(expectedCars)
                .filter(car -> car.getType().equals(modelType))
                .collect(Collectors.toList());

        logger.info("#######>>Expected car list from data source :: "+ exCarsLst);

        List<Car> actualCarLst = Arrays.stream(showroomCars)
                .collect(Collectors.toList());

        logger.info("********>>Actual car list from API Service :: "+ actualCarLst);

        Assert.assertTrue(exCarsLst.size() == actualCarLst.size() && exCarsLst.containsAll(actualCarLst)
        && actualCarLst.containsAll(exCarsLst));
    }
    Response response;
    public void triggerWithInvalidFRequest(String model_type) {
       response =
               RestAssured.given()
                       .contentType(ContentType.JSON)
                       .get(url+model_type);
        ReportHelper.addRequestResponseToHtmlReport(null,response,url+model_type);
    }

    public void validateCarDetailsNotReturned(int httpStatus) {
        Assert.assertEquals(response.getStatusCode(),httpStatus);
    }
}
