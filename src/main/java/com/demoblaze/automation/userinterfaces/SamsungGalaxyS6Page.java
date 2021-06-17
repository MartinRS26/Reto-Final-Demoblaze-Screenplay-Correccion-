package com.demoblaze.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SamsungGalaxyS6Page {
    public static final Target AGREGAR_AL_CARRITO = Target.the("Boton agregar al carrito").located(By.xpath("//*/a[@class=\"btn btn-success btn-lg\"]"));
    public static final Target OPCION_CARRITO = Target.the("Seleccionar opcion carrito").located(By.id("cartur"));
}
