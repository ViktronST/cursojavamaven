package es.cursojava.inicio.colecciones.mapas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PruebasMapas {
    public static void main(String[] args) {
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Clave1", 2);
        System.out.println(mapa.put("Clave2", 3));
        System.out.println(mapa.put("Clave2", 4));
        System.out.println(mapa.put("Clave2", 5));

        //Recuperación por clave
        System.out.println("================= Valores por Clave ======================");
        System.out.println(mapa.get("Clave1"));
        System.out.println(mapa.get("Clave2"));
        System.out.println("==========================================================");

        System.out.println("======================= Claves ===========================");
        Set<String> claves = mapa.keySet();
        for (String clave : claves) {
            System.out.println(clave);
        }
        System.out.println("==========================================================");

        System.out.println("======================= Valores ==========================");
        Collection<Integer> valores = mapa.values();
        for (Integer valor : valores) {
            System.out.println(valor);
        }
        System.out.println("==========================================================");

        System.out.println("=============== Todas Claves con Valor ===================");
        for (String clave : claves) {
            System.out.println(clave + " " + mapa.get(clave));
        }
        System.out.println("==========================================================");

        System.out.println("========= Todas Claves con Valor usando Entry ============");
        Set<Entry<String, Integer>> entries = mapa.entrySet();
        for (Entry<String, Integer> entry : entries) {
            System.out.println(entry);
            //System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("==========================================================");
    }
}

