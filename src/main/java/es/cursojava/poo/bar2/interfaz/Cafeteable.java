package es.cursojava.poo.bar2.interfaz;

import es.cursojava.poo.bar2.clases.TazaCafe;
import es.cursojava.poo.bar2.excepcion.hija.TooColdTemperatureException;
import es.cursojava.poo.bar2.excepcion.hija.TooHotTemperatureException;

public interface Cafeteable {
    void tomarCafe(TazaCafe taza) throws TooHotTemperatureException, TooColdTemperatureException;
}
