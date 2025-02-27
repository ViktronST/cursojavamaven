package es.cursojava.poo.bar2.clases.hija;

import es.cursojava.poo.bar.clases.padre.Cliente;
import es.cursojava.poo.bar2.clases.TazaCafe;
import es.cursojava.poo.bar2.excepcion.hija.TooColdTemperatureException;
import es.cursojava.poo.bar2.excepcion.hija.TooHotTemperatureException;
import es.cursojava.poo.bar2.interfaz.Cafeteable;

public abstract class ClienteCafetero extends Cliente implements Cafeteable{

    public ClienteCafetero(String nombre) {
            super(nombre);
        }
    
        @Override
    public void tomarCarfe(TazaCafe taza) throws TooHotTemperatureException, TooColdTemperatureException {
        System.out.println("El cliente " + this.getNombre() + " se va a tomar un café...");
        System.out.println("El café está a " + taza.getTemperatura() + " grados.");
       
        if(taza.getTemperatura() > 80) {
            throw new TooHotTemperatureException("\t¡Cuidado! El café está muy caliente. La taza está exactamente a " + taza.getTemperatura() + " grados.");
        } else if(taza.getTemperatura() < 20) {
            throw new TooColdTemperatureException("\t¡Cuidado! El café está muy frío. La taza está exactamente a " + taza.getTemperatura() + " grados.");
        } else {
            System.out.println(this.getNombre() + ": ¡Qué rico café! Está en su punto, exactamente a " + taza.getTemperatura() + " grados.");
        }
    }

}
