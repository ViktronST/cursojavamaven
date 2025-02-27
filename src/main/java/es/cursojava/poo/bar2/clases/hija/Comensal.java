package es.cursojava.poo.bar2.clases.hija;

import es.cursojava.poo.bar2.clases.TazaCafe;
import es.cursojava.poo.bar2.clases.padre.Cliente;
import es.cursojava.poo.bar2.excepcion.hija.TooColdTemperatureException;
import es.cursojava.poo.bar2.excepcion.hija.TooHotTemperatureException;
import es.cursojava.poo.bar2.interfaz.Cafeteable;

public class Comensal extends Cliente implements Cafeteable{
    private boolean tieneReserva;

    // Constructor
    public Comensal(String nombre, boolean tieneReserva) {
        super(nombre);
        this.tieneReserva = tieneReserva;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "Comensal [ Tiene Reserva: " + tieneReserva + " ] ";
    }

    // Getters y Setters
    public boolean isTieneReserva() {
        return tieneReserva;
    }

    public void setTieneReserva(boolean tieneReserva) {
        this.tieneReserva = tieneReserva;
    }

    @Override
    public void tomarCarfe(TazaCafe taza) throws TooHotTemperatureException, TooColdTemperatureException {
        // TODO Auto-generated method stub
        
    }

    // @Override
    // public void tomarCarfe(TazaCafe taza) throws TooHotTemperatureException, TooColdTemperatureException {
    //     System.out.println("Tomando café...");
       
    //     if(taza.getTemperatura() > 80) {
    //         throw new TooHotTemperatureException("\t¡Cuidado! El café está muy caliente. La taza está exactamente a " + taza.getTemperatura());
    //     } else if(taza.getTemperatura() < 20) {
    //         throw new TooColdTemperatureException("\t¡Cuidado! El café está muy frío. La taza está exactamente a " + taza.getTemperatura());
    //     } else {
    //         System.out.println(this.getNombre() + ": ¡Qué rico café! Está en su punto, exactamente a " + taza.getTemperatura());
    //     }
    // }
    
}
