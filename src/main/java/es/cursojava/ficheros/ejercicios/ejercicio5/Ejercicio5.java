package es.cursojava.ficheros.ejercicios.ejercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        cargarEventosFichero("D:\\ficheros\\eventos.txt");
    }

    private static void cargarEventosFichero(String eventsFile) {
        
        try (Scanner scan = new Scanner(new File(eventsFile))) {
            scan.useDelimiter("\n");
            scan.nextLine();
            while (scan.hasNext()) {
                String linea = scan.nextLine();
                String[] datos = linea.split(",");

                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = format.parse(datos[2]);
                String lugar = datos[3];
                String descripcion = datos[4];
                int duracion = Integer.parseInt(datos[5]);
                double precio = Integer.parseInt(datos[6]);
                String organizador = datos[7];
                // boolean gratuito = Boolean.parseBoolean(datos[8]);
                boolean gratuito = datos[8].equals("true")?true:false;

                Evento evento = new Evento(id, linea, null, linea, eventsFile, 0, 0, linea, false);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
