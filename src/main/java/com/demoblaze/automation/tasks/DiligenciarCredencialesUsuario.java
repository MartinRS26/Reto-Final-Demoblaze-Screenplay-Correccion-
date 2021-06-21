package com.demoblaze.automation.tasks;

import com.demoblaze.automation.utils.informacionRequerida;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static com.demoblaze.automation.userinterfaces.CredencialesUsuarioPage.NOMBRE_USUARIO;
import static com.demoblaze.automation.userinterfaces.CredencialesUsuarioPage.PASSWORD_USUARIO;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class DiligenciarCredencialesUsuario implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(informacionRequerida.nombreUsuario).into(NOMBRE_USUARIO),
                Enter.theValue(informacionRequerida.password).into(PASSWORD_USUARIO));
    }

    public static DiligenciarCredencialesUsuario paraIngresarAPerfil() {
        return instrumented(DiligenciarCredencialesUsuario.class);
    }
}
