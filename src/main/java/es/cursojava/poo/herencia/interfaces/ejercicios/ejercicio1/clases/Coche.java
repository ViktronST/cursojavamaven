package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.clases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coche extends VehiculosMotorizados{
    private int numPuertas;

    //Constructor
    public Coche(String marca, String modelo, int anio, double velocidadMaxima, String tipo, String motor,
            int numPuertas) {
        super(marca, modelo, anio, velocidadMaxima, tipo, motor);
        this.numPuertas = numPuertas;
    }

    //Método
    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }
    
    //Interfaces
    @Override
    public void SiUpdate() {  
        System.out.println("Este Coche "+ getMarca() + " puede ser: ");
        System.out.println("Consultado");
        System.out.println("Insertado");
        System.out.println("Updateado");
        System.out.println("Deleteado");
    }

    @Override
    public void select() {  //Consultar debe de estar en la clase Vehículo.
        System.out.println("Consultando Coche " + getMarca());
    }

    @Override
    public void insert() { 
        System.out.println("Insertando Coche " + getMarca());
    }

    @Override
    public void update() {
        System.out.println("Updateando Coche " + getMarca());
    }

    @Override
    public void delete() {   
        System.out.println("Deleteando Coche " + getMarca());
    }

    //toString
    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(" Coche [ ");
        sb.append(padre);
        //sb.append(super.toString());
        sb.append(", Número de Puertas: ").append(numPuertas);
        sb.append(" ]");
        return sb.toString();
    }
}
