package es.cursojava.hibernate.ratondebiblioteca.entities;

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

    
}
