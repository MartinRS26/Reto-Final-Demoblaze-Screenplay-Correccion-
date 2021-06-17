package com.demoblaze.automation.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.ProductosPage.SAMSUNG_GALAXY_S6;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ElegirSamsungGalaxyS6 implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SAMSUNG_GALAXY_S6));
    }

    public static ElegirSamsungGalaxyS6 SeleccionarSamsungGalaxyS6() {
        return instrumented(ElegirSamsungGalaxyS6.class);
    }
}