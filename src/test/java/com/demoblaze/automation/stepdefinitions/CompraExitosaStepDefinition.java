package com.demoblaze.automation.stepdefinitions;

import com.demoblaze.automation.exceptions.Excepciones;
import com.demoblaze.automation.models.Data;
import com.demoblaze.automation.questions.DatosOrdenDePago;
import com.demoblaze.automation.questions.NombreProductoCarrito;
import com.demoblaze.automation.tasks.*;
import com.demoblaze.automation.userinterfaces.DemoBlazeHomePage;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CompraExitosaStepDefinition {
    @Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor usuario = Actor.named("usuario");

    String nombreProducto = "Samsung galaxy s6";

    @Before
    public void setUp() {
        usuario.can(BrowseTheWeb.with(hisBrowser));
        usuario.wasAbleTo(Open.browserOn(new DemoBlazeHomePage()));
    }

    @Dado("^que el usuario esta logueado$")
    public void queElUsuarioEstaLogueado() {
        usuario.attemptsTo(IrHaciaLoginDeUsuario.DemoBlaze());
        usuario.attemptsTo(DiligenciarCredencialesUsuario.DemoBlaze());
        usuario.attemptsTo(IrAPerfilDeUsuario.Demoblaze());
    }

    @Cuando("^agrego producto al carro$")
    public void agregoProductoAlCarro() throws InterruptedException {
        usuario.attemptsTo(SeleccionarProducto.DemoBlaze());
        usuario.attemptsTo(AgregarAlCarrito.DemoBlaze());
        WebDriverWait wait = new WebDriverWait(hisBrowser, 9);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }

    @Entonces("^valido el nombre del articulo$")
    public void validoElNombreDelArticulo() {
        usuario.attemptsTo(IrAlCarrito.DemoBlaze());
        usuario.should(seeThat("El nombre del producto del carrito es:", NombreProductoCarrito.value(), equalTo(nombreProducto)).orComplainWith(Excepciones.class, Excepciones.ProductoNoCorresponde));

    }

    @Entonces("^los datos de orden de compra seran \"([^\"]*)\" y \"([^\"]*)\"$")
    public void losDatosDeOrdenDeCompraSeranY(String nombreEnOrden, String tarjetaOrden, List<Data> dataList) {
        usuario.attemptsTo(RealizarPedido.DemoBlaze());
        WebDriverWait wait1 = new WebDriverWait(hisBrowser, 9);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/div[@id='orderModal']/div/div")));
        usuario.attemptsTo(DiligenciarDatosPedido.DemoBlaze(dataList.get(0)));
        usuario.attemptsTo(GenerarOrdenDePago.DemoBlaze());
        usuario.should(seeThat("El nombre en la orden de compra es", DatosOrdenDePago.nombreOrden(), equalTo(nombreEnOrden)).orComplainWith(Excepciones.class, Excepciones.OrdenNoCorresponde));
        usuario.should(seeThat("El numero de la tarjeta de compra es", DatosOrdenDePago.numeroTarjeta(), equalTo(tarjetaOrden)).orComplainWith(Excepciones.class, Excepciones.OrdenNoCorresponde));


    }


}


