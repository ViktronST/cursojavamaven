package es.cursojava.bbdd.ejericios.ejercicio1;

import java.util.Date;

public class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private double salario;
    private int departamentoId;
    private Date fechaContratacion;
    private int equipoId;
    
    // Constructor
    public Empleado(int id, String nombre, int edad, double salario, int departamentoId, Date fechaContratacion, int equipoId) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamentoId = departamentoId;
        this.fechaContratacion = fechaContratacion;
        this.equipoId = equipoId;
    }

    public Empleado(int id, String nombre, int edad, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    // toString
    @Override
    public String toString() {
        return "Empleado [ID: " + id + ", Nombre:" + nombre + ", Edad: " + edad + ", Salario:" + salario
                + ", Departamento_ID: " + departamentoId + ", Fecha de contratacion: " + fechaContratacion 
                + ", Eqipo_ID: " + equipoId + "]";
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public int getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }

    
}
