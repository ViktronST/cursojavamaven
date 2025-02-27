package es.cursojava.poo.herencia.orquesta;

public class Instrumento {
    private String nombre;
    private String tipo;
    private boolean afinado;
    
    //Constructor
    public Instrumento(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    //Métodos
    public void afinar(){
        System.out.println("Afinando instrumento " + nombre);
        if(Math.random() < 0.4){
            System.out.println("El isntrumento " + nombre + " no se pudo afinar correctamente.");
            this.afinado = false;
        }else{
            System.out.println("El isntrumento " + nombre + " está afinando correctamente.");
            this.afinado = true;
        }

        // this.afinado = Math.random() > 0.4;
        // if(afinado){
        //     System.out.println("El isntrumento " + nombre + " no se pudo afinar correctamente.");
        // }else{
        //     System.out.println("El isntrumento " + nombre + " está afinando correctamente.");
        // }
    }

    public void tocar(){
        System.out.println("Tocando instrumento " + nombre);
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAfinado() {
        return afinado;
    }

    public void setAfinado(boolean afinado) {
        this.afinado = afinado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre);
        sb.append(", Tipo: ").append(tipo);
        sb.append(", Afinado: " ).append(afinado);
        return sb.toString();
    }

}
