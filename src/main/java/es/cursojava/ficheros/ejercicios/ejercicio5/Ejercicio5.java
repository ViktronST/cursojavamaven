package es.cursojava.ficheros.ejercicios.ejercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio5 {
    public static void main(String[] args) {
        Map<String, List<Evento>> mapa = cargarEventosFichero("D:\\ficheros\\eventos.txt", 1);
        pintaMapa(mapa);
        try {
            eventosPorCiudad(mapa);
        } catch (IOException e) {
            e.printStackTrace();
        }
        eventosGratuitoPorCiudad(mapa);
    }

    private static void eventosGratuitoPorCiudad (Map<String, List<Evento>> mapa) {
        System.out.println("========== Eventos gratuitos por Ciudad ==========");
        Set<String> ciudades = mapa.keySet();
        for (String ciudad : ciudades) {
            List<Evento> eventosCiudad = mapa.get(ciudad);
            for (Evento evento : eventosCiudad) {
                if (evento.isGratuido()) {
                    System.out.println(ciudad + " " + evento.getNombre());
                }
            }
        }
        System.out.println("Terminar");
    }

    private static void eventosPorCiudad (Map<String, List<Evento>> mapa) throws IOException {
        Set<String> ciudades = mapa.keySet();
        for (String ciudad : ciudades) {
            Path ruta = Paths.get("./ciudades/" + ciudad + ".txt");

            List<Evento> eventosCiudad = mapa.get(ciudad);
            System.out.println("Ciudad: " + ciudad + " con " + eventosCiudad.size());
            StringBuilder sb = new StringBuilder();
            for (Evento evento : eventosCiudad) {
                sb.append(evento.getNombre() + "\n");
            }
            Files.write(ruta, sb.toString().getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }
    }

    private static void pintaMapa (Map<String, List<Evento>> mapa) {
        Set<String> ciudades = mapa.keySet();
        for (String ciudad : ciudades) {
            List<Evento> eventosCiudad = mapa.get(ciudad);
            System.out.println("Ciudad: " + ciudad + " con " + eventosCiudad.size());
            for (Evento evento : eventosCiudad) {
                System.out.println("\t" + evento.getNombre());
            }
        }
    }

    private static Map<String, List<Evento>> cargarEventosFichero(String eventsFile, int numLineas) {
        Map<String, List<Evento>> mapaEventos = new HashMap<>();

        try (Scanner scan = new Scanner(new File(eventsFile))) {
            scan.useDelimiter("\n");

            for (int i = 0; i < numLineas; i++) {
                scan.nextLine();
            }

            while (scan.hasNext()) {
                String linea = scan.nextLine();

                String[] datos = linea.split(",");
                // StringTokenizer st = new StringTokenizer(linea, ",");    // Es otra manera de trocear.

                int id = Integer.parseInt(datos[0]);    // Convertimos a entero el primer String que le pasamos.

                String nombre = datos[1];

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                Date fecha = null;
                try {
                    fecha = format.parse(datos[2]);
                } catch (ParseException e) {    // Obligados a capturar la excepcion por si los datos no vienen de manera correcta.
                    e.printStackTrace();
                }

                String ciudad = datos[3];

                String descripcion = datos[4];

                int duracion = Integer.parseInt(datos[5]);

                double precio = Double.parseDouble(datos[6]);

                String organizador = datos[7];

                boolean gratuito = Boolean.parseBoolean(datos[8]);
                //boolean gratuito = datos[8].contains("true")?true:false;    // Con el equals también funcionaría.

                Evento evento = new Evento(id, nombre, fecha, ciudad, descripcion, duracion, precio, organizador, gratuito);
                System.out.println(evento);

                if (mapaEventos.get(ciudad)==null) {
                    List<Evento> eventosCiudad = new ArrayList<>();
                    eventosCiudad.add(evento);
                    mapaEventos.put(ciudad, eventosCiudad);
                } else {
                    mapaEventos.get(ciudad).add(evento);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return mapaEventos;

    }
}
