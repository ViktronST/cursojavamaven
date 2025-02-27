package es.cursojava.inicio.colecciones.ejercicios.ejercicio1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.cursojava.poo.centroeducativo.Alumno;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// Lista de Colegios, con Mapa de Aulas y Lista de Alumnos...
// colegios.get(0).getAulas().get("aula1")get(0).getNombre()  ->  1er Alumno
public class Colegio {
    private String nombre;
    private String direccion;
    private Map<String, List<Alumno>> aulas;

    public Colegio(String nombre, String direccion, Map<String, List<Alumno>> aulas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.aulas = aulas;
    }

    public Colegio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.aulas = new HashMap<>();
    }

    public void agregarAula(String aula, List<Alumno> alumnos) {
        aulas.put(aula, alumnos);
    }

    public void mostrarDatos() {
        System.out.println("\n================ Distribución por Colegio ================");
        System.out.println("Colegio: " + nombre + " - Dirección: " + direccion);
        Set<String> aulas1 = aulas.keySet();
        for (String aula : aulas1) {
            System.out.println("Aula: " + aula);
            List<Alumno> alumnos = aulas.get(aula);
            for ( Alumno alumno : alumnos) {
                System.out.println("\t" + alumno.getNombre() + " " + alumno.getApellido());
            }
        }
    }

    public void guardarAlumno (String aula, Alumno alumno) {
        this.aulas.get(aula).add(alumno);
    }

    public void guardarAlumno1 (String aula, List<Alumno> alumnos) {
        this.aulas.get(aula).addAll(alumnos);
        // List<Alumno> alumnosAntiguos = this.aulas.put(aula, alumnos);   // .put y .replace hacen lo mismo
    }

    public List<Alumno> getMapa() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMapa'");
    }
}
