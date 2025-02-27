package es.cursojava.poo.herencia.orquesta;

public class Piano extends Instrumento{
    private int numeroOctavas;
    private String tipoPiano;
    
    //Constructor
    public Piano(String nombre, String tipo, int numeroOctavas, String tipoPiano) {
        super(nombre, tipo);
        this.numeroOctavas = numeroOctavas;
        this.tipoPiano = tipoPiano;
    }

    @Override
    public void afinar() {
        super.afinar();
        System.out.println(" Afinando Piano.");
        System.out.println("========================================");
    }

    //Getters y Setters
    public int getNumeroOctavas() {
        return numeroOctavas;
    }

    public void setNumeroOctavas(int numeroOctavas) {
        this.numeroOctavas = numeroOctavas;
    }

    public String getTipoPiano() {
        return tipoPiano;
    }

    public void setTipoPiano(String tipoPiano) {
        this.tipoPiano = tipoPiano;
    }

    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Piano { ");
        sb.append(padre);
        sb.append(", Número de Octavas: ").append(numeroOctavas);
        sb.append(", Tipo de Piano: ").append(tipoPiano);
        sb.append(" }");
        return sb.toString();
    }


    
}
