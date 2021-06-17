package com.demoblaze.automation.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CredencialesUsuarioPage {
    public static final Target NOMBRE_USUARIO = Target.the("Espacio para nombre de usuario").located(By.id("loginusername"));
    public static final Target PASSWORD_USUARIO = Target.the("Espacio para password de usuario").located(By.id("loginpassword"));
    public static final Target BOTON_LOGIN = Target.the("Boton para realizar login").located(By.xpath("//*/div[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
}
