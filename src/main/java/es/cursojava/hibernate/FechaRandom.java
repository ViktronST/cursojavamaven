package es.cursojava.hibernate;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class FechaRandom {
    public static void main(String[] args) {
        // Rango de fechas
        long inicio = new Date(100, 0, 1).getTime(); // 1 enero 2000
        long fin = new Date().getTime();

        // Fecha aleatoria
        long random = ThreadLocalRandom.current().nextLong(inicio, fin);
        Date fechaAleatoria = new Date(random);

        System.out.println("Fecha aleatoria: " + fechaAleatoria);
    }
}
