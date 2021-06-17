package com.demoblaze.automation.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


public class ProductosPage {
    public static final Target SAMSUNG_GALAXY_S6 = Target.the("Seleccionar Samsung Galaxy S6").located(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a"));
}
