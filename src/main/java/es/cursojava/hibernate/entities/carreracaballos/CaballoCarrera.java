package es.cursojava.hibernate.entities.carreracaballos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_CABALLOS")

public class CaballoCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true, length = 50, nullable = false)
    // @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")   // Manera de sustituir el length
    private String nombre;

    // @Column(name = "edad", nullable = false, columnDefinition = "int check (edad >= 2 and edad <= 30)")
    @Column(name = "edad", nullable = false)
    @Min(value = 2)
    @Max(value = 30)
    private int edad;

    @Column(name = "velocidad_maxima", nullable = false)
    @DecimalMin(value = "30.0")
    @DecimalMax(value = "80.0")
    private double velocidadMaxima;

    @Column(name = "numero_triunfos")
    @Min(0)
    private int numeroTriunfos;

    @Column(name = "experiencia")
    @DecimalMin("0.0") 
    @DecimalMax("10.0")
    private double experiencia;

    @Column(name = "esta_activo")
    private boolean estaActivo;

    // Constructores
    public CaballoCarrera() {
    }

    public CaballoCarrera(String nombre, int edad, double velocidadMaxima, int numeroTriunfos, double experiencia, boolean estaActivo){
        this.nombre = nombre;
        this.edad = edad;
        this.velocidadMaxima = velocidadMaxima;
        this.numeroTriunfos = numeroTriunfos;
        this.experiencia = experiencia;
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

}
