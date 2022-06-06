package com.lulo.tasks;

import com.lulo.interactions.RequestServicePost;
import com.lulo.utils.EndPoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class RequestApiPost implements Task {
    public static Performable create() {
        return Tasks.instrumented(RequestApiPost.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(RequestServicePost.send(EndPoints.POST_CREATE.getUrl()));
    }
}
