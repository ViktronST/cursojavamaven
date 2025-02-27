package es.cursojava.poo.herencia.orquesta;

public class GuitarraElectrica extends Guitarra{
    private double potencia;

    //Constructor
    public GuitarraElectrica(String nombre, String tipo, double potencia) {
		super(nombre, tipo);
		this.potencia = potencia;
	}

	public GuitarraElectrica(String nombre, String tipo) {
		super(nombre, tipo);
	}

	public GuitarraElectrica(int numCuerdas, String nombre, String tipo) {
		super(numCuerdas, nombre, tipo);
	}

    //Método
    public void tocar(){
        System.out.println("Tocando la guitarra eléctrica " + getNombre() + " muy alto.");
    }

    //Getters y Setters
    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        String padre = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Guittarra Electrica [ ");
        sb.append(padre);
        sb.append(", Potencia: ").append(potencia);
        sb.append(" ]");
        return sb.toString();
    }
    
}
