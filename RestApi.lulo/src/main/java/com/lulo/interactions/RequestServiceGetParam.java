package com.lulo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class RequestServiceGetParam implements Interaction {

    private final String url;
    private final String arg;


    public RequestServiceGetParam(String url, String arg) {
        this.url = url;
        this.arg = arg;
    }
    public static Performable send(String url,String arg) {
        return new RequestServiceGetParam(url, arg);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(url).with( request -> request.pathParam("id", arg))

        );
    }
}
