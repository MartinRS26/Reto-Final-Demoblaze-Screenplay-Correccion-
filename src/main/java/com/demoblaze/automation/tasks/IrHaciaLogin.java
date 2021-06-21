package com.demoblaze.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.DemoBlazeHomePage.LOGIN_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IrHaciaLogin implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LOGIN_USER));
    }

    public static IrHaciaLogin deUsuario() {
        return instrumented(IrHaciaLogin.class);
    }
}
