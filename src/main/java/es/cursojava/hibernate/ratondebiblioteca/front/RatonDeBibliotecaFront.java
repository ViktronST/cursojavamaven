package es.cursojava.hibernate.ratondebiblioteca.front;

import java.util.Date;
import java.util.List;

import es.cursojava.hibernate.ratondebiblioteca.dto.CarnetBibliotecaDTO;
import es.cursojava.hibernate.ratondebiblioteca.dto.EstudianteDTO;
import es.cursojava.hibernate.ratondebiblioteca.services.BibliotecaService;
import es.cursojava.utiles.Utilidades;
import es.cursojava.utiles.Utilidades2;

public class RatonDeBibliotecaFront {
    private BibliotecaService servicio;
    private String nombreBiblioteca;

    public RatonDeBibliotecaFront (String nombreBiblioteca){
        this.servicio = new BibliotecaService();
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public void iniciarMenuBiblioteca(){
        System.out.println("===============================================================");
        System.out.println("Bienvenido a la Biblioteca: '"+ this.nombreBiblioteca + "'");
        int opcion;
        do {
            Utilidades2.pintarMenu(new String[]{"1.Insertar nuevo estudiante ",
                "2.Mostrar estudiantes","3.Obtener estudiante por nombre" ,"4.Salir"});
            opcion = Utilidades2.pideDatoNumerico("Elige una opción: ");
            
            switch (opcion) {
                case 1:
                    creaEstudiante();
                    break;
                case 2:
                    mostrarEstudiante();
                    break;
                case 3:
                    obtenerPorEstudianteNombre();
                    break;
                case 4:
                    System.out.println("Aaaadios!");;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 4);
    }

    private EstudianteDTO creaEstudiante() {
        System.out.println("= = = = = = = = = =");
        System.out.println("Datos del Estudiante: ");
        String nombre = Utilidades.pideDatoCadena("Nombre: ");
        String apellidos = Utilidades.pideDatoCadena("Apellidos: ");
        String edad = Utilidades.pideDatoCadena("Edad: ");
        String dni = Utilidades.pideDatoCadena("DNI: ");
        String email = Utilidades.pideDatoCadena("Email: ");

        System.out.println("= = = = = = = = = =");
        System.out.println("Carnet del Estudiante: ");
        Date fechaEmision = Utilidades2.pideDatoFecha("Fecha de emisión: ");
        Date fechaVencimiento = Utilidades2.pideDatoFecha("Fecha de vencimiento: ");

        CarnetBibliotecaDTO carnetDto = new CarnetBibliotecaDTO(fechaEmision, fechaVencimiento);
        EstudianteDTO estudianteDto = new EstudianteDTO(nombre, apellidos, edad, dni, email, carnetDto);

        servicio.insertarEstudiante(estudianteDto, carnetDto);

        return estudianteDto;
    }

    private void mostrarEstudiante() {
        List<EstudianteDTO> estudiantes = servicio.obtenerEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en la base de datos.");
        } else {
            System.out.println("Lista de estudiantes:");
            for (EstudianteDTO estudiante : estudiantes) {
                System.out.println(estudiante.getNombre() 
                                + " - " + estudiante.getCarnetBibliotecaDTO().getFechaEmision() 
                                + " - " + estudiante.getCarnetBibliotecaDTO().getFechaVencimiento());
            }
        }
    }

    private void obtenerPorEstudianteNombre() {
        String nombre = Utilidades.pideDatoCadena("Nombre del estudiante: ");
        EstudianteDTO estudiante = servicio.obtenerEstudiantePorNombre(nombre);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante.getNombre());
        } else {
            System.out.println("No se encontró el estudiante con nombre: " + nombre);
        }
    }
}
