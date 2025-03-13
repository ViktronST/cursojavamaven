package es.cursojava.ficheros.ejercicios.ejercicio5;

import java.util.Date;

public class Evento {
    private int id;
    private String nombre;
    private Date fecha;
    private String lugar;
    private String descripcion;
    private int duracion;
    private double precio;
    private String organizador;
    private boolean gratuito;
    
    // Constructor
    public Evento(int id, String nombre, Date fecha, String lugar, String descripcion, int duracion, double precio,
            String organizador, boolean gratuito) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
        this.organizador = organizador;
        this.gratuito = gratuito;
    }

    // toString
    @Override
    public String toString() {
        return "Evento [ ID: " + id + " | Nombre: " + nombre + " | Fecha: " + fecha + " | Lugar: " + lugar + " | Descripción: "
                + descripcion + " | Duración: " + duracion + " | Precio: " + precio + " | Organizador: " + organizador
                + " | Gratuido: " + gratuito + " ]";
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public boolean isGratuido() {
        return gratuito;
    }

    public void setGratuido(boolean gratuito) {
        this.gratuito = gratuito;
    }

    

}
