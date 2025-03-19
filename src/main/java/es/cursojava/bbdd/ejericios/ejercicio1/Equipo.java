package es.cursojava.bbdd.ejericios.ejercicio1;

import java.util.Date;

public class Equipo {
    private int id;
    private String nombre;
    private Date fechaCreacion;

    // Constructor
    public Equipo(int id, String nombre, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    // toString
    @Override
    public String toString() {
        return "Equipo [ID: " + id + ", Nombre: " + nombre + ", Fecha de creacion: " + fechaCreacion + "]";
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
