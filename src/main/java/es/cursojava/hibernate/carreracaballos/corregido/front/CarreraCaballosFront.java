package es.cursojava.hibernate.carreracaballos.corregido.front;

import java.util.List;

import es.cursojava.hibernate.carreracaballos.corregido.dto.CaballoDTO;
import es.cursojava.hibernate.carreracaballos.corregido.services.CarreraService;
import es.cursojava.utiles.Utilidades2;

public class CarreraCaballosFront {
    private CarreraService servicio;
    private String nombreCarrera;

    public CarreraCaballosFront (String nombreCarrera){
        this.servicio = new CarreraService();
        this.nombreCarrera = nombreCarrera;
    }

    public void iniciaMenuCarrera() {
        System.out.println("Bienvenido a la carrera "+ this.nombreCarrera);
        int opcion;
        do {
            Utilidades2.pintarMenu(new String[]{"1.Insertar nuevo caballo ",
                "2.Mostrar Caballos","3.Iniciar carrera","4.Salir"});
            opcion = Utilidades2.pideDatoNumerico("Elige una opción: ");

            
            switch (opcion) {
                case 1:
                    creaCaballo();
                    break;
                case 2:
                    mostrarCaballos();
                    break;
                case 3:
                    iniciarCarrera();
                    break;
                case 4:
                    System.out.println("Aaaadios!");;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 4);

    }

    private CaballoDTO creaCaballo (){
       
        String nombre = Utilidades2.pideDatoCadena("Nombre: ");
        int edad = Utilidades2.pideDatoNumerico("edad: ");
        double velocidad = Utilidades2.pideDatoDecimal("Velocidad máxima (km/h): ");
        int triunfos = Utilidades2.pideDatoNumerico("Número de triunfos: : ");
        double experiencia = Utilidades2.pideDatoDecimal("Experiencia (0.0 a 10.0): ");
        String activo = Utilidades2.pideDatoCadena("¿Está activo? ");

        CaballoDTO caballoDto = new CaballoDTO(nombre, edad, velocidad, triunfos, experiencia, 
                activo.equalsIgnoreCase("si"));
        servicio.insertarCaballo(caballoDto);
        return caballoDto;
    }

    private void mostrarCaballos (){
        List<CaballoDTO> caballos = servicio.obtenerCaballos(false);
        caballos.forEach(System.out::println);
    }

    private void iniciarCarrera (){
        servicio.simularCarrera(servicio.obtenerCaballos(true));
    }
}
