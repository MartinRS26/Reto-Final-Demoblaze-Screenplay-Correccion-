package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.SeleccionarOpcionLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IrHaciaLoginDeUsuario implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SeleccionarOpcionLogin.opcionLogin());
    }

    public static IrHaciaLoginDeUsuario DemoBlaze() {
        return instrumented(IrHaciaLoginDeUsuario.class);
    }
}
