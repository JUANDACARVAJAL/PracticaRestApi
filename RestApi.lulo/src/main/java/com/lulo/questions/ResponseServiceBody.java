package com.lulo.questions;

import com.lulo.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.hasItems;

public class ResponseServiceBody implements Question<Boolean> {
    public static Question<Boolean> isExpected() {
        return new ResponseServiceBody();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(
                        response -> response.body("data.employee_name",hasItems(TestData.getDataTest().get("items"))))
        );
        return true;
    }
}
