package com.demoblaze.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.demoblaze.automation.userinterfaces.SamsungGalaxyS6Page.AGREGAR_AL_CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarAlCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(AGREGAR_AL_CARRITO, isVisible()).forNoMoreThan(2).seconds(), Click.on(AGREGAR_AL_CARRITO));

    }

    public static AgregarAlCarrito deLaTienda() {
        return instrumented(AgregarAlCarrito.class);
    }
}
