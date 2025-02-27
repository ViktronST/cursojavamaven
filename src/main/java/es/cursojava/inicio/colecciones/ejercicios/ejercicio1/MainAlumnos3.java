package es.cursojava.inicio.colecciones.ejercicios.ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.cursojava.inicio.excepciones.ejercicios.ejercicio1.NotaInvalidaExcepcion;
import es.cursojava.poo.centroeducativo.Alumno;

public class MainAlumnos3 {
    public static void main(String[] args) {
        MainAlumnos2 probar = new MainAlumnos2();

        Colegio colegio1 = new Colegio("Cole1", "Dir1");
        Map<String, List<Alumno>> aulasCole1 = probar.distribuirAlumnosEnAulas(MainAlumnos2.obtenerAlumnos1(6));
        colegio1.setAulas(aulasCole1);

        Map<String, List<Alumno>> aulasCole2 = probar.distribuirAlumnosEnAulas(MainAlumnos2.obtenerAlumnos1(6));
        Colegio colegio2 = new Colegio("Cole2", "Dir2", aulasCole2);

        Map<String, List<Alumno>> aulasCole3 = probar.distribuirAlumnosEnAulas(MainAlumnos2.obtenerAlumnos1(6));
        Colegio colegio3 = new Colegio("Cole3", "Dir3", aulasCole3);

        try {
            colegio3.guardarAlumno("aula3", new Alumno("Jotaro", "Joestar", 17, 9.9, "null"));
        } catch (NotaInvalidaExcepcion error1) {
            System.out.println("Error: " + error1.getMessage());
        }

        //colegio3.guardarAlumno1("aula3", Arrays.asList(new Alumno("Alum4", "Apell4", 4), new Alumno("Alum5", "Apell5", 5)));

        List<Colegio> colegios = Arrays.asList(colegio1, colegio2, colegio3);

        MainAlumnos3 main = new MainAlumnos3();
        main.pintaDatosColegios(colegios);

    }

    private void pintaDatosColegios(List<Colegio> colegios) {
        for (Colegio colegio : colegios) {
            System.out.println(colegio.getNombre() + " - " + colegio.getDireccion());
            for (String aula : colegio.getAulas().keySet()) {
                System.out.println("\t" + aula);
                List<Alumno> alumnos = colegio.getAulas().get(aula);
                for (Alumno alumno : alumnos) {
                    System.out.println("\t\t" + alumno.getNombre() + " " + alumno.getApellido());
                }
            }
            //colegio.mostrarDatos();
        }
    }

}
