package com.premraj.helper;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;

public class ReportHelper {

    public static void addRequestResponseToHtmlReport(QueryableRequestSpecification request, Response response, String baseUrl){
        if(baseUrl!=null){
            ScenarioStorage.getScenario().attach("baseUrl :"+ baseUrl,"text/plain","baseUrl");
        }

        if(request!=null){
            ScenarioStorage.getScenario().attach("Request ::","text/plain","Request Details");
            ScenarioStorage.getScenario().attach("Headers :"+ request.getHeaders(),"text/plain","request Headers");
            ScenarioStorage.getScenario().attach("HttpMethod :"+ request.getMethod(),"text/plain","Http Method");
            ScenarioStorage.getScenario().attach("Body :"+ request.getBody(),"text/plain","Request Body");
        }

        if(response!=null){
            ScenarioStorage.getScenario().attach("Response:"+ response.asPrettyString(),"text/plain","Response");
        }
    }

}
