package com.demoblaze.automation.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.demoblaze.automation.userinterfaces.CarritoPage.REALIZAR_PEDIDO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarPedido implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(REALIZAR_PEDIDO,isVisible()).forNoMoreThan(2).seconds(),
                Click.on(REALIZAR_PEDIDO));

    }

    public static RealizarPedido deProductos() {
        return instrumented(RealizarPedido.class);
    }
}
