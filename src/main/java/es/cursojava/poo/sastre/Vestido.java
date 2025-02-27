package es.cursojava.poo.sastre;

public class Vestido {
    //Creamos la clase vestido con los atributos color, precio y talla.
    private String color;
    private double precio;
    private String talla;
    
    //Constructor con parámetros
    public Vestido(String color, double precio, String talla){
        this.color = color;
        this.precio = precio;
        this.talla = talla;
    }

    //Getters y Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
    
}
