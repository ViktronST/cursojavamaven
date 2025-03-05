package es.cursojava.ficheros.ejercicios;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.utiles.Utilidades2;

public class Ejercicio1 {
    private static final Logger logger = LoggerFactory.getLogger(Ejercicio1.class);
    public static void main(String[] args) {
        File directorioFicheros = new File("C:\\Users\\Tardes\\Ficheros");

        if (directorioFicheros.exists()) {
            String dirOrigen = "C:\\Users\\Tardes\\Ficheros";
            logger.info("El directorio " + dirOrigen + " existe. Creando nuevos directorios si no existieran.");

            File directorioImagenes = new File(directorioFicheros, "\\Imágenes");
            if (directorioImagenes.mkdir()) {
                logger.info("El directorio " + directorioImagenes + " se ha creado.");
            } else {
                logger.warn("El directorio " + directorioImagenes + " no se ha creado.");
            }

            File directorioDocumentos = new File(directorioFicheros, "\\Documentos");
            if (directorioDocumentos.mkdir()) {
                logger.info("El directorio " + directorioDocumentos + " se ha creado.");
            } else {
                logger.warn("El directorio " + directorioDocumentos + " no se ha creado.");
            }

            File directorioOtros = new File(directorioFicheros, "\\Otros");
            if (directorioOtros.mkdir()) {
                logger.info("El directorio " + directorioOtros + " se ha creado.");
            } else {
                logger.warn("El directorio " + directorioOtros + " no se ha creado.");
            }

            for (int i = 0; i < 5; i++) {
                String fileName = Utilidades2.pideDatoCadena("Introduce 5 nombres de archivos:");
                File nuevoFichero;
    
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif")) {
                    nuevoFichero = new File(directorioImagenes, fileName);
                    logger.info("Imagen " + fileName + " creado en " + directorioImagenes.getAbsolutePath());
                
                } else if (fileName.endsWith(".txt") || fileName.endsWith(".pdf")) {
                    nuevoFichero = new File(directorioDocumentos, fileName);
                    logger.info("Documento " + fileName + " creado en " + directorioDocumentos.getAbsolutePath());
    
                } else {
                    nuevoFichero = new File(directorioOtros, fileName);
                    logger.info("Fichero " + fileName + " creado en " + directorioOtros.getAbsolutePath());
                }
    
                try {
                    nuevoFichero.createNewFile();
                } catch (IOException e) {
                    logger.error("Error al crear el archivo " + nuevoFichero.getAbsolutePath() + ": " + e.getMessage());
                }

                System.out.println("============================================================================");
                File[] archivosOtros = directorioOtros.listFiles();
                int contador = 1;

                for (File file : archivosOtros) {
                    String extension = "";
                    int referencia = file.getName().lastIndexOf('.');
                    
                    if (referencia > 0) {
                        extension = file.getName().substring(referencia);
                    }

                    File nuevoNombre = new File(directorioOtros, "Viktor_" + contador + extension);

                    if (file.renameTo(nuevoNombre)) {
                        logger.info("Archivo renombrado: " + nuevoNombre.getName());
                    } else {
                        logger.error("No se pudo renombrar: " + file.getName());
                    }

                    contador++;
                }
            }
        }

    }
}
