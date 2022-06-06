package com.lulo.tasks;

import com.lulo.interactions.RequestServiceGetParam;
import com.lulo.utils.EndPoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class RequestApiGetParameter implements Task {

    private String s;

    public RequestApiGetParameter(String s) {
        this.s = s;
    }

    public static Performable withValue(String s) {
        return Tasks.instrumented(RequestApiGetParameter.class,s);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(RequestServiceGetParam.send(EndPoints.GET_EMPLOYEE.getUrl(),s));
    }
}
