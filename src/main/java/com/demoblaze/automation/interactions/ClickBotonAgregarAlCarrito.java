package com.demoblaze.automation.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.SamsungGalaxyS6Page.AGREGAR_AL_CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ClickBotonAgregarAlCarrito implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(AGREGAR_AL_CARRITO));

    }

    public static ClickBotonAgregarAlCarrito agregarAlCarrito() {
        return instrumented(ClickBotonAgregarAlCarrito.class);
    }
}
