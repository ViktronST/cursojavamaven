package es.cursojava.poo.herencia.concesionario;

import es.cursojava.poo.herencia.ejercicios.vehiculos.MainVehiculos;    //Librería 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PruebaVehiculoProfe {
    public static void main(String[] args) {
        Vehiculo coche = new Coche("Toyota", "Corolla", 2020, 200,"Diesel",5,true);
        coche.mostrarInformacion();
        double importe = coche.calcularImpuesto();
        System.out.println("El importe a pagar es "+importe);
        //coche.volar();
        if (coche instanceof Coche){
             ((Coche)coche).getAnio();
             coche.mostrarInformacion();
        }

        Garaje garaje = new Garaje("Mammago", 2, 1, 1);
        if (garaje.hayHueco(coche)) {
            System.out.println("Hay plazas para el vehículo " + coche);
            garaje.aparcarVehiculo(coche);
        }

        Vehiculo[] vehiculos =  garaje.getPlazas(); //Recorremos el Array.
        System.out.println("Plazas del garaje " + garaje.getNombre());        
        for (int i = 0; i < vehiculos.length; i++) {
            Vehiculo v = vehiculos[i];
            if (v != null) {
                System.out.println("Plaza " + (i+1));
                v.mostrarInformacion();
            }
            
        }
    }
}
