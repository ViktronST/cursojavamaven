package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.clases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BiciMontana extends Bicicleta{
    private int diametroRuedas;

    //Constructor
    public BiciMontana(String marca, String modelo, int anio, double velocidadMaxima, String tipo, int numMarchas,
            int diametroRuedas) {
        super(marca, modelo, anio, velocidadMaxima, tipo, numMarchas);
        this.diametroRuedas = diametroRuedas;
    }
    
    //Método
    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    //Interfaces
    @Override
    public void NoUpdate() { 
        System.out.println("Esta Bici de Montaña "+ getMarca() + " puede ser: ");
        System.out.println("Consultada");
        System.out.println("Insertada");
        System.out.println("Deleteada");
    }

    @Override
    public void select() {  //Consultar debe de estar en la clase Vehículo.
        System.out.println("Consultando Bici de Montaña " + getMarca());
    }

    @Override
    public void insert() { 
        System.out.println("Insertando Bici de Montaña " + getMarca());
    }

    @Override
    public void delete() {   
        System.out.println("Deleteando Bici de Montaña " + getMarca());
    }

    //toString
    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(" Bici de Montaña [ ");
        sb.append(padre);
        //sb.append(super.toString());
        sb.append(", Diámetro de Ruedas: ").append(diametroRuedas);
        sb.append(" ]");
        return sb.toString();
    }
}
