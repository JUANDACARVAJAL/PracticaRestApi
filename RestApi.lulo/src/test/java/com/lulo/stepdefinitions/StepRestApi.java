package com.lulo.stepdefinitions;

import com.lulo.questions.ResponseService;
import com.lulo.tasks.RequestApi;
import com.lulo.tasks.RequestApiGet;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepRestApi {
    @When("the client requests a pin for a valid account")
    public void theClientRequestsAPinForAValidAccount() {
        theActorInTheSpotlight().attemptsTo(RequestApi.service());
    }

    @When("the client requests a employees service")
    public void theClientRequestsAEmployeesService() {
        theActorInTheSpotlight().attemptsTo(RequestApiGet.service());
    }

    @Then("the response is a employees list")
    public void theResponseIsAEmployeesList() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ResponseService.isExpected()));
    }
}
