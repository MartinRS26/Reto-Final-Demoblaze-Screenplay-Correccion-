package com.demoblaze.automation.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.CarritoPage.REALIZAR_PEDIDO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickBotonPlaceOrder implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(REALIZAR_PEDIDO));
    }

    public static ClickBotonPlaceOrder realizaPedido() {
        return instrumented(ClickBotonPlaceOrder.class);
    }
}
