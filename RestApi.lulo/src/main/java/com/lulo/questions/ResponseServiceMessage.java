package com.lulo.questions;

import com.lulo.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class ResponseServiceMessage implements Question<Boolean> {

    public static Question<Boolean> isExpected() {
        return new ResponseServiceMessage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(
                        response -> response.body("message",equalTo(TestData.getDataTest().get("message").toString())))
        );
        return true;
    }
}
