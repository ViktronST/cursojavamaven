package es.cursojava.inicio.colecciones.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import es.cursojava.poo.centroeducativo.Alumno;

import java.util.Iterator;

public class PruebasSets {
    public static void main(String[] args) {
        //Linked ordena los objetos.
        Set<Alumno> alumnos = new LinkedHashSet<>();    //...HashSet<>();
        alumnos.add(new Alumno("N1", "A1", 70, 4.9, "cuñado@gmail.es"));
        alumnos.add(new Alumno("N2", "A2", 19, 9.9, "email@asdas.es"));
        alumnos.add(new Alumno("N3", "A3", 21, 7.9, "email@asdas.es"));

        Alumno a4 = new Alumno("N4", "A4", 22, 11, "email@asdas.es");

        System.out.println(alumnos.add(a4));
        System.out.println(alumnos.add(a4));

        //El tamaño del "Set" será de 2, porque estamos CREANDO 2 objetos, fijate que hay dos "new Alumno".
        System.out.println(alumnos.size());

        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombre());
        }

        System.out.println("--------------");

        // //Posisción del 1er alumno.
        // Alumno a = ite.next();
        // System.out.println(a.getNombre());
        // //Pasamos al siguiente alumno (2do alumno).
        // a = ite.next();
        // System.out.println(a.getNombre());
        // a = ite.next();
        // System.out.println(a.getNombre());
        // a = ite.next();
        // System.out.println(a.getNombre());

        Iterator<Alumno> ite = alumnos.iterator();
        while(ite.hasNext()){
            Alumno a = ite.next();
            System.out.println(a.getNombre());
        }

    }
}
