package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.clases;

import es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.interfaces.Operable;
import es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio1.interfaces.SiUpdatable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ProductosElectronicos extends Productos implements Operable, SiUpdatable{
    private String fechaFabricacion;

    //Constructor
    public ProductosElectronicos(String nombre, double precio, String fechaFabricacion) {
        super(nombre, precio);
        this.fechaFabricacion = fechaFabricacion;
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
        System.out.println("El Producto Electrónico está ENCENDIDO.");
    }

    @Override
    public void apagar() {
        System.out.println("El Producto Electrónico está APAGADO.");
    }

    //toString
    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(" Productos Electrónicos { ");
        sb.append(padre);
        //sb.append(super.toString());
        sb.append(" Fecha de Fabricación: ").append(fechaFabricacion);
        sb.append(" }");
        return sb.toString();
    }
    
}
