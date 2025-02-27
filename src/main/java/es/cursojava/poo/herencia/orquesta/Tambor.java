package es.cursojava.poo.herencia.orquesta;

public class Tambor extends Instrumento{
    private String material;

    //Constructor
    public Tambor(String nombre, String tipo, String material) {
        super(nombre, tipo);
        this.material = material;
    }

    @Override
    public void tocar() {
        System.out.println("Tocando el Tambor de " + material + ".");
    }

    @Override
    public void afinar() {
        this.setAfinado(true); //SIEMPRE AFINADO
        System.out.println("El Tambor " + getNombre() + " está afinado.");
        System.out.println("========================================");
    }

    public void aporrear() {
        System.out.println("Aporreando Tambor de " + material + ".");
    }

    //Getters y Setters
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Tambor { ");
        sb.append(padre);
        sb.append(", Material: ").append(material);
        sb.append(" }");
        return sb.toString();
    }
    
}
