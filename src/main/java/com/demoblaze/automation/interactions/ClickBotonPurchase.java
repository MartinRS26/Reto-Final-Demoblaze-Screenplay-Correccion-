package com.demoblaze.automation.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.RealizarPedidoPage.COMPRAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickBotonPurchase implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(COMPRAR));
    }

    public static ClickBotonPurchase comprar() {
        return instrumented(ClickBotonPurchase.class);
    }
}