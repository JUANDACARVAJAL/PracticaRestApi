package com.lulo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.http.ContentType.JSON;

public class RequestServicePost implements Interaction {

    private final String url;

    public RequestServicePost(String url) {
        this.url = url;
    }

    public static Performable send(String url) {
        return new RequestServicePost(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        File file = new File("src/test/resources/user.json");
        String json = null;
        try {
             json = readFileAsString(file.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String finalJson = json;
        actor.attemptsTo(
                Post.to(url).with(request -> request
                        .contentType(JSON)
                        .body(finalJson)
                        .relaxedHTTPSValidation()
                        .log().all()
                )
        );
    }

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }


}
