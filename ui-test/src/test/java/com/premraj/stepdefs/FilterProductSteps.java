package com.premraj.stepdefs;

import com.premraj.annotation.LazyAutowired;
import com.premraj.ui_layer.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.List;

@SpringBootTest
@CucumberContextConfiguration
public class FilterProductSteps {

    private static final Logger logger = LoggerFactory.getLogger(FilterProductSteps.class);

    @LazyAutowired
    HomePage homePage;

    @Given("user launches the application")
    public void userLaunchesTheApplication() {
        homePage.goTo();
        Assert.assertTrue(homePage.isAt());
    }

    @When("user tries to filter for specific product:")
    public void userTriesToFilterForSpecificProduct(List<String> products) {
        homePage.filterProduct(products);
    }

    @Then("user should see all products related to the search:")
    public void userShouldSeeAllProductsRelatedToTheSearch(List<String> similarProducts) {
        Assert.assertTrue(homePage.verifySearchResult(similarProducts));
    }
}
