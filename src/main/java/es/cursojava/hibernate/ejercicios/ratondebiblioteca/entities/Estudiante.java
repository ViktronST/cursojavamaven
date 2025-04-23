package es.cursojava.hibernate.ejercicios.ratondebiblioteca.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ESTUDIANTES")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50, unique = true)
    private String nombre;

    @Column(name = "apellidos", length = 50)
    private String apellidos;

    @Column(name = "edad", nullable = false, length = 50)
    private String edad;

    @Column(name = "dni", nullable = false, length = 50, unique = true)
    private String dni;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "carnet_biblioteca_id")
    private CarnetBiblioteca carnetBiblioteca;

    public Estudiante() {
    }

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Estudiante(String nombre, CarnetBiblioteca carnetBiblioteca) {
        this.nombre = nombre;
        this.carnetBiblioteca = carnetBiblioteca;
    }

    public Estudiante(String nombre, String apellidos, String edad, String dni, String email, CarnetBiblioteca carnetBiblioteca) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.email = email;
        this.carnetBiblioteca = carnetBiblioteca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CarnetBiblioteca getCarnetBiblioteca() {
        return carnetBiblioteca;
    }

    public void setCarnetBiblioteca(CarnetBiblioteca carnetBiblioteca) {
        this.carnetBiblioteca = carnetBiblioteca;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
