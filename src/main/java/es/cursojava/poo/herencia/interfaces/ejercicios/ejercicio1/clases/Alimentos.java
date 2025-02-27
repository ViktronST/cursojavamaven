package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.clases;

import es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.interfaces.NoUpdatable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Alimentos extends Productos implements NoUpdatable{
    private String fechaCaducidad;

    //Constructor
    public Alimentos(String nombre, double precio, String fechaCaducidad) {
        super(nombre, precio);
        this.fechaCaducidad = fechaCaducidad;
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
        sb.append(" Alimentos { ");
        sb.append(padre);
        //sb.append(super.toString());
        sb.append(" Fecha de Caducidad: ").append(fechaCaducidad);
        sb.append(" }");
        return sb.toString();
    }

    
}
