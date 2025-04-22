package es.cursojava.hibernate.carreracaballos.corregido.front;

import java.util.List;

import es.cursojava.hibernate.carreracaballos.corregido.dto.CaballoDTO;
import es.cursojava.hibernate.carreracaballos.corregido.entities.CaballoCarrera;
import es.cursojava.hibernate.carreracaballos.corregido.services.CarreraService;
import es.cursojava.utiles.Utilidades;
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
                "2.Mostrar Caballos", "3.Iniciar carrera","4.Borrar caballo" ,
                "5.Cambiar jinete", "6.Mostrar caballos por nacionalida jinete", "7.Salir"});
            opcion = Utilidades2.pideDatoNumerico("Elige una opción: ");
            
            switch (opcion) {
                case 1:
                    creaCaballoConJinete();
                    break;
                case 2:
                    mostrarCaballosConJinetes();
                    break;
                case 3:
                    iniciarCarrera();
                    break;
                case 4:
                    eliminarCaballo();
                    break;
                case 5:
                    cambiarJinete();
                    break;
                case 6:
                    mostrarPorNacionalidad();
                    break;
                case 7:
                    System.out.println("Aaaadios!");;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 4);

    }

    // private CaballoDTO creaCaballo (){
       
    //     String nombre = Utilidades2.pideDatoCadena("Nombre: ");
    //     int edad = Utilidades2.pideDatoNumerico("edad: ");
    //     double velocidad = Utilidades2.pideDatoDecimal("Velocidad máxima (km/h): ");
    //     int triunfos = Utilidades2.pideDatoNumerico("Número de triunfos: : ");
    //     double experiencia = Utilidades2.pideDatoDecimal("Experiencia (0.0 a 10.0): ");
    //     String activo = Utilidades2.pideDatoCadena("¿Está activo? ");

    //     CaballoDTO caballoDto = new CaballoDTO(nombre, edad, velocidad, triunfos, experiencia, 
    //             activo.equalsIgnoreCase("si"));
    //     servicio.insertarCaballo(caballoDto);
    //     return caballoDto;
    // }

    private CaballoDTO creaCaballoConJinete (){

        String nombre = Utilidades2.pideDatoCadena("Nombre: ");
        int edad = Utilidades2.pideDatoNumerico("edad: ");
        double velocidad = Utilidades2.pideDatoDecimal("Velocidad máxima (km/h): ");
        int triunfos = Utilidades2.pideDatoNumerico("Número de triunfos: : ");
        double experiencia = Utilidades2.pideDatoDecimal("Experiencia (0.0 a 10.0): ");
        String activo = Utilidades2.pideDatoCadena("¿Está activo? ");
        String jinete = Utilidades2.pideDatoCadena("Nombre Jinete: ");
        String nacionalidad = Utilidades2.pideDatoCadena("Nacionalidad Jinete: ");

        CaballoDTO caballoDto = new CaballoDTO(nombre, edad, velocidad, triunfos, experiencia, 
                    activo.equalsIgnoreCase("si"), jinete, nacionalidad);
        servicio.insertarCaballo(caballoDto);
        return caballoDto;
    }

    // private void mostrarCaballos (){
    //     List<CaballoDTO> caballos = servicio.obtenerCaballos(false);
    //     caballos.forEach(System.out::println);
    // }

    private void mostrarCaballosConJinetes (){
        List<CaballoDTO> caballos = servicio.obtenerCaballos(false);
        for (CaballoDTO caballoDTO : caballos) {
            System.out.println(caballoDTO.getNombre() + " - " + caballoDTO.getNombreJinete());
        }
    }

    private void iniciarCarrera (){
        servicio.simularCarrera(servicio.obtenerCaballos(true));
    }

    private void eliminarCaballo (){
        // Abrimos la session con este método.
        // Así no hará falta que al eliminar se haga un select para comprobar que existe el caballo.
        
        // mostrarCaballos();
        mostrarCaballosConJinetes();

        // Sin el método anterior, hibernate hace un select para comprobar que existe el caballo.
        int id = Utilidades2.pideDatoNumerico("Elige el id del caballo a eliminar: ");
        servicio.eliminarCaballo(id);
        System.out.println("Caballo con id " + id + " eliminado correctamente");
    }

    private void cambiarJinete (){
        long idCaballo = Utilidades.pideDatoNumerico("Introduce id caballo a para actualizar su jinete: ");

        CaballoDTO caballoDTO = servicio.obtenerJineteCaballo(idCaballo);
        System.out.println("El jinete actual es: ");
        System.out.println("\t" + caballoDTO.getNombreJinete());
        System.out.println("\t" + caballoDTO.getNacionalidadJinete());

        String nombreJinete = Utilidades2.pideDatoCadena("Nombre del jinete: ");
        String nacionalidadJinete = Utilidades2.pideDatoCadena("Nacionalidad del jinete: ");
        caballoDTO.setNombreJinete(nombreJinete);
        caballoDTO.setNacionalidadJinete(nacionalidadJinete);

        servicio.actualizarJineteCaballo(idCaballo, caballoDTO);
    }

    private void mostrarPorNacionalidad (){
        String nacionalidad = Utilidades2.pideDatoCadena("Nacionalidad Jinete");
        List<CaballoCarrera> caballos = servicio.obtenerCaballosNacionalidadJinete(nacionalidad);
        for (CaballoCarrera caballoCarrera : caballos) {
            System.out.println(caballoCarrera);
        }
    }
}
