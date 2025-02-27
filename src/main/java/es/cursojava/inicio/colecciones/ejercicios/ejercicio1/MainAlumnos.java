package es.cursojava.inicio.colecciones.ejercicios.ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
//import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.cursojava.inicio.excepciones.ejercicios.ejercicio1.NotaInvalidaExcepcion;
import es.cursojava.inicio.funciones.Utilidades;
import es.cursojava.poo.centroeducativo.Alumno;

public class MainAlumnos {
    public static void main(String[] args) {
        MainAlumnos probar = new MainAlumnos();
        probar.mostrarInfoAlumnos(probar.crearAlumnos());
        probar.mostrarNotasPorNombre(probar.crearAlumnos());
        probar.mostrarAlumnoPorAula(probar.crearAlumnos());
    }

    private List<Alumno> crearAlumnos() throws NotaInvalidaExcepcion {
        Alumno alumno1 = new Alumno("N1", "A1", 18, 4.9, "asdas1@gmail.com");
        Alumno alumno2 = new Alumno("N2", "A2", 19, 5, "asdas2@gmail.com");
        Alumno alumno3 = new Alumno("N1", "A3", 20, 4, "asdas3@gmail.com");
        Alumno alumno4 = new Alumno("N2", "A4", 21, 10, "asdas4@gmail.com");
        Alumno alumno5 = new Alumno("N3", "A5", 22, 7, "asdas5@gmail.com");
        Alumno alumno6 = new Alumno("N1", "A6", 23, 3.5, "asdas6@gmail.com");

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        alumnos.add(alumno4);
        alumnos.add(alumno5);
        alumnos.add(alumno6);
       
        //Otras manera de crear las listas.
        // alumnos.add(new Alumno("N1", "A1", 18, 4.9, "asdas1@gmail.com"));
        // alumnos.add(new Alumno("N2", "A2", 19, 5, "asdas2@gmail.com"));
        // alumnos.add(new Alumno("N3", "A3", 20, 4, "asdas3@gmail.com"));
        // alumnos.add(new Alumno("N4", "A4", 21, 10, "asdas4@gmail.com"));
        // alumnos.add(new Alumno("N5", "A5", 22, 7, "asdas5@gmail.com"));
        // alumnos.add(new Alumno("N6", "A6", 23, 3.5, "asdas6@gmail.com"));
        
        //Otra manera de crear las listas.
        //List<Alumno> listaAlumnos = Arrays.asList(alumno1, alumno2, alumno3, alumno4, alumno5, alumno6);

        return alumnos;
    }

    private void mostrarInfoAlumnos(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    private void mostrarNotasPorNombre(List<Alumno> alumnos) {
        System.out.println("\n- - - - - Mostrar Notas - - - - -");
        String nombre = Utilidades.pideDatoCadena("Introduce nombre del alumno: ");
        boolean encontrado = false;

        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\nNombre: " + alumno.getNombre() + " - Nota Media: " + alumno.getNotaMedia());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\nNo hay alumnos con el nombre '" + nombre + "'.");
        }
    }

    private void mostrarAlumnoPorAula(List<Alumno> alumnos) {
        System.out.println("\n- - - Mostrar Alumno por Aula - - -");
        Map<String,List<Alumno>> curso = new LinkedHashMap<>();
        
        List<Alumno> alumnos1 = Arrays.asList(alumnos.get(0), alumnos.get(1));
        List<Alumno> alumnos2 = Arrays.asList(alumnos.get(2), alumnos.get(3));
        List<Alumno> alumnos3 = Arrays.asList(alumnos.get(4), alumnos.get(5));

        curso.put("Aula 1", alumnos1);
        curso.put("Aula 2", alumnos2);
        curso.put("Aula 3", alumnos3);

        Set<String> aulas = curso.keySet();
        for (String aula : aulas) {
            System.out.println(aula + "\n" + curso.get(aula) + "\n");
        }
    }

    
}
