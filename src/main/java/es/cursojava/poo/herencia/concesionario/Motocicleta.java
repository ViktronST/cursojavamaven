package es.cursojava.poo.herencia.concesionario;

public class Motocicleta extends Vehiculo{
    private boolean tieneSidecar;
    private int cilindrada;
    
    //Constructor
    public Motocicleta(String marca, String modelo, int anio, double velocidadMaxima, String tipo, boolean tieneSidecar,
            int cilindrada) {
        super(marca, modelo, anio, velocidadMaxima, tipo);
        this.tieneSidecar = tieneSidecar;
        this.cilindrada = cilindrada;
    }

    //Método
    @Override
    public void mostrarInformacion() {
        //super.mostrarInformacion();
        System.out.println(toString());
        // System.out.println("Cilindrada: " + cilindrada + " cc.");
        // System.out.println("Sidecar: " + tieneSidecar);
    }

    //toString
    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("\nMotocicleta { ");
        sb.append(padre);
        //sb.append(super.toString());
        sb.append("\n\tCILINDRADA: ").append(cilindrada).append(" cc.");
        sb.append("\n\tTIENE SIDECAR: ").append(tieneSidecar?"Sí":"No"); //De normal devuelve true o false, de esta manera 
        sb.append("\n\t}");                                                //nos aseguramos de que nos conteste.
        return sb.toString();
    }

    //Getters y Setters
    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

}
