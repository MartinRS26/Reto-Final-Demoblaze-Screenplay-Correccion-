package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.ClickBotonPurchase;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GenerarOrdenDePago implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ClickBotonPurchase.comprar());
    }

    public static GenerarOrdenDePago DemoBlaze() {
        return instrumented(GenerarOrdenDePago.class);
    }
}
