package es.cursojava.ficheros.ejercicios.ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import es.cursojava.ficheros.ArchivoServicio;

public class Ejercicio4 {
    public static void main(String[] args) {
        // ArchivoServicio servicio = new ArchivoServicio();

        String rutaArchivo = "D:\\ficheros\\Quijote.txt";
        // String nombre = "Qhijote";
        String[] palabrasClave = {"Quijote", "Dulcinea", "Sancho"};
        
        int totalLineas = 0;
        // int contadorNombre = 0;
        int[] contadorPalabras = new int[palabrasClave.length];
        
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                totalLineas++;
                for (int i = 0; i < palabrasClave.length; i++) {
                    contadorPalabras[i] += contarAparicionesNombres(linea, palabrasClave[i]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Total de líneas: " + totalLineas);
        for (int i = 0; i < palabrasClave.length; i++) {
            System.out.println("Apariciones de " + palabrasClave[i] + ": " + contadorPalabras[i]);
        }
    }
    
    // private static int contarApariciones(String linea) {
    //     int contador = 0;
    //     int indice = linea.indexOf("Quijote");
    //     while (indice != -1) {
    //         contador++;
    //         indice = linea.indexOf("Quijote", indice + 7);
    //     }
    //     return contador;
    // }

    private static int contarAparicionesNombres(String linea, String palabra) {
        int contador = 0;
        int indice = linea.indexOf(palabra);
        while (indice != -1) {
            contador++;
            indice = linea.indexOf(palabra, indice + palabra.length());
        }
        return contador;
    }

    
}
