package es.cursojava.inicio.colecciones.ejercicios.ejercicio1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import es.cursojava.inicio.funciones.Utilidades;
import es.cursojava.poo.centroeducativo.Alumno;

public class MainAlumnos2 {
    public static void main(String[] args) {
        MainAlumnos2 probar = new MainAlumnos2();
        probar.mostrarInfoAlumnos(obtenerAlumnos());
        probar.mostrarNotasPorNombre(obtenerAlumnos());

        // Obtener los alumnos.
        List<Alumno> alumnos = obtenerAlumnos();

        // Distribuir alumnos en aulas.
        Map<String, List<Alumno>> aulas = probar.distribuirAlumnosEnAulas(alumnos);

        // Mostrar información de cada aula y sus alumnos.
        probar.mostrarAulas(aulas);

        // Encontrar al mejor alumno entre todas las aulas.
        probar.encontrarMejorAlumno(aulas);

        // Eliminar alumnos suspensos.
        probar.eliminarAlumnosSuspensos(alumnos);

    }

    //======================================== CREACIÓN DE ALUMNOS ========================================   
    // Sobrecargamos el método de generar alumnos, para crear sólo los que necesitemos.
    static List<Alumno> obtenerAlumnos1(int numAlumnos) {
        List<Alumno> alumnos = new ArrayList<>();

        for (int i = 0; i < numAlumnos; i++) {
            Alumno alumno = new Alumno("Gonzalo" + i, "Núñez" + i, 22, Math.random()*10, "Gonzañez@gmail.com");
            alumnos.add(alumno);
        }

        return alumnos;
    } 

    static List<Alumno> obtenerAlumnos() {
        // Alumno alumno1 = new Alumno("N1", "A1", 18, 4.9, "asdas1@gmail.com");
        // Alumno alumno2 = new Alumno("N2", "A2", 19, 5, "asdas2@gmail.com");
        // Alumno alumno3 = new Alumno("N1", "A3", 20, 4, "asdas3@gmail.com");
        // Alumno alumno4 = new Alumno("N2", "A4", 21, 10, "asdas4@gmail.com");
        // Alumno alumno5 = new Alumno("N3", "A5", 22, 7, "asdas5@gmail.com");
        // Alumno alumno6 = new Alumno("N1", "A6", 23, 3.5, "asdas6@gmail.com");

        // List<Alumno> alumnos = new ArrayList<>();
        // alumnos.add(alumno1);
        // alumnos.add(alumno2);
        // alumnos.add(alumno3);
        // alumnos.add(alumno4);
        // alumnos.add(alumno5);
        // alumnos.add(alumno6);
       
        // // Otras manera de crear las listas.
        // // alumnos.add(new Alumno("N1", "A1", 18, 4.9, "asdas1@gmail.com"));
        // // alumnos.add(new Alumno("N2", "A2", 19, 5, "asdas2@gmail.com"));
        // // alumnos.add(new Alumno("N3", "A3", 20, 4, "asdas3@gmail.com"));
        // // alumnos.add(new Alumno("N4", "A4", 21, 10, "asdas4@gmail.com"));
        // // alumnos.add(new Alumno("N5", "A5", 22, 7, "asdas5@gmail.com"));
        // // alumnos.add(new Alumno("N6", "A6", 23, 3.5, "asdas6@gmail.com"));
        
        // // Otra manera de crear las listas.
        // // List<Alumno> listaAlumnos = Arrays.asList(alumno1, alumno2, alumno3, alumno4, alumno5, alumno6);

        // // Aquí se añaden los alumnos a la lista.
        // // alumnos.addAll(Arrays.asList(alumno1, alumno2, alumno3, alumno4, alumno5, alumno6));
        
        // // Aquí se crea la lista y se añaden los alumnos. APUNTAMOS A UNA NUEVA LISTA CREADA!!!
        // // alumnos = (Arrays.asList(alumno1, alumno2, alumno3, alumno4, alumno5, alumno6));

        return obtenerAlumnos1 (6);

        // List<Alumno> alumnos = obtenerAlumnos(6);
        // return alumnos;
    }

