package es.cursojava.ficheros.ejercicios.ejercicio4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ejercicio4Corregido {
    public static void main(String[] args) {
        Ejercicio4Corregido prueba = new Ejercicio4Corregido();
        prueba.leerArchivo3("D:\\ficheros\\Quijote.txt");
    }

    public void leerArchivo3(String nombre) {
        Path path = Paths.get(nombre);
        int contador = 0;
        int contadorQuijote = 0;
        try {
            List<String> lines = Files.readAllLines(path);
            for (String linea : lines) {
                contador++;
                String[] palabras = linea.split(" ");
                for (String palabra : palabras) {
                    if(palabra.contains("Quijote")){
                        contadorQuijote++;
                    }
                }
            }
        } catch (IOException e) {

        }
        System.out.println("Num lineas " + contador);
        System.out.println("Num de Quijotes " + contadorQuijote);
    }
    
}
