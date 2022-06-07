package com.lulo.questions;

import com.lulo.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ResponseService implements Question<Boolean> {

    public static ResponseService isExpected() {
        return new ResponseService();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        Integer statusCode = Integer.parseInt(TestData.getDataTest().get("statuscode").toString());

        actor.should(
                seeThatResponse(
                        response -> response.log().all()
                                .statusCode(statusCode))
        );
        return true;
    }
}
