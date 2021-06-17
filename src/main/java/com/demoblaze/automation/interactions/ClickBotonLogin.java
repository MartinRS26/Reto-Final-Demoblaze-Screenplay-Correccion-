package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.CredencialesUsuarioPage.BOTON_LOGIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickBotonLogin implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BOTON_LOGIN));
    }

    public static ClickBotonLogin botonLogin() {
        return instrumented(ClickBotonLogin.class);
    }
}