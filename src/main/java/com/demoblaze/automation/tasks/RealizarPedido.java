package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.ClickBotonPlaceOrder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RealizarPedido implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ClickBotonPlaceOrder.realizaPedido());
    }

    public static RealizarPedido DemoBlaze() {
        return instrumented(RealizarPedido.class);
    }
}
