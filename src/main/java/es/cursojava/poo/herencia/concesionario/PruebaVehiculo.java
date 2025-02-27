package es.cursojava.poo.herencia.concesionario;

public class PruebaVehiculo {
    public static void main(String[] args) {
        PruebaVehiculo probar = new PruebaVehiculo();
        probar.infoVehiculo();
        Garaje garaje = new Garaje("Mammago", 2, 1, 1);
        probar.aparcarVehiculos(probar.crearVehiculos(), garaje);
    }

    private void infoVehiculo() {
        Vehiculo[] vehiculos = crearVehiculos();
        System.out.println("\n- Mostrando información del vehículo -");
        mostrarInfoVehiculo(vehiculos);
    }

    private Vehiculo[] crearVehiculos() {
        System.out.println("Creando vehículos.");
        Coche coche1 = new Coche("Mercedes", "Berlina", 2022, 215, "Eléctrico", 5, true);
        Coche coche2 = new Coche("BMW", "M3 E30", 1990, 235, "Gasolina", 3, false);
        Motocicleta motocicleta1 = new Motocicleta("Kawasaki", "Z900", 2024, 260, "Gasolina", false, 948);
        Motocicleta motocicleta2 = new Motocicleta("BMW", "R60", 1970, 110, "Gasolina", true, 594);
        Camion camion1 = new Camion("Volvo", "FH", 2023, 300, "Eléctrico", 65, 5);
        Camion camion2 = new Camion("Iveco", "X-Way", 2010, 200, "Diesel", 30, 3);

        Vehiculo[] vehiculos = {coche1, coche2, motocicleta1, motocicleta2, camion1, camion2};
        System.out.println("Vehículos creados. \nTotal: " + vehiculos.length);
        return vehiculos;
    }

    private void mostrarInfoVehiculo(Vehiculo[] vehiculos) {
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInformacion();
            //System.out.println(vehiculo);
            System.out.println("Impuesto a pagar: " + vehiculo.calcularImpuesto() + " Euros.");
            System.out.println("-------------------------------------------");
        }
    }

    private void aparcarVehiculos (Vehiculo[] vehiculos, Garaje garaje) {
        for (Vehiculo vehiculo : vehiculos) {
            if (garaje.hayHueco(vehiculo)) {
                System.out.println("Hay plazas para el vehículo " + vehiculo);
                garaje.aparcarVehiculo(vehiculo);
            }else {
                System.out.println("No hay plazas disponibles para este vheículo " + vehiculo);
            }
        }
        
    }
    
}
