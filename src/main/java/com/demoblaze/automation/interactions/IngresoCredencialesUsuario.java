package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static com.demoblaze.automation.userinterfaces.CredencialesUsuarioPage.NOMBRE_USUARIO;
import static com.demoblaze.automation.userinterfaces.CredencialesUsuarioPage.PASSWORD_USUARIO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresoCredencialesUsuario implements Interaction {

    String nombreUsuario = "martin121314";
    String password = "12345678901234";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(nombreUsuario).into(NOMBRE_USUARIO),
                Enter.theValue(password).into(PASSWORD_USUARIO));
    }

    public static IngresoCredencialesUsuario CredencialesUsuario() {
        return instrumented(IngresoCredencialesUsuario.class);
    }
}
