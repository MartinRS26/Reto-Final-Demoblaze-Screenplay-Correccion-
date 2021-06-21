package com.demoblaze.automation.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class RealizarPedidoPage {
    public static final Target NOMBRE_PEDIDO = Target.the("Espacio para nombre en el pedido").located(By.xpath("//*/input[@id=\"name\"]"));
    public static final Target PAIS_PEDIDO = Target.the("Espacio para pais en el pedido").located(By.xpath("//*/input[@id=\"country\"]"));
    public static final Target CIUDAD_PEDIDO = Target.the("Espacio para ciudad en el pedido").located(By.xpath("//*/input[@id=\"city\"]"));
    public static final Target TARJETA_CREDITO_PEDIDO = Target.the("Espacio para tarjeta de credito en el pedido").located(By.xpath("//*/input[@id=\"card\"]"));
    public static final Target MES_PEDIDO = Target.the("Espacio para mes en el pedido").located(By.xpath("//*/input[@id=\"month\"]"));
    public static final Target YEAR_PEDIDO = Target.the("Espacio para year en el pedido").located(By.xpath("//*/input[@id=\"year\"]"));
    public static final Target COMPRAR = Target.the("Seleccion Boton purchase").located(By.xpath("//*/button[contains(text(),'Purchase')]"));


}
