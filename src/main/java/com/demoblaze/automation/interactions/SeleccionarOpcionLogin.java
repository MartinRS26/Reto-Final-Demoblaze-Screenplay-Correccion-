package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.DemoBlazeHomePage.LOGIN_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarOpcionLogin implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LOGIN_USER));
    }

    public static SeleccionarOpcionLogin opcionLogin() {
        return instrumented(SeleccionarOpcionLogin.class);
    }
}