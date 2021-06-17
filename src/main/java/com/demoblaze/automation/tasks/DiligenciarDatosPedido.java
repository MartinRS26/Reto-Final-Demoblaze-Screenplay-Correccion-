package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.IngresoDatosPedido;
import com.demoblaze.automation.models.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DiligenciarDatosPedido implements Task {

    private Data data;

    public DiligenciarDatosPedido(Data data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(IngresoDatosPedido.datosPedido(data));
    }

    public static DiligenciarDatosPedido DemoBlaze(Data data) {
        return instrumented(DiligenciarDatosPedido.class, data);
    }
}
