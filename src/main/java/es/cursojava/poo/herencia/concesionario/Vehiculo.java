package es.cursojava.poo.herencia.concesionario;

import java.time.LocalDate;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private double velocidadMaxima;
    private String tipo;    //Gasolina, Diesel, Hibrido o Electrico.
    
    //Constructor
    public Vehiculo(String marca, String modelo, int anio, double velocidadMaxima, String tipo) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tMARCA: ").append(marca);
        sb.append("\n\tMODELO: ").append(modelo);
        sb.append("\n\tAÑO: ").append(anio);
        sb.append("\n\tVELOCIDAD MÁXIMA: ").append(velocidadMaxima).append(" Km.");
        sb.append("\n\tTIPO: ").append(tipo);
        return sb.toString();
    }

    public int calcularImpuesto() {
        int anioActual = LocalDate.now().getYear();     //Se obtiene la fecha y el año actual.
        int antiguedad = anioActual - anio;
        int impuestoBase = 200;
        int impuestoTotal;      //Esta es una variable local, no puede inicializar sin un valor determinado.

        //Cálculo del impuesto según la antigüedad.
        if (antiguedad > 10 && antiguedad < 20) {
            impuestoTotal = impuestoBase + (int) (0.05 * impuestoBase); //5% más
        } else if (antiguedad > 20) {
            impuestoTotal = impuestoBase + (int) (0.10 * impuestoBase); //10% más
        } else {
            impuestoTotal = impuestoBase;
        }

        //Cálculo del impuesto según el tipo de combustible.
        if (tipo.equalsIgnoreCase("Gasolina") || tipo.equalsIgnoreCase("Diesel")) {
            impuestoTotal += (10 / 100) * impuestoBase; //10% más
        } else if (tipo.equalsIgnoreCase("Eléctrico")) {
            impuestoTotal -= (10 / 100) * impuestoBase; //10% menos
        } else if (tipo.equalsIgnoreCase("Híbrido")) {
            impuestoTotal -= (5 / 100) * impuestoBase; //5% menos
        }

        //Cálculo del impuesto según la categoría de vehículo.
        if (this instanceof Camion) {
            impuestoTotal += (int) (0.10 * impuestoTotal); //+10% más
        } else if (this instanceof Coche) {
            impuestoTotal += (int) (0.05 * impuestoTotal); //+5% más
        } else if (this instanceof Motocicleta) {
            impuestoTotal -= (int) (0.05 * impuestoTotal); //-5% menos
        }

        return impuestoTotal;
    }

    //public abstract int acelerar();

    //Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
