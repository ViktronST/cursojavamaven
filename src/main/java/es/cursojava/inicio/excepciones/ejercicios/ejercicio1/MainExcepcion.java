package es.cursojava.inicio.excepciones.ejercicios.ejercicio1;

import java.util.ArrayList;
import java.util.List;

import es.cursojava.inicio.funciones.Utilidades2;
import es.cursojava.poo.centroeducativo.Alumno;

public class MainExcepcion {
    // public static void main(String[] args) {
    //     MainExcepcion main = new MainExcepcion();
    //     main.creaAlumno("VK", "ST", 24, 10);
    // }

    // private void creaAlumno(String nombre, String apellido, int edad, double notaMedia) {
    //     try {
    //         Alumno alumno = new Alumno(nombre, apellido, edad, notaMedia);
    //         System.out.println(alumno);
    //     } catch (NotaInvalidaExcepcion error1) {
    //         System.out.println("Error: " + error1.getMessage());
    //     }
    // }

    public static void main(String[] args) {
        
        List <Alumno> listaAlumnos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Datos del alumno " + (i+1));
            try {
                String nombre = Utilidades2.pideDatoCadena("Introduce el NOMBRE del alumno " + (i+1) + ": ");
                String apellido = Utilidades2.pideDatoCadena("Introduce el APELLIDO del alumno: " + (i+1) + ": ");
                int edad = Utilidades2.pideDatoNumerico("Introduce la EDAD del alumno: " + (i+1) + ": ");
                double notaMedia = Utilidades2.pideDatoDecimal("Introduce la NOTA MEDIA del alumno: " + (i+1) + ": ");

                Alumno alumno = new Alumno(nombre, apellido, edad, notaMedia);
                listaAlumnos.add(alumno);

            } catch (NotaInvalidaExcepcion error1) {
                System.err.println("El alumno no se ha podido crear correctamente. Error: " + error1.getMessage());
            } catch (IllegalArgumentException error2) {
                System.err.println("El alumno no se ha podido crear correctamente. Error: " + error2.getMessage());
            }
            // Se pueden controlar 2 o más excepciones en un mismo bloque catch. -> (NotaInvalidaExcepcion | IllegalArgumentException error)

        }

        System.out.println("Número de alumnos gurdados: " + listaAlumnos.size());
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno);
        }

    }
}
