package com.demoblaze.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;


public class CarritoPage {
    public static final Target NOMBRE_PRODUCTO = Target.the("Nombre Producto del carrito").located(By.xpath("//*/td[contains(text(),'Sam')]"));
    public static final Target REALIZAR_PEDIDO = Target.the("Seleccionar Boton Place Order").located(By.xpath("//div[@class=\"col-lg-1\"]/button"));
}
