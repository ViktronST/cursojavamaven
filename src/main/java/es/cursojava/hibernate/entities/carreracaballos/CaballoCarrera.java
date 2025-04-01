package es.cursojava.hibernate.entities.carreracaballos;

import es.cursojava.hibernate.entities.carreracaballos.excepciones.AgeException;
import es.cursojava.hibernate.entities.carreracaballos.excepciones.SpeedException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CABALLOS")

public class CaballoCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true, length = 50, nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "velocidad_maxima", nullable = false)
    private double velocidadMaxima;

    @Column(name = "numero_triunfos")
    private int numeroTriunfos;

    @Column(name = "experiencia")
    private double experiencia;

    @Column(name = "esta_activo")
    private boolean estaActivo;

    // Constructores
    public CaballoCarrera() {
    }

    public CaballoCarrera(String nombre, int edad, double velocidadMaxima, int numeroTriunfos, double experiencia, boolean estaActivo) 
                        throws AgeException{
        this.nombre = nombre;
        rangoEdad(edad);
        controlarVelocidadMax(velocidadMaxima);
        numTriunfos(numeroTriunfos);
        controlarExperiencia(experiencia);
        this.estaActivo = estaActivo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getNumeroTriunfos() {
        return numeroTriunfos;
    }

    public void setNumeroTriunfos(int numeroTriunfos) {
        this.numeroTriunfos = numeroTriunfos;
    }

    public double getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(double experiencia) {
        this.experiencia = experiencia;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    @Override
    public String toString() {
        return "CaballoCarrera [Id: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Velocidad Maxima: "
                + velocidadMaxima + ", Numero Triunfos: " + numeroTriunfos + ", Experiencia: " + experiencia
                + ", Activo: " + estaActivo + "]";
    }
    
    // Métodos
    private void rangoEdad(int edad) throws AgeException{
        if (edad>2 && edad<30) {
            this.edad = edad;        
        } else {
            System.out.println("La edad de" + nombre + " no es apta para competir");
        }
    }

    private void controlarVelocidadMax(double velocidadMaxima) throws SpeedException {
        if (velocidadMaxima>30 && velocidadMaxima<80) {
            this.velocidadMaxima = velocidadMaxima;
        } else {
            System.out.println("La velocidad máxima de " + nombre + " no es apta para competir");
        }
    }

    private void numTriunfos(int numeroTriunfos) {
        if (numeroTriunfos>0) {
            this.numeroTriunfos = numeroTriunfos;
        } else {
            System.out.println("El número de Triunfos no puede ser negativo");
        }
    }

    private void controlarExperiencia(double experiencia) {
        if (experiencia>0 && experiencia<10) {
            this.experiencia = experiencia;
        } else {
            System.out.println("La experiencia de " + nombre + " no es apta para competir");
        }
    }

}
