package com.demoblaze.automation.interactions;

import com.demoblaze.automation.tasks.SeleccionarProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.automation.userinterfaces.CarritoPage.NOMBRE_PRODUCTO;
import static com.demoblaze.automation.userinterfaces.SamsungGalaxyS6Page.OPCION_CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirCarrito implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(OPCION_CARRITO));

    }

    public static AbrirCarrito carrito() {
        return instrumented(AbrirCarrito.class);
    }
}