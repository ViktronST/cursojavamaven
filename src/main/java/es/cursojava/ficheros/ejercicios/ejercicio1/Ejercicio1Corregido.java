package es.cursojava.ficheros.ejercicios.ejercicio1;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.utiles.Utilidades2;
import es.cursojava.utiles.UtilidadesFicheros;

public class Ejercicio1Corregido {
    private static final Logger logger = LoggerFactory.getLogger(Ejercicio1Corregido.class);
    private static final String DIR_DOCUMENTOS = "documentos";
    private static final String DIR_IMAGENES = "imagenes";
    private static final String DIR_OTROS = "otros";
    public static void main(String[] args) {
        File directorioFicheros = new File("C:\\Users\\Tardes\\Ficheros");

        if (directorioFicheros.exists()) {
            String dirOrigen = "C:\\Users\\Tardes\\Ficheros";
            logger.info("El directorio " + dirOrigen + " existe. Creando nuevos directorios si no existieran.");

            String[] directorios = {DIR_DOCUMENTOS, DIR_IMAGENES, DIR_OTROS};
            UtilidadesFicheros.crearDirectorios(directorioFicheros, directorios); // Ir a UtilidadesFicheros
        }

        for (int i = 0; i < 5; i++) {
            String nombreFichero = Utilidades2.pideDatoCadena("Introduce 5 nombres de archivos:" + (i+1));
            String extensionFichero = nombreFichero.substring(nombreFichero.lastIndexOf("."));
            logger.info("La extension del fichero " + nombreFichero + " es " + extensionFichero);
            String directorioDestino = "";
           
            if (extensionFichero.equals(".txt")) {
                directorioDestino = directorioFicheros + DIR_DOCUMENTOS;
            } else if (extensionFichero.equals(".jpg") || extensionFichero.equals(".png")) {
                directorioDestino = directorioFicheros + DIR_IMAGENES;
            } else {
                directorioDestino = directorioFicheros + DIR_OTROS;
            }

            File nuevoFichero = new File(directorioDestino, nombreFichero);
            try {
                nuevoFichero.createNewFile();
                logger.info("Fichero " + nuevoFichero + " creado creado correctamente.");
            } catch (IOException error) {
                logger.error("Fichero " + nuevoFichero + " no creado por " + error.getMessage());
            }
        }

        File dirOtros = new File(directorioFicheros + DIR_OTROS);
        File[] ficherosOtros = dirOtros.listFiles();
        int contador = 0;

        for (File fichero : ficherosOtros) {
            if (fichero.isFile()) {
                String extensionFichero = "";
                if (fichero.getName().contains(".")) {
                    extensionFichero = fichero.getName().substring(fichero.getName().lastIndexOf("."));
                } else {
                    extensionFichero = ".xml";
                    logger.warn("El fichero no tiene extensión. Creando extensión por defecto.");
                }
  
                String nuevoNombre = "Viktor_" + contador + extensionFichero;
                File fileRenamed = new File(dirOtros, nuevoNombre);
                fichero.renameTo(fileRenamed);
                contador++;
            }
        }
    }
}
