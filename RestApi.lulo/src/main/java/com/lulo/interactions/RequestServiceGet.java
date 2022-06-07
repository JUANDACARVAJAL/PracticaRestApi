package com.lulo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class RequestServiceGet implements Interaction {

    private final String url;

    public RequestServiceGet(String url) {
        this.url = url;
    }
    public static Performable send(String url) {
        return new RequestServiceGet(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(url).with(request -> request
                        .log().all())

        );
    }
}
