package es.cursojava.inicio.excepciones.ejemplos;

import es.cursojava.poo.centroeducativo.Alumno;

public class EjemploExcepciones {
    public static void main(String[] args) {
        System.out.println("Inicio del programa");
        Alumno alumno = null;
        try {
            metodo1();
        } catch (MiExcepcion error) {
            error.printStackTrace();
        }

        try {
            String[] colores = {"Rojo", "Verde"};
            System.out.println(7/0);
            System.out.println(colores[2]);
            System.out.println(alumno.getNombre());

        } catch (NullPointerException error1) {
            System.out.println("Error: " + error1.getMessage());
        } catch (ArrayIndexOutOfBoundsException error2) {
            System.out.println("Error: " + error2.getMessage());
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        } finally {
            System.out.println("Siempre se ejecuta");
            //Cierro fichero.
        }

        System.out.println("Fin del programa");
    }

    public static void metodo1() throws MiExcepcion {
        if (Math.random() > 0.5) {
            //throw new NullPointerException("Error null creado por mi");
            MiExcepcion me = new MiExcepcion("Mensaje de mi excepción");
            try {
                throw me;
            } catch (MiExcepcion e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Método 1 correcto");
        }
    }


}
