package es.cursojava.poo.cinefilos;

import es.cursojava.inicio.funciones.Utilidades;

public class PruebaCine {
    public static void main(String[] args) {
        PruebaCine pruebaCine = new PruebaCine();
        pruebaCine.arrancarCine();
    }

    private Cine crearCine(){
        Sala sala1 = new Sala(1, "Avatar", 3, 3);
        Sala sala2 = new Sala(2, "Tennet", 2, 2);
        Sala sala3 = new Sala(3, "Los Odiosos 8", 4, 4);
        Sala[] salas = {sala1, sala2, sala3};

        Cine cine = new Cine("Cine Ejemplo", salas);
        return cine;
    }

    private Espectador[] creaEspectadores(){
        Espectador espectador1 = new Espectador("Ricky Matin", "12345678A");
        Espectador espectador2 = new Espectador("Sergio Goodguy", "23456789B");
        Espectador espectador3 = new Espectador("Ivan Ionevski", "34567890C");
        Espectador[] espectadores = {espectador1, espectador2, espectador3};
        
        return espectadores;
    }

    private void arrancarCine(){
        Cine cine = crearCine();
        Espectador[] espectadores = creaEspectadores();
        gestionEntradas(cine, espectadores);
        resumen(cine);
    }

    private void gestionEntradas(Cine cine, Espectador[] espectadores){
        //Recorremos todos los espectadores
        for (Espectador espectador : espectadores) {
            System.out.println("\nEl espectador " + espectador.getNombre() + " está comprando entradas");
            mostrarCartelera(cine);
            int numSala = Utilidades.pideDatoNumerico("Introduce el número de sala: ");
            Sala salaSeleccionada = cine.getSalas()[numSala-1];
            mostrarButacas(salaSeleccionada);
            reservaButacas(salaSeleccionada.getButacas(), espectador);
        }
    }

    //Hay que meter una variación para las butacas YA reservadas.
    //También si el espectador elige una butaca inexistente.
    //Y vovler a preguntarle sobre su elección, en ambos casos.
    //Mostrar las butacas reservadas después de que las reserve el espectador.
    //Mostrar el precio total de las entradas que va a pagar.
    private void reservaButacas(Espectador[][] butacas, Espectador espectador){
        int numEntradas = Utilidades.pideDatoNumerico(espectador.getNombre() + ", ¿Cuántas entradas quieres? ");
        String nombreEspectador = espectador.getNombre();
        for (int i = 0; i < numEntradas; i++) {
            System.out.println("Espectador " + nombreEspectador + " está reservando la entrada " + (i+1));
            int fila = Utilidades.pideDatoNumerico(nombreEspectador + ", introduce fila: ");
            int columna = Utilidades.pideDatoNumerico(nombreEspectador + ", introduce columna: ");
            butacas[fila-1][columna-1] = espectador; 
        }
        System.out.println("Butacas reservadas para " + nombreEspectador);
    }

    private void mostrarCartelera (Cine cine){
        Sala [] salas = cine.getSalas();
        for (Sala sala : salas) {
            System.out.println(sala);
        }
    }

    private void mostrarButacas (Sala sala){
        Espectador[][] butacas = sala.getButacas();
        System.out.println("Butacas disponibles para la película "+sala.getTituloPelicula());

        for (int i = 0; i < butacas.length; i++) {//filas
            System.out.print("Fila " + (i+1));

            for (int j = 0; j < butacas[i].length; j++) {//columnas

                if(butacas[i][j]==null){
                    System.out.print("\tO");        
                }else{
                    System.out.print("\tX");
                }

            }
            System.out.println("");
        }

    }

    private void resumen (Cine cine){
        System.out.println("\nCINE: " + cine.getNombre());

        Sala[] salasCine = cine.getSalas();
        for (Sala sala : salasCine) {

            System.out.println("\t" + sala.toString());

            Espectador[][] butacas = sala.getButacas();
            for (Espectador[] filaEspectadores : butacas) {

                for(Espectador columnaEspectadores : filaEspectadores){
                    
                    if(columnaEspectadores!=null){
                        System.out.println("\t\t" + columnaEspectadores);
                    }                    
                }
            }
        }
    }
    
}

