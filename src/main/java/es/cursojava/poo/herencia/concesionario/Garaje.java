package es.cursojava.poo.herencia.concesionario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Garaje {
    private String nombre;
    private int maximoCoches;
    private int maximoMotos;
    private int maximoCamiones;
    private Vehiculo[] plazas;  //Array de vehículos.

    //Constructor
    public Garaje(String nombre, int maximoCoches, int maximoMotos, int maximoCamiones){
        this.nombre = nombre;
        this.maximoCoches = maximoCoches;
        this.maximoMotos = maximoMotos;
        this.maximoCamiones = maximoCamiones;
        plazas = new Vehiculo[maximoCoches + maximoMotos + maximoCamiones]; //Tamaño total del garaje.
    }

    //Método
    public void aparcarVehiculo(Vehiculo vehiculo){
        
        for (int i = 0; i < plazas.length; i++) {   //Recorremos las plazas.
            
            if (plazas[i] == null){
                plazas[i] = vehiculo;
                System.out.println("Vehículo " + vehiculo.getMarca() + " aparcado en la plaza " + (i+1));
            }
        }
    }

    public boolean hayHueco(Vehiculo vehiculo){
        boolean hayHueco = false;
        int contador = 0;

        //Cuento cuantos vehículos del mismo tiop que el vehículo que me pasan hay en el garaje.
        for (int i = 0; i < plazas.length; i++) {
            
            if (plazas[i] != null && plazas[i].getClass().equals(vehiculo.getClass())){
                contador++;
            }

            if (vehiculo instanceof Coche){
                hayHueco = contador < maximoCoches;
            }else if (vehiculo instanceof Camion){
                hayHueco = contador < maximoCamiones;
            }else if (vehiculo instanceof Motocicleta){
                Motocicleta moto = (Motocicleta) vehiculo; //Hacemos un cast a Motocicleta para saber si el vehiculo es una moto.
                hayHueco = contador < maximoMotos && !moto.isTieneSidecar();  //Si tiene sidecar no entra.
            }
        }

        return hayHueco;
    }

    //toString
    @Override
    public String toString() {
        return "Garaje [Nombre: " + nombre + ", Plazas para Coches: " + maximoCoches + ", Plazas para Motos: " + maximoMotos
                + ", Plazas para Camiones " + maximoCamiones + "]";
    }
    
}
