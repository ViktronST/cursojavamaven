package es.cursojava.ficheros;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmpezandoConFicheros {
    private static final Logger logger = LoggerFactory.getLogger(EmpezandoConFicheros.class);
    public static void main(String[] args) {
        File directorio = new File("C:\\Users\\Tardes\\Ficheros");
        System.out.println(directorio.isDirectory());
        System.out.println(directorio.isFile());
        
        File fichero1 = new File("C:\\Users\\Tardes\\Ficheros\\fichero1.txt");
        System.out.println(fichero1.isDirectory());
        System.out.println(fichero1.isFile());

        File directorioNuevo = new File(directorio, "\\subdir");
        directorioNuevo.mkdir();

        for (int i = 0; i < 10; i++) {
            File directorioNuevo2 = new File(directorio, "\\subdir2" + i);
            directorioNuevo2.mkdir();
            //directorioNuevo2.delete();
        }

        String[] lista = directorio.list();
        for (String nombre : lista) {
            System.out.println(nombre);
            File file1 = new File(directorio, nombre);
            file1.delete();
        }

        File[] ficheros = directorio.listFiles();
        for (File file : ficheros) {
            System.out.println(file.delete());
        }

        System.out.println("============================================================");
        File fichero2 = new File("C:\\Users\\Tardes\\Ficherossss\\fichero2.txt");
        System.out.println(fichero2.exists());

        // Esta excepcion nos permite controlar si hemos puesto bien la ruta donde queremos crear el fichero,
        // de lo contrario, no estaríamos escribiendo bien la ruta.
        try {
            fichero2.createNewFile();
        } catch (IOException e) {
            logger.error("Error al crear el fichero " + fichero2.getAbsolutePath() + ": " + e.getMessage(),e);
            //System.err.println("Error al crear el fichero " + fichero2.getAbsolutePath() + ": " + e.getMessage());
        }

    }
}
