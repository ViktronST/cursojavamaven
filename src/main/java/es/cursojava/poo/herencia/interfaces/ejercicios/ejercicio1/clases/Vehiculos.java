package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.clases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehiculos {
    private String marca;
    private String modelo;
    private int anio;
    private double velocidadMaxima;
    private String tipo;    //Gasolina, Diesel, Hibrido o Electrico.

    //Constructor
    public Vehiculos(String marca, String modelo, int anio, double velocidadMaxima, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidadMaxima = velocidadMaxima;
        this.tipo = tipo;
    }

    //Métodos
    public void mostrarInformacion() {
        System.out.println(toString());
        // System.out.println("\n- Mostrando información del vehículo -");
        // System.out.println("Categoría: " + categoria);
        // System.out.println("Marca: " + marca);
        // System.out.println("Modelo: " + modelo);
        // System.out.println("Año: " + anio);
        // System.out.println("Velocidad Máxima: " + velocidadMaxima + " KM.");
        // System.out.println("Tipo: " + tipo);
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Marca: ").append(marca);
        sb.append(", Modelo: ").append(modelo);
        sb.append(", Año: ").append(anio);
        sb.append(", Velocidad Máxima: ").append(velocidadMaxima).append(" Km.");
        sb.append(", Tipo: ").append(tipo);
        return sb.toString();
    }

}
