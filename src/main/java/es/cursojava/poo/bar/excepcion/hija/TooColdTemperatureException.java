package es.cursojava.poo.bar.excepcion.hija;

import es.cursojava.poo.bar.excepcion.padre.TemperatureException;

public class TooColdTemperatureException extends TemperatureException {
    
    public TooColdTemperatureException(String mensaje) {
        super(mensaje);
    }

}
