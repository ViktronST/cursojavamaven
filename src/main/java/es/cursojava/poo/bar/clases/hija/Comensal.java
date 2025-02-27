package es.cursojava.poo.bar.clases.hija;

import es.cursojava.poo.bar.clases.padre.Cliente;

public class Comensal extends Cliente{
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

    
    
}
