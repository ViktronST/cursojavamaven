package es.cursojava.poo.herencia.sastreria;

public class Pantalon extends Ropa{
    private Boton boton;
    
    //Constructor con parámetros
    public Pantalon(String color, double precio, String talla, Boton boton) {
        super(color, precio, talla);
        this.boton = boton;
    }

    //Getters y Setters
    public Boton getBoton() {
        return boton;
    }

    public void setBoton(Boton boton) {
        this.boton = boton;
    }

    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Pantalón = { ");
        sb.append(padre);
        sb.append("| Boton = ").append(boton);
        sb.append(" }");
        return sb.toString();
    }
    
}
