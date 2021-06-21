package com.demoblaze.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.SamsungGalaxyS6Page.OPCION_CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IrAlCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(OPCION_CARRITO));
    }

    public static IrAlCarrito DemoBlaze() {
        return instrumented(IrAlCarrito.class);
    }
}

