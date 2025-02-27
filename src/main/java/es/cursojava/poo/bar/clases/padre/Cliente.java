package es.cursojava.poo.bar.clases.padre;

public class Cliente {
    private String nombre;

    // Constructor
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    // toString
    @Override
    public String toString() {
        return "Cliente [ Nombre: " + nombre + " ] -> ";
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
