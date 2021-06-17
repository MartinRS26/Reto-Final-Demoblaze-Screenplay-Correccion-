package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.ClickBotonAgregarAlCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarAlCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ClickBotonAgregarAlCarrito.agregarAlCarrito());
    }

    public static AgregarAlCarrito DemoBlaze() {
        return instrumented(AgregarAlCarrito.class);
    }
}
