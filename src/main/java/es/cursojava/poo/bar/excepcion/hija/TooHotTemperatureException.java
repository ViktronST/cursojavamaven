package es.cursojava.poo.bar.excepcion.hija;

import es.cursojava.poo.bar.excepcion.padre.TemperatureException;

public class TooHotTemperatureException extends TemperatureException {
    
    public TooHotTemperatureException(String mensaje) {
        super(mensaje);
    }

}
