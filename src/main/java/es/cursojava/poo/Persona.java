package es.cursojava.poo;

//POJO (Plain Old Java Object): Clase que solo tiene atributos y métodos getter y setter.
public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private double peso;

    //Constructor por defecto
    public Persona() {

    }

    //Constructor 1
    public Persona(String nombre, String apellido, String dni, double peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.peso = peso;
    }

    //Constructor 2 (Sobrecarga de constructores)
    public Persona(String nombre, String apellido, String dni) { 
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    //Getters y Setters de nombre
    public String getNombre() { //Getter: Método que devuelve el valor de un atributo.
        return nombre;
    }

    public void setNombre(String nombre) { //Setter: Método que asigna un valor a un atributo.
        this.nombre = nombre;
    }

    //Getters y Setters de apellido
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Getters y Setters de dni
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //Getters y Setters de peso
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    //Método para correr 
    public void corre() {
        System.out.println("La persona " + this.nombre + " está corriendo."); //No hace falta poner this, pero es recomendable.
    }

    public void correr(){
        System.out.println("La persona " + this.nombre);
        if (this.peso > 50) {
            System.out.println(" corre muy rápido.");
        } else if (this.peso > 70) {
            System.out.println(" corre rápido.");
        } else if (this.peso > 100) {
            System.out.println(" corre lento.");
        } else{
            System.out.println(" corre muy lento.");
        }
    }
}
