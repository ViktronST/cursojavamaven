package es.cursojava.poo.herencia.sastreria;

public class Ropa {
    private String color;
    private double precio;
    private String talla;
    
    //Constructor
    public Ropa(String color, double precio, String talla) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Color = ").append(color);
        sb.append("| Precio = ").append(precio);
        sb.append("| Talla = " ).append(talla);
        return sb.toString();
    }
    
}
