package com.lulo.stepdefinitions;

import com.lulo.tasks.UseDataTest;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DataTest {

    @Given("The data is used")
    public void uploadTheDataTest(List<Map<String, String>> clientData) {
        theActorInTheSpotlight().wasAbleTo(UseDataTest.values(clientData.get(0)));
    }

}
