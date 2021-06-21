package com.demoblaze.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.CredencialesUsuarioPage.BOTON_LOGIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IrAPerfilDeUsuario implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BOTON_LOGIN));
    }

    public static IrAPerfilDeUsuario Registrado() {
        return instrumented(IrAPerfilDeUsuario.class);
    }
}