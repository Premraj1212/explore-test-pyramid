package com.premraj.stepdefs;

import com.premraj.helper.RunHelper;
import com.premraj.helper.ScenarioStorage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {


    @Before
    public void beforeScenario(Scenario scenario){
        RunHelper.initRunData();
        ScenarioStorage.putScenario(scenario);
    }

}
