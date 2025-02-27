package es.cursojava.poo.herencia.interfaces.ejercicios.ejercicio3.clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjercicioListas {
    public static void main(String[] args) {
        Coche coche1 = new Coche("Mercedes", "Berlina", 2022, 215, "Eléctrico", 5, true);
        Coche coche2 = new Coche("BMW", "M3 E30", 1990, 235, "Gasolina", 3, false);
        Motocicleta motocicleta1 = new Motocicleta("Kawasaki", "Z900", 2024, 260, "Gasolina", false, 948);
        Motocicleta motocicleta2 = new Motocicleta("BMW", "R60", 1970, 110, "Gasolina", true, 594);
        Camion camion1 = new Camion("Volvo", "FH", 2023, 300, "Eléctrico", 65, 5);
        Camion camion2 = new Camion("Iveco", "X-Way", 2010, 200, "Diesel", 30, 3);

        //Una manera de hacerlo.
        List<Vehiculo> vehiculos = new ArrayList<>();
        System.out.println(vehiculos.size());
        System.out.println(vehiculos.isEmpty());
        vehiculos.add(coche1);
        vehiculos.add(coche2);
        vehiculos.add(motocicleta1);
        vehiculos.add(motocicleta2);
        vehiculos.add(camion1);
        vehiculos.add(camion2);

        //Otra manera.
        vehiculos.addAll(vehiculos = Arrays.asList(coche1, coche2, motocicleta1, motocicleta2, camion1, camion2));
        //vehiculos = Arrays.asList(coche1, coche2, motocicleta1, motocicleta2, camion1, camion2);
        System.out.println(vehiculos.size());

        //Recorremos las posiciones de las listas y ponemos los vehiculos a acelerar.
        // for (Vehiculo vehiculo : vehiculos) {
        //     vehiculo.acelerar();
        // }

        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo vm = vehiculos.get(i);   //Devuelve el objeto que se encuentra en dicha posición.
            //vm.encender();
        }
    }
}
