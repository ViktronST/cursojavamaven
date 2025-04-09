package es.cursojava.hibernate.ratondebiblioteca.front;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.hibernate.ratondebiblioteca.dto.EstudianteDTO;
import es.cursojava.hibernate.ratondebiblioteca.entities.CarnetBiblioteca;
import es.cursojava.hibernate.ratondebiblioteca.services.BibliotecaService;
import es.cursojava.utiles.HibernateUtil;
import es.cursojava.utiles.Utilidades;
import es.cursojava.utiles.Utilidades2;

public class RatonDeBibliotecaFront {
    private static Session session = HibernateUtil.getSession();
    private BibliotecaService servicio;
    private String nombreBiblioteca;

    public RatonDeBibliotecaFront (String nombreBiblioteca){
        this.servicio = new BibliotecaService();
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public void iniciarMenuBiblioteca(){
        System.out.println("Bienvenido a la carrera "+ this.nombreBiblioteca);
        int opcion;
        do {
            Utilidades2.pintarMenu(new String[]{"1.Insertar nuevo estudiante ",
                "2.Mostrar estudiantes","3.Salir"});
            opcion = Utilidades2.pideDatoNumerico("Elige una opción: ");
            
            switch (opcion) {
                case 1:
                    creaEstudiante();
                    break;
                case 2:
                    mostrarEstudiante();
                    break;
                case 3:
                    System.out.println("Aaaadios!");;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 4);
    }

    private void creaEstudiante() {
        String nombre = Utilidades.pideDatoCadena("Nombre del usuario: ");
        Date fechaEmision = Utilidades2.pideDatoFecha("Fecha de emisión: ");
        Date fechaVencimiento = Utilidades2.pideDatoFecha("Fecha de vencimiento: ");

        CarnetBiblioteca carnet = new CarnetBiblioteca(fechaEmision, fechaVencimiento);
        Estudiante estudianteDto = new Estudiante(nombre, carnet);
       
        Transaction tx = session.beginTransaction();
        session.persist(estudianteDto);
        tx.commit();
        System.out.println("Estudiante insertado.");
    }

    private void mostrarEstudiante() {
        List<EstudianteDTO> estudiantes = servicio.obtenerEstudiantes();
        estudiantes.forEach(System.out::println);
    }
}
