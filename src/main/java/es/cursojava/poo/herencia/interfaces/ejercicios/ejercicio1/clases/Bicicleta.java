package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.clases;

import es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.interfaces.NoUpdatable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Bicicleta extends Vehiculos implements NoUpdatable{
    private int numMarchas;
    
    public Bicicleta(String marca, String modelo, int anio, double velocidadMaxima, String tipo, int numMarchas) {
        super(marca, modelo, anio, velocidadMaxima, tipo);
        this.numMarchas = numMarchas;
    }

    //Método
    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    //toString
    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(" Bicicleta { ");
        sb.append(padre);
        //sb.append(super.toString());
        sb.append(", Número de Marchas: ").append(numMarchas);
        sb.append(" }");
        return sb.toString();
    }
}
