package es.cursojava.poo.sastre;

public class Camisa {
    //Creamos la clase camisa con los atributos color, precio, talla y botón.
    private String color;
    private double precio;
    private String talla;
    private Boton[] botones;

    //Constructor con parámetros
    public Camisa(String color, double precio, String talla, Boton[] botones) {
        this.color = color;
        this.precio = precio;
        this.talla = talla;
        this.botones = botones;
    }

    public Camisa(String color, double precio, String talla) {
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

    public Boton[] getBoton() {
        return botones;
    }

    public void setBoton(Boton[] botones) {
        this.botones = botones;
    }
    
}
