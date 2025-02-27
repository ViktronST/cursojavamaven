package es.cursojava.poo.bar2.excepcion.hija;

import es.cursojava.poo.bar2.excepcion.padre.TemperatureException;

public class TooColdTemperatureException extends TemperatureException {
    
    public TooColdTemperatureException(String mensaje) {
        super(mensaje);
    }

}
