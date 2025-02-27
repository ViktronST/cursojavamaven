package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.clases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Yogur extends Alimentos{
    private String sabor;

    //Constructor
    public Yogur(String nombre, double precio, String fechaCaducidad, String sabor) {
        super(nombre, precio, fechaCaducidad);
        this.sabor = sabor;
    }
    
    //Método
    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    //Interfaces
    @Override
    public void NoUpdate() {
        System.out.println("Este Yogur "+ getNombre() + " puede ser: ");
        System.out.println("Consultado");
        System.out.println("Insertado");
        System.out.println("Deleteado");
    }

    @Override
    public void select() {  //Consultar debe de estar en la clase Producto.
        System.out.println("Consultando Yogur" + getNombre());
    }

    @Override
    public void insert() { 
        System.out.println("Insertando Yogur" + getNombre());
    }

    @Override
    public void delete() {   
        System.out.println("Deleteando Yogur" + getNombre());
    }

    //toString
    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(" Yogur [ ");
        sb.append(padre);
        //sb.append(super.toString());
        sb.append(", Sabor: ").append(sabor);
        sb.append(" ]");
        return sb.toString();
    }
}
