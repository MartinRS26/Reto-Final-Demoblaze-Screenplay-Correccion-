package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.IngresoCredencialesUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class DiligenciarCredencialesUsuario implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(IngresoCredencialesUsuario.CredencialesUsuario());
    }

    public static DiligenciarCredencialesUsuario DemoBlaze() {
        return instrumented(DiligenciarCredencialesUsuario.class);
    }
}
