package com.lulo.questions;

import com.lulo.models.TestData;
import com.lulo.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.core.IsEqual;

import static org.hamcrest.MatcherAssert.assertThat;


public class ResponseServiceEmployee implements Question<Boolean> {

    public static Question<Boolean> isExpected() {
        return new ResponseServiceEmployee();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        User user = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("data", User.class);

        assertThat(user.getEmployee_name(), IsEqual.equalTo(TestData.getDataTest().get("employee_name")));

        return true;
    }


}
