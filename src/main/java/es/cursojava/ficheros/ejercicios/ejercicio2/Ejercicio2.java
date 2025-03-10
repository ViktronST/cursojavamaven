package es.cursojava.ficheros.ejercicios.ejercicio2;

import java.io.File;

import es.cursojava.utiles.Utilidades2;

public class Ejercicio2 {
    public static void main(String[] args) {
        // String directorio = Utilidades2.pideDatoCadena("Introduce un directorio: ");
        String directorio = "D:\\ficheros";
        File dir = new File(directorio);
        if (dir.exists() && dir.isDirectory()) {
            pintarFicheros(dir, 0);
        }
    }

    private static void pintarFicheros(File dir, int contador) {
        
        if (contador>=2) {
            return;
        }

        // System.out.println(dir.getPath() + "\\");
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {   // Si es un archivo pintará sus datos.
                System.out.print("\t" + file.getName() + " - ");
                System.out.print("\t" + file.length()+ " - ");
                System.out.println("\t" + (file.isHidden()?"Archivo oculto":"Archivo visible"));
            } else {    // Si es un directorio lo pintará + su contenido.
                System.out.println(dir.getPath() + "\\");
                pintarFicheros(file, contador+=1);    // Lo llamamos a sí mismo.
                // File[] files2 = file.listFiles();
                // for (File file2 : files2) {
                //     if (file2.isFile()) {
                //         System.out.print("\t\t" + file2.getName() + " - ");
                //         System.out.print("\t\t" + file2.length()+ " - ");
                //         System.out.println("\t\t" + (file2.isHidden()?"Archivo oculto":"Archivo visible"));
                //     } else {
                //         System.out.println("\t\t" + file2.getPath() + "\\");
                //     }
                // }
            }
        }
    }

}
