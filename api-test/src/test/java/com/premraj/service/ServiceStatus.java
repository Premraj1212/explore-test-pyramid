package com.premraj.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceStatus {

    @Value("${showroom.service.api.url}")
    private String url;

    @Value("${model.type}")
    private String model_type;

    public AppStatus showroomServiceStatus(){
        Response response = RestAssured.given().contentType(ContentType.JSON).get(url+model_type);
        return response.getStatusCode() == 200 ? AppStatus.RUNNING : AppStatus.DOWN;
    }
}
