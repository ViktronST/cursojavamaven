package es.cursojava.ficheros.ejercicios.ejercicio3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import es.cursojava.poo.centroeducativo.Alumno;
import es.cursojava.utiles.UtilidadesFicheros;

public class Ejercicio3Corregido {
    public static void main(String[] args) {
        String[] asignaturas = {"A1", "A2", "A3"};
        Alumno a1 = new Alumno("N1", "A1", 21, 1, "ASD1", asignaturas);
        Alumno a2 = new Alumno("N2", "A2", 22, 2, "ASD2", asignaturas);
        Alumno a3 = new Alumno("N3", "A3", 23, 3, "ASD3", asignaturas);

        List<Alumno> alumnos = Arrays.asList(a1,a2,a3);
        Ejercicio3Corregido e3 = new Ejercicio3Corregido();
        e3.almacenarAlumnosFichero(alumnos);
    }

    public void almacenarAlumnosFichero (List<Alumno> alumnos) {
        Path ruta = Paths.get("./recursos/datos_alumnos.txt");
        try {
            for (Alumno alumno : alumnos) {
                // Generamos un objeto en el cual guardaremos toda la información que queramos.
                StringBuilder sb = new StringBuilder();
                sb.append("Nombre: ");
                sb.append(alumno.getNombre());
                sb.append(UtilidadesFicheros.SEPARADOR_PIPE);
                sb.append("Apellido: ");
                sb.append(alumno.getApellido());
                sb.append(UtilidadesFicheros.SEPARADOR_PIPE);
                sb.append("Edad: ");
                sb.append(alumno.getEdad());
                sb.append(UtilidadesFicheros.SEPARADOR_PIPE);
                sb.append("Nota Media: ");
                sb.append(alumno.getNotaMedia());
                sb.append(UtilidadesFicheros.SEPARADOR_PIPE);
                sb.append("Email: ");
                sb.append(alumno.getEmail());
                sb.append(UtilidadesFicheros.SEPARADOR_PIPE);
                sb.append("Asignaturas: ");
                sb.append(Arrays.toString(alumno.getAsignaturas()));

                String contenido = sb.toString();
                contenido = contenido.replace("[", "").replace("]", "");

                // De esta forma se están creando nuevos Strings con cada concatenación ("+"),
                // si llegan a ser muchas líneas se llena la memoria muy rápido.
                // String contenido = "Nombre: " + alumno.getNombre() + " | Apellido: " + alumno.getApellido() + " | Edad: " + alumno.getEdad() 
                // + " | Nota Media: " + alumno.getNotaMedia() + " | Email: " + alumno.getEmail() 
                // + " | Asignaturas: " + Arrays.toString(alumno.getAsignaturas()) + "\n";
                
                // String asignaturas = "";
                // for (String asignatura : alumno.getAsignaturas()) {
                //    asignaturas += asignatura + ","; 
                // }
                // contenido += asignaturas;

                Files.write(ruta, contenido.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            }
            
            System.out.println("Escritura completada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
