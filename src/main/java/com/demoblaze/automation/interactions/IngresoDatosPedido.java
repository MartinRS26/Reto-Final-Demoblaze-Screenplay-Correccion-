package com.demoblaze.automation.interactions;

import com.demoblaze.automation.models.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static com.demoblaze.automation.userinterfaces.RealizarPedidoPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresoDatosPedido implements Interaction {

    private Data data;


    public IngresoDatosPedido(Data data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(data.getName()).into(NOMBRE_PEDIDO),
                Enter.theValue(data.getCountry()).into(PAIS_PEDIDO),
                Enter.theValue(data.getCity()).into(CIUDAD_PEDIDO),
                Enter.theValue(data.getCardNumber()).into(TARJETA_CREDITO_PEDIDO),
                Enter.theValue(data.getMonth()).into(MES_PEDIDO),
                Enter.theValue(data.getYear()).into(YEAR_PEDIDO)
        );
    }

    public static IngresoDatosPedido datosPedido(Data data) {
        return instrumented(IngresoDatosPedido.class, data);
    }
}
