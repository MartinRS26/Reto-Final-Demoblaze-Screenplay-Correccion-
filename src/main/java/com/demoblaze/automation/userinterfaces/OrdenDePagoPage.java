package com.demoblaze.automation.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class OrdenDePagoPage {
    public static final Target NUMERO_TARJETA_ORDEN = Target.the("Numero de tarjeta de la orden de pago").located(By.xpath("/html/body/div[10]/p"));
    public static final Target NOMBRE_ORDEN = Target.the("Nombre de la orden de pago").located(By.xpath("/html/body/div[10]/p"));
}
