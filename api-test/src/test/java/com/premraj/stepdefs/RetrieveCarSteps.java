package com.premraj.stepdefs;

import com.premraj.service.AppStatus;
import com.premraj.service.ServiceStatus;
import com.premraj.service.ShowroomService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import static com.premraj.service.AppStatus.RUNNING;

@SpringBootTest
@CucumberContextConfiguration
public class RetrieveCarSteps {
    private static final Logger logger = LoggerFactory.getLogger(RetrieveCarSteps.class);

    @Autowired
    ServiceStatus serviceStatus;
    @Autowired
    ShowroomService showroomService;

    @Given("showroom service is active")
    public void showroomServiceIsActive() {
        Assert.assertEquals(serviceStatus.showroomServiceStatus(), RUNNING);
    }

    @When("the user query for cars using {}")
    public void theUserQueryForCarsUsingModel_type(String model_type) {
        showroomService.retreiveCars(model_type);
    }

    @And("validate all details presented by car service")
    public void validateAllDetailsPresentedByCarService() {
        showroomService.validateCarDetails();
    }

    @When("the user trigger for car service using incorrect {}")
    public void theUserTriggerForCarServiceUsingIncorrectModel_type(String model_type) {
        showroomService.triggerWithInvalidFRequest(model_type);
    }

    @Then("showroom service should not return any car type with {int}")
    public void showroomServiceShouldNotReturnAnyCarTypeWithHttpStatus(int httpStatus) {
        showroomService.validateCarDetailsNotReturned(httpStatus);
    }
}
