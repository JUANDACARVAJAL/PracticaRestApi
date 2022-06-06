package com.lulo.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class Hook {

    private EnvironmentVariables environmentVariable;

    @Before
    public void preconfiguration() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Lulo's user");
        String baseUrl = environmentVariable.getProperty("dummy.qa.base.url");
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(baseUrl));
    }

    @After
    public void ResetSerenity() {
        SerenityRest.reset();
    }
}
