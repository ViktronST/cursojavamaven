package es.cursojava.poo.herencia.reinoanimal;

public class Leon extends Animal{
    //Atributos
    private boolean tieneMelena;

    //Constructor con parámetros
    public Leon (boolean tieneMelena, String nombre, double peso){
        super(nombre, peso); //Llamamos a los atributos de la clase PADRE.
        this.tieneMelena = tieneMelena;
    }

    public Leon (boolean tieneMelena, String nombre){
        super(nombre); //Llamamos a los atributos de la clase PADRE.
        this.tieneMelena = tieneMelena;
    }

    //Método
    public void cazar(){
        System.out.println("El león " + getNombre() + " está cazando.");
    }

    //Lammamos al método del Padre y lo ampliamos
    @Override
    public void comer() {
        super.comer();
        System.out.println(" Ferozmente.");
    }

    
}
