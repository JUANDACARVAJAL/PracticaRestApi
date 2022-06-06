package com.lulo.tasks;

import com.lulo.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UseDataTest implements Task {

    private final Map<String, String> dataTest;

    public UseDataTest(Map<String, String> dataTest) {
        this.dataTest = dataTest;
    }

    public static Performable values(Map<String, String> objeto) {
        return Tasks.instrumented(UseDataTest.class,objeto);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        Set<Map.Entry<String, String>> testData = dataTest.entrySet();
        TestData.setDataTest(testData.stream().
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }
}
