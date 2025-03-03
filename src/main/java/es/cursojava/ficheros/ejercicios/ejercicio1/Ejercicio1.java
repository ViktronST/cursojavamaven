package es.cursojava.ficheros.ejercicios.ejercicio1;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ejercicio1 {
    private static final Logger logger = LoggerFactory.getLogger(Ejercicio1.class);
    public static void main(String[] args) {
        File directorio = new File("C:\\Users\\Tardes\\Ficheros");

        File directorioImganes = new File(directorio, "\\Imágenes");
        File directorioDocumentos = new File(directorio, "\\Documentos");
        File directorioOtros = new File(directorio, "\\Otros");

        File[] ficheros = directorio.listFiles();
        for (File file : ficheros) {
            System.out.println(file.getName());

            if (file.getName().contains("jpg")) {
                
            }
        }

    }
}
