package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.clases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Productos {
    private String nombre;
    private double precio;
    
    //Constructor
    public Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Método
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Nombre: ").append(nombre);
        sb.append(", Precio: ").append(precio);
        return sb.toString();
    }

}
