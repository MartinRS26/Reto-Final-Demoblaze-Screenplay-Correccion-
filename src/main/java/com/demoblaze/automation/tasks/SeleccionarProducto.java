package com.demoblaze.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.ProductosPage.SAMSUNG_GALAXY_S6;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarProducto implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SAMSUNG_GALAXY_S6));

    }

    public static SeleccionarProducto Disponible() {
        return instrumented(SeleccionarProducto.class);
    }
}
