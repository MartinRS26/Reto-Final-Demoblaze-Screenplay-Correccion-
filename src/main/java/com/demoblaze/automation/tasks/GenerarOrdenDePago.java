package com.demoblaze.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.RealizarPedidoPage.COMPRAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GenerarOrdenDePago implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(COMPRAR));
    }

    public static GenerarOrdenDePago alComprarProducto() {
        return instrumented(GenerarOrdenDePago.class);
    }
}
