package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio2.clases;

import es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio2.interfaces.Pago;

public class ProcesadorPagos {

    public static void realizarPago(Pago metodoPago, double monto){
        metodoPago.procesarPago(monto);
   }
   
}
