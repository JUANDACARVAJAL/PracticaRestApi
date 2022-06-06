package com.lulo.tasks;

import com.lulo.interactions.RequestServiceGet;
import com.lulo.utils.EndPoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class RequestApiGet implements Task {
    public static Performable service() {
        return Tasks.instrumented(RequestApiGet.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(RequestServiceGet.send(EndPoints.GET_EMPLOYEES.getUrl()));
    }
}
