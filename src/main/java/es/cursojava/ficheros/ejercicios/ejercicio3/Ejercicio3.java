package es.cursojava.ficheros.ejercicios.ejercicio3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.cursojava.poo.centroeducativo.Alumno;

public class Ejercicio3 {
    public static void main(String[] args) {
        String[] asignaturas = crearAsignaturas();
        List<Alumno> alumnos = crearAlumnos(asignaturas);
        mostrarAlumnos(alumnos, asignaturas);
        crearArchivoAlumno(alumnos, "./recursos/ficha_alumnado.txt");
    }

    private static String[] crearAsignaturas() {
        String[] asignaturas = {"Java", "SQL", "Programacion"};
        return asignaturas;
        // return new String[] asignaturas = {"Java", "SQL", "Programación"};
    }

    private static List<Alumno> crearAlumnos(String[] asignaturas) {
        List<Alumno> listaAlumnos = new ArrayList<>();

        listaAlumnos.add(new Alumno("Michael", "Trevor", 22, 2.3, "asd1@asd.com", asignaturas));
        listaAlumnos.add(new Alumno("Sara", "Connor", 20, 10, "asd2@asd.com", asignaturas));
        listaAlumnos.add(new Alumno("John", "Lenon", 21, 7.5, "asd3@asd.com", asignaturas));

        // listaAlumnos.add(new Alumno("John", "Lenon", 21, 7.5, "asd3@asd.com", new String[] asignaturas = {"Java", "SQL", "Programacion"}));

        return listaAlumnos;
    }

    private static void mostrarAlumnos(List<Alumno> alumnos, String[] asignaturas) {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno + " | Asignaturas: " + Arrays.toString(asignaturas));
        }
    }

    private static void crearArchivoAlumno (List<Alumno> alumnos, String nombre) {
        File archivo = new File(nombre);
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, false))) {
            for (Alumno alumno : alumnos) {
                buffer.append("Nombre: " + alumno.getNombre() + " | Apellido: " + alumno.getApellido() + " | Edad: " + alumno.getEdad() 
                + " | Nota Media: " + alumno.getNotaMedia() + " | Email: " + alumno.getEmail() 
                + " | Asignaturas: " + Arrays.toString(alumno.getAsignaturas()) + "\n");
            System.out.println("El archivo se ha creado con éxito!");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}


