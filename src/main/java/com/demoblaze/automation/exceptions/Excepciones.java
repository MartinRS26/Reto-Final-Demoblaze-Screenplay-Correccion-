package com.demoblaze.automation.exceptions;

public class Excepciones extends AssertionError{
    /*  La excepción OrdenNoCorresponde se presentará cuando los datos "name" y "cardNumber"de la orden
        de pago generada al comprar el producto, no sean los mismos que los ingresados en formulario del
        pedido
     */
    public static final String OrdenNoCorresponde = "Los datos del comprador no coinciden en la orden";

    /*  La excepcion ProductoNoCorresponde se presentará cuando el nombre del producto que se añade al
        carrito es diferente al producto establecido
    */
    public static final String ProductoNoCorresponde ="El producto en el carrito no corresponde al seleccionado";

    public Excepciones(String mensaje, Throwable causa){
        super(mensaje, causa);
    }


}
