package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.AbrirCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IrAlCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(AbrirCarrito.carrito());
    }

    public static IrAlCarrito DemoBlaze() {
        return instrumented(IrAlCarrito.class);
    }
}

