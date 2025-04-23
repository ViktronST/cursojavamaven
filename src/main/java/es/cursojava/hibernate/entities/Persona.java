package es.cursojava.hibernate.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "TB_PERSONAS") //Es para darle un nombre específico a la tabla, sino se registrará el nombre de la propia clase.

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // AUTO:	Delega la estrategia al proveedor JPA (Hibernate decide según la BBDD).
    // IDENTITY:	Usa una columna auto-incremental. Funciona bien con MySQL, SQL Server, Oracle 12c+…
    // SEQUENCE:	 Usa una secuencia de base de datos (muy común en Oracle, PostgreSQL, etc.).
    // TABLE:   Usa una tabla especial para almacenar y generar identificadores.
    private Long id;

    // nullable: permite o restringe el null de esta columna.
    // lenght: determina la longitud del campo.
    // unique: determina si el campo es único o no.
    @Column(name = "nombre_persona", nullable = false, length = 20, unique = true)  
    private String nombre;

    @Column(name = "apellidos_persona")
    private String apellidos;

    @Column(name = "edad_persona")
    private int edad;

    @Column(name = "fecha_contratacion_persona")
    private Date fechaContratacion;

    @Transient
    private String estadoCivil;

    // Constructores
    public Persona() {
        System.out.println("Se está creando un objeto de tipo Persona");
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, String apellidos, int edad, String estadoCivil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
    }

    public Persona(String nombre, String apellidos, int edad, Date fechaContratacion, String estadoCivil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaContratacion = fechaContratacion;
        this.estadoCivil = estadoCivil;
    }

    // Getters y Setters
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    // toString
    @Override
    public String toString() {
        return "Persona [Id: " + id + ", Nombre:" + nombre + ", Apellidos: " + apellidos + ", Edad: " + edad
                + ", Fecha Contratacion: " + fechaContratacion + ", Estado Civil: " + estadoCivil + "]";
    }

}

    
