package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.ClickBotonLogin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IrAPerfilDeUsuario implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ClickBotonLogin.botonLogin());
    }

    public static IrAPerfilDeUsuario Demoblaze() {
        return instrumented(IrAPerfilDeUsuario.class);
    }
}