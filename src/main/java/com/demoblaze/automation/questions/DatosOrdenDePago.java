package com.demoblaze.automation.questions;


import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import static com.demoblaze.automation.userinterfaces.OrdenDePagoPage.NOMBRE_ORDEN;
import static com.demoblaze.automation.userinterfaces.OrdenDePagoPage.NUMERO_TARJETA_ORDEN;

public class DatosOrdenDePago {
    public static Question<String> nombreOrden() {
        return actor -> TextContent.of(NOMBRE_ORDEN).viewedBy(actor).asString().trim().substring(55, 61);

    }

    public static Question<String> numeroTarjeta() {
        return actor -> TextContent.of(NUMERO_TARJETA_ORDEN).viewedBy(actor).asString().trim().substring(39, 49);

    }

}
