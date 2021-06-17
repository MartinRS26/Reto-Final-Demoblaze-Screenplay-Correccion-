package com.demoblaze.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import static com.demoblaze.automation.userinterfaces.CarritoPage.NOMBRE_PRODUCTO;

public class NombreProductoCarrito implements Question<String> {
    public static Question<String> value() {
        return new NombreProductoCarrito();

    }

    @Override
    public String answeredBy(Actor actor) {
        return NOMBRE_PRODUCTO.resolveFor(actor).getText();
    }


}