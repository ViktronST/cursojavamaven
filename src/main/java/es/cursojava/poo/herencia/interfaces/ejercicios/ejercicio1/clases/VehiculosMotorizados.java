package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.clases;

import es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.interfaces.Operable;
import es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.interfaces.SiUpdatable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class VehiculosMotorizados extends Vehiculos implements Operable, SiUpdatable{
    private String motor;

    //Constructor
    public VehiculosMotorizados(String marca, String modelo, int anio, double velocidadMaxima, String tipo, String motor) {
        super(marca, modelo, anio, velocidadMaxima, tipo);
        this.motor = motor;
    }

    //Método
    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    //Interfaces
    @Override
    public void operable() {
    }

    @Override
    public void encender() {
        System.out.println("El Vehículo Motorizado está ENCENDIDO.");
    }

    @Override
    public void apagar() {
        System.out.println("El Vehículo Motorizado está APAGADO.");
    }

    //toString
    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Vehículos Motorizados { ");
        sb.append(padre);
        //sb.append(super.toString());
        sb.append(", Motor: ").append(motor);
        sb.append(" }");
        return sb.toString();
    }

    
}
