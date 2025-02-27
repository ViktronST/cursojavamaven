package es.cursojava.poo.herencia.reinoanimal;

public class Animal {
    //Atributos
    private String nombre;
    private double peso;
    
    //Constructor con parámetros
    public Animal(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    //Métodos
    public void comer(){
        System.out.println("El animal " + this.nombre + " está comiendo.");
    }

    public void beber(){
        System.out.println("El animal " + this.nombre + " está bebeindo.");

    }
}
