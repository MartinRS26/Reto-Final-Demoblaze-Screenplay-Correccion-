package com.demoblaze.automation.stepdefinitions;

import com.demoblaze.automation.exceptions.Excepciones;
import com.demoblaze.automation.models.Data;
import com.demoblaze.automation.questions.DatosOrdenDePago;
import com.demoblaze.automation.questions.NombreProductoCarrito;
import com.demoblaze.automation.tasks.*;
import com.demoblaze.automation.userinterfaces.DemoBlazeHomePage;
import com.demoblaze.automation.utils.informacionRequerida;
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



    @Before
    public void setUp() {
        usuario.can(BrowseTheWeb.with(hisBrowser));
        usuario.wasAbleTo(Open.browserOn(new DemoBlazeHomePage()));
    }

    @Dado("^que el usuario esta logueado$")
    public void queElUsuarioEstaLogueado() {
        usuario.attemptsTo(IrHaciaLogin.deUsuario());
        usuario.attemptsTo(DiligenciarCredencialesUsuario.paraIngresarAPerfil());
        usuario.attemptsTo(IrAPerfilDeUsuario.Registrado());
    }

    @Cuando("^agrego producto al carro$")
    public void agregoProductoAlCarro()throws InterruptedException  {
        usuario.attemptsTo(SeleccionarProducto.Disponible());
        usuario.attemptsTo(AgregarAlCarrito.deLaTienda());
        usuario.attemptsTo(AceptarAlerta.deProductoAgregado(hisBrowser));
        usuario.attemptsTo(IrAlCarrito.DemoBlaze());
    }

    @Entonces("^valido el nombre del articulo$")
    public void validoElNombreDelArticulo() {

        usuario.should(seeThat("El nombre del producto del carrito es:", NombreProductoCarrito.value(), equalTo(informacionRequerida.nombreProducto)).orComplainWith(Excepciones.class, Excepciones.ProductoNoCorresponde));

    }

    @Entonces("^los datos de orden de compra seran \"([^\"]*)\" y \"([^\"]*)\"$")
    public void losDatosDeOrdenDeCompraSeranY(String nombreEnOrden, String tarjetaOrden, List<Data> dataList) {
        usuario.attemptsTo(RealizarPedido.deProductos());
        usuario.attemptsTo(DiligenciarDatosPedido.paraOrdenDePago(dataList.get(0)));
        usuario.attemptsTo(GenerarOrdenDePago.alComprarProducto());
        usuario.should(seeThat("El nombre en la orden de compra es", DatosOrdenDePago.nombreOrden(), equalTo(nombreEnOrden)).orComplainWith(Excepciones.class, Excepciones.OrdenNoCorresponde));
        usuario.should(seeThat("El numero de la tarjeta de compra es", DatosOrdenDePago.numeroTarjeta(), equalTo(tarjetaOrden)).orComplainWith(Excepciones.class, Excepciones.OrdenNoCorresponde));


    }


}


