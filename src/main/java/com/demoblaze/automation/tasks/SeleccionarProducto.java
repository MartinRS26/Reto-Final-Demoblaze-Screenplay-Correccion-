package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.ElegirSamsungGalaxyS6;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarProducto implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ElegirSamsungGalaxyS6.SeleccionarSamsungGalaxyS6());

    }

    public static SeleccionarProducto DemoBlaze() {
        return instrumented(SeleccionarProducto.class);
    }
}
