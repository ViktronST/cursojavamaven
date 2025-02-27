package es.cursojava.poo.herencia.orquesta;

public class Guitarra extends Instrumento{
    private int numCuerdas;

    //Constructor
    public Guitarra(String nombre, String tipo) {
        super(nombre, tipo);
        this.numCuerdas = 6;
    }

    public Guitarra(int numCuerdas, String nombre, String tipo) {
        super(nombre, tipo);
        this.numCuerdas = numCuerdas;
    }

    //Método
    @Override
    public void afinar() {
        super.afinar();
        System.out.println(" Afinando Guitarra.");
        System.out.println("========================================");
    }

    //Getters y Setters
    public int getNumCuerdas() {
        return numCuerdas;
    }

    public void setNumCuerdas(int numCuerdas) {
        this.numCuerdas = numCuerdas;
    }

    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Guittarra { ");
        sb.append(padre);
        sb.append(", Número de Cuerdas: ").append(numCuerdas);
        sb.append(" }");
        return sb.toString();
    }

}
