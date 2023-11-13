package com.premraj.stepdefs;

import com.premraj.helper.RunHelper;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {



//    @LazyAutowired
//    private ApplicationContext applicationContext;

    @Before
    public void beforeScenario(){
        RunHelper.initRunData();
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        //scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
    }

    @After
    public void afterScenario(){
        //this.applicationContext.getBean(WebDriver.class).quit();
    }

}
