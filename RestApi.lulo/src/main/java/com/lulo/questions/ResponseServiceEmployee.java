package com.lulo.questions;

import com.lulo.models.TestData;
import com.lulo.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.core.IsEqual;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResponseServiceEmployee implements Question<Boolean> {

    public static Question<Boolean> isExpected() {
        return new ResponseServiceEmployee();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(
                        response -> response.body("message",equalTo(TestData.getDataTest().get("message").toString())))
        );
        User user = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("data", User.class);

        assertThat(user.getEmployee_name(), IsEqual.equalTo(TestData.getDataTest().get("employee_name")));

        return true;
    }


}