    //======================================== MOSTRAR INFO ALUMNOS ========================================
    private void mostrarInfoAlumnos(List<Alumno> alumnos) {
        System.out.println("================  Listado de Alunmos ================");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    //======================================== MOSTRAR NOTAS POR NOMBRE ========================================
    private void mostrarNotasPorNombre(List<Alumno> alumnos) {
        System.out.println("\n================  Buscando de Alunmos ================");
        String nombre = Utilidades.pideDatoCadena("Introduce nombre del alumno: ");
        boolean encontrado = false;

        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\nNombre: " + alumno.getNombre() + " - Nota Media: " + alumno.getNotaMedia());
                encontrado = true;
            }
            //System.out.println(alumno.getNombre().equalsIgnoreCase(nombre)? "Nombre: " + alumno.getNombre() + " - Nota Media: " + alumno.getNotaMedia() : "");
        }

        if (!encontrado) {
            System.out.println("\nNo hay alumnos con el nombre '" + nombre + "'.");
        }
        //System.out.println(!encontrado? "\nNo hay alumnos con el nombre '" + nombre + "'." : "");
    }

    //======================================== DISTRIBUIR ALUMNOS EN AULAS ========================================
    public Map<String, List<Alumno>> distribuirAlumnosEnAulas(List<Alumno> alumnos) {
        Map<String, List<Alumno>> aulas = new LinkedHashMap<>();
        aulas.put("Aula 1", alumnos.subList(0, 2)); // DESDE 0 HASTA 2 (NO INCLUYE 2).
        aulas.put("Aula 2", alumnos.subList(2, 4)); // DESDE 2 HASTA 4 (NO INCLUYE 4).
        aulas.put("Aula 3", alumnos.subList(4, 6)); // DESDE 4 HASTA 6 (NO INCLUYE 6).

        return aulas;
    }

    // Otra manera de hacer la distribución de alumnos en aulas.
    private Map<String, List<Alumno>> distribuirAlumnosEnAulas1(List<Alumno> alumnos) {
        Map<String, List<Alumno>> aulas = new LinkedHashMap<>();
        aulas.put("Aula 1", new ArrayList<>());
        aulas.put("Aula 2", new ArrayList<>());
        aulas.put("Aula 3", new ArrayList<>());

        // DISTRIBUIR EN ORDEN SECUENCIAL
        for (int i = 0; i < alumnos.size(); i++) {
            if (i < 2) {
                aulas.get("Aula 1").add(alumnos.get(i));
            } else if (i < 4) {
                aulas.get("Aula 2").add(alumnos.get(i)); 
            } else {
                aulas.get("Aula 3").add(alumnos.get(i)); 
            }
        }

        return aulas;
    }

    //======================================== MOSTRAR LAS AULAS ========================================
    // Manera, en este caso errónea, de mostrar aulas.
    private void mostrarAulas0(Map<String, List<Alumno>> aulas) {
        for (String aula : aulas.keySet()) {
            System.out.println("\n" + aula + ":");
            List<Alumno> alumnos = aulas.get(aula);
            for (Alumno alumno : alumnos) {
                System.out.println("" + alumno);
            }
        }
    }
    
    // Manera correcta de mostrar aulas.
    private void mostrarAulas(Map<String, List<Alumno>> aulas) {
        System.out.println("\n================ Distribución por Aulas ================");
        for (String aula : aulas.keySet()) {
            System.out.println("\n" + aula + ":");
            for (Alumno alumno : aulas.get(aula)) {
                System.out.println("\t" + alumno);
            }
        }
    }

    // Otra manera de mostrar las aulas.
    private void mostrarAulas1(Map<String, List<Alumno>> aulas) {
        System.out.println("\n================ Distribución por Aulas ================");
        Set<String> aulas1 = aulas.keySet();
        for (String aula : aulas1) {
            System.out.println("Aula: " + aula);
            List<Alumno> alumnos = aulas.get(aula);
            for ( Alumno alumno : alumnos) {
                System.out.println("\t" + alumno.getNombre() + " " + alumno.getApellido());
            }
        }
    }

    // Otra manera de mostrar las aulas.
    private void mostrarAulas2(Map<String, List<Alumno>> aulas) {
        System.out.println("\n================ Distribución por Aulas ================");
        Collection <List<Alumno>> alumnos = aulas.values();
        for (List<Alumno> alumnosAula : alumnos) {
            for (Alumno alumno : alumnosAula) {
                System.out.println("\t" + alumno.getNombre() + " " + alumno.getApellido());
            }
        }
    }

    //======================================== ENCONTRAR MEJOR ALUMNO ========================================
    private void encontrarMejorAlumno(Map<String, List<Alumno>> aulas) {
        Alumno mejorAlumno = null;
        String aulaMejorAlumno = "";

        for (String aula : aulas.keySet()) {
            for (Alumno alumno : aulas.get(aula)) {
                if (mejorAlumno == null || alumno.getNotaMedia() > mejorAlumno.getNotaMedia()) {
                    mejorAlumno = alumno;
                    aulaMejorAlumno = aula;
                }
            }
        }

        if (mejorAlumno != null) {
            System.out.println("\nEl mejor alumno es: " + mejorAlumno.getNombre() + " " + mejorAlumno.getApellido() +
                    " con una nota de " + mejorAlumno.getNotaMedia() + " en " + aulaMejorAlumno);
        } else {
            System.out.println("\nNo hay alumnos en las aulas.");
        }
    }

    // Método para encontrar el aula con la mejor notaMedia.
    private void encontrarAulaConMejorNota(Map<String, List<Alumno>> aulas) {
        String mejorAula = "";
        double mejorNota = 0;

        for (String aula : aulas.keySet()) {
            List<Alumno> alumnos = aulas.get(aula);
            for (Alumno alumno : alumnos) {
                if (alumno.getNotaMedia() > mejorNota) {
                    mejorNota = alumno.getNotaMedia();
                    mejorAula = aula;
                }
            }
        }

        System.out.println("\nEl aula con la mejor nota media es: " + mejorAula + " con una nota de " + mejorNota);
    }

    //======================================== ELIMINAR ALUMNOS SUSPENSOS ========================================
    private void eliminarAlumnosSuspensos(List<Alumno> alumnos) {
        // DE ESTA MANERA FALLA PORQUE SE ESTÁ RECORRIENDO LA LISTA MIENTRAS SE ELIMINAN LOS OBJETOS.
        // for (Alumno alumno : alumnos) {
        //     if (alumno.getNotaMedia() < 5) {
        //         alumnos.remove(alumno);
        //     }
        // }

        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getNotaMedia() < 5) {
                alumnos.remove(i);
                i--;
            }
        }

        // OTRA FORMA DE HACERLO.
        // for (int i = 0; i < alumnos.size(); i++) {
        //     Alumno alumno = alumnos.get(i);
        //     if (alumnos.getNotaMedia() < 5) {
        //         alumnos.remove(i--);
        //     }
        // }

        System.out.println("\n================ Alumnos Aprobados ================");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    //======================================== MÉTODO CON MAP.ENTRY ========================================
    // Método de mostrar aulas.
    private void mostrarAulas3(Map<String, List<Alumno>> aulas) {
        for (Map.Entry<String, List<Alumno>> entry : aulas.entrySet()) {
            System.out.println("\n" + entry.getKey() + ":");
            for (Alumno alumno : entry.getValue()) {
                System.out.println("\t" + alumno);
            }
        }
    }

    // Otra manera de mostrar las aulas.
    private void mostrarAulas4(Map<String, List<Alumno>> aulas) {
        Set<Entry<String, List<Alumno>>> entrySet = aulas.entrySet();
        for (Entry<String,List<Alumno>> entry : entrySet) {
            String clave = entry.getKey();
            System.out.println("\n" + clave + ":");
            List<Alumno> alumnos = entry.getValue();
            for (Alumno alumno : alumnos) {
                System.out.println("\t"+alumno.getNombre() + " " +alumno.getApellido());
            }
        }
    }

    // Método de encontrar aula con mejor nota.
    private void encontrarAulaConMejorNota1(Map<String, List<Alumno>> aulas) {
        String mejorAula = "";
        double mejorNota = 0;

        for (Map.Entry<String, List<Alumno>> entry : aulas.entrySet()) {
            for (Alumno alumno : entry.getValue()) {
                if (alumno.getNotaMedia() > mejorNota) {
                    mejorNota = alumno.getNotaMedia();
                    mejorAula = entry.getKey();
                }
            }
        }
    }

    //======================================== MÉTODO CON LIST<LIST<ALUMNO>> ========================================
    // Separar alumnos en aulas
    private List<List<Alumno>> separarEnAulas(List<Alumno> alumnos) {
        List<List<Alumno>> aulas = new ArrayList<>();
        aulas.add(new ArrayList<>()); // Aula 1
        aulas.add(new ArrayList<>()); // Aula 2
        aulas.add(new ArrayList<>()); // Aula 3

        // DISTRIBUIR CÍCLICAMENTE
        // for (int i = 0; i < alumnos.size(); i++) {
        //     aulas.get(i % 3).add(alumnos.get(i)); 
        // }

        // DISTRIBUIR EN ORDEN SECUENCIAL
        for (int i = 0; i < alumnos.size(); i++) {
            if (i < 2) {
                aulas.get(0).add(alumnos.get(i)); // Primeros 2 a Aula 1
            } else if (i < 4) {
                aulas.get(1).add(alumnos.get(i)); // Siguientes 2 a Aula 2
            } else {
                aulas.get(2).add(alumnos.get(i)); // Últimos 2 a Aula 3
            }
        }

        return aulas;
    }

    // Método de mostrar aulas.
    private void mostrarAulas5(List<List<Alumno>> aulas) {
        System.out.println("\n======== Listado de alumnos por aula ======== ");
        for (int i = 0; i < aulas.size(); i++) {
            System.out.println("\nAula " + (i + 1) + ":");
            for (Alumno alumno : aulas.get(i)) {
                System.out.println("Nombre: " + alumno.getNombre() + " - Nota Media: " + alumno.getNotaMedia());
            }
        }
    }

    //Método para buscar el aula del alumno con la mejor notaMedia.
    private void aulaConMejorAlumno(List<List<Alumno>> aulas) {
        double mejorNota = -1;
        int aulaMejor = -1;
        Alumno mejorAlumno = null;

        for (int i = 0; i < aulas.size(); i++) {
            for (Alumno alumno : aulas.get(i)) {
                if (alumno.getNotaMedia() > mejorNota) {
                    mejorNota = alumno.getNotaMedia();
                    aulaMejor = i + 1;
                    mejorAlumno = alumno;
                }
            }
        }

        if (mejorAlumno != null) {
            System.out.println("\nEl aula con el alumno de mayor nota media es el Aula " + aulaMejor +
                    " (Alumno: " + mejorAlumno.getNombre() + " - Nota Media: " + mejorNota + ")");
        }
    }

    //======================================== CREACIÓN DE COLEGIOS ========================================
    static List<Colegio> obtenerColegios() {
        Colegio colegio1 = new Colegio("Montesori", "Calle Pepito Grillo");
        Colegio colegio2 = new Colegio("Miguel Delibes", "Calle Santo Domingo");
        Colegio colegio3 = new Colegio("María Guerrero", "Calle Real 23");

        List<Colegio> colegios = new ArrayList<>();
        colegios.add(colegio1);
        colegios.add(colegio2);
        colegios.add(colegio3);

        // Otras manera de crear las listas.
        // alumnos.add(new Colegio("Montesori", "Calle Pepito Grillo"));
        // alumnos.add(new Colegio("Miguel Delibes", "Calle Santo Domingo"));
        // alumnos.add(new Colegio("María Guerrero", "Calle Real 23"));
        
        // Otra manera de crear las listas.
        // List<Colegio> listaColegios = Arrays.asList(colegio1, colegio2, colegio3);

        // Aquí se añaden los alumnos a la lista.
        // colegios.addAll(Arrays.asList(colegio1, colegio2, colegio3));
        
        // Aquí se crea la lista y se añaden los alumnos. APUNTAMOS A UNA NUEVA LISTA CREADA!!!
        // colegios = (Arrays.asList(colegio1, colegio2, colegio3));

        return colegios;
    }

}
