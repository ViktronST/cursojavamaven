package es.cursojava.poo.bar2.clases;

import es.cursojava.poo.bar2.excepcion.hija.TooColdTemperatureException;
import es.cursojava.poo.bar2.excepcion.hija.TooHotTemperatureException;

public class TazaCafe {
    private String tipoCafe;
    private double temperatura;

    // Constructor
    public TazaCafe(String tipoCafe, double temperatura) {
        this.tipoCafe = tipoCafe;
        this.temperatura = temperatura;
    }

    // toString
    @Override
    public String toString() {
        return "TazaCafe [Temperatura= " + temperatura + ", Tipo de Cafe= " + tipoCafe + "]";
    }

    // Método tomarCafe
    public void tomarCafes() throws TooHotTemperatureException, TooColdTemperatureException {
        System.out.println("\tTomando café...");

        temperatura = Math.random() * 100;
        System.out.println("\tTemperatura del café: " + temperatura);

        if (temperatura > 80) {
            throw new TooHotTemperatureException("¡Cuidado! El café está muy caliente.");
        } else if (temperatura < 40) {
            throw new TooColdTemperatureException("¡Cuidado! El café está muy frío.");
        } else {
            System.out.println("\t¡Qué rico café!");
        }
        
    }

    // Getters y Setters
    public String getTipoCafe() {
        return tipoCafe;
    }

    public void setTipoCafe(String tipoCafe) {
        this.tipoCafe = tipoCafe;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

}
