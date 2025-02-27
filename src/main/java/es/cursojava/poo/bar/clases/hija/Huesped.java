package es.cursojava.poo.bar.clases.hija;

import es.cursojava.poo.bar.clases.padre.Cliente;

public class Huesped extends Cliente{
    private String dni;

    // Constructor
    public Huesped(String nombre, String dni) {
        super(nombre);
        this.dni = dni;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "Huesped [ DNI: " + dni + " ] ";
    }

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    
}
