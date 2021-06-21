package com.demoblaze.automation.exceptions;

public class Excepciones extends AssertionError {

    public static final String OrdenNoCorresponde = "Los datos del comprador no coinciden en la orden";


    public static final String ProductoNoCorresponde = "El producto en el carrito no corresponde al seleccionado";

    public Excepciones(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }


}
