package com.lulo.stepdefinitions;

import com.lulo.models.TestData;
import com.lulo.questions.ResponseService;
import com.lulo.questions.ResponseServiceBody;
import com.lulo.questions.ResponseServiceEmployee;
import com.lulo.tasks.RequestApiGet;
import com.lulo.tasks.RequestApiGetParameter;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepRestApi {

    @When("the client requests a employees service")
    public void theClientRequestsAEmployeesService() {
        theActorInTheSpotlight().attemptsTo(RequestApiGet.service());
    }

    @Then("the response is a employees list")
    public void theResponseIsAEmployeesList() {
        theActorInTheSpotlight().should(seeThat(ResponseService.isExpected()));
        theActorInTheSpotlight().should(seeThat(ResponseServiceBody.isExpected()));
    }

    @When("the client requests data for a employee")
    public void theClientRequestsDataForAEmployee() {
        theActorInTheSpotlight().attemptsTo(RequestApiGetParameter.withValue(TestData.getDataTest().get("id").toString()));
    }

    @Then("the client can see the information employees")
    public void theClientCanSeeTheInformationEmployees() {
        theActorInTheSpotlight().should(seeThat(ResponseService.isExpected()));
        theActorInTheSpotlight().should(seeThat(ResponseServiceEmployee.isExpected()));


    }
}
