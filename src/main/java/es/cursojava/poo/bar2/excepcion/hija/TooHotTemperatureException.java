package es.cursojava.poo.bar2.excepcion.hija;

import es.cursojava.poo.bar2.excepcion.padre.TemperatureException;

public class TooHotTemperatureException extends TemperatureException {
    
    public TooHotTemperatureException(String mensaje) {
        super(mensaje);
    }

}
