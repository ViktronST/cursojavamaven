package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.clases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cafetera extends ProductosElectronicos {
    private String tipo; //Cápsulas o granos de café.

    //Constructor
    public Cafetera(String nombre, double precio, String fechaFabricacion, String tipo) {
        super(nombre, precio, fechaFabricacion);
        this.tipo = tipo;
    }

    //Método
    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    //Interfaces
    @Override
    public void SiUpdate() {
        System.out.println("Esta Cafetera "+ getNombre() + " puede ser: ");
        System.out.println("Consultada");
        System.out.println("Insertada");
        System.out.println("Updateada");
        System.out.println("Deleteada");
    }

    @Override
    public void select() {  //Consultar debe de estar en la clase Producto.
        System.out.println("Consultando Cafetera " + getNombre());
    }

    @Override
    public void insert() { 
        System.out.println("Insertando Cafetera " + getNombre());
    }

    @Override
    public void update() {
        System.out.println("Updateando Cafetera " + getNombre());
    }

    @Override
    public void delete() {   
        System.out.println("Deleteando Cafetera " + getNombre());
    }

    //toString
    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(" Cafetera [ ");
        sb.append(padre);
        //sb.append(super.toString());
        sb.append(", Tipo: ").append(tipo);
        sb.append(" ]");
        return sb.toString();
    }


}
