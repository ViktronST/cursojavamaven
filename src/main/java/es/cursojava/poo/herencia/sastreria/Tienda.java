package es.cursojava.poo.herencia.sastreria;

public class Tienda {
    
    private String nombre;

    public Tienda(String nombre){
        this.nombre = nombre;
    }
    
    public static void main(String[] args) {
        Tienda tienda = new Tienda("El perrito faldero");
        Maniqui[] maniquies = tienda.abrirTienda();
        tienda.mostrarEscaparate(maniquies);
    }

    private Maniqui[] abrirTienda(){
        Vestido vestido = new Vestido("Verde", 50.5, "L");
        Maniqui maniqui1 = new Maniqui(922232, vestido);

        Boton boton = new Boton("Negro","Redondo","Pequeño");
        Pantalon pantalon = new Pantalon("Negro", 42.0, "M", boton);

        Camisa camisa = new Camisa("Blanco", 29.90, "M");

        Boton boton1 = new Boton("Negro","Pequeño","Redondo");
        Boton boton2 = new Boton("Azul", "Mediano", "Cuadrado");
        Boton boton3 = new Boton("Verde", "Grande", "Redondo");
        // Boton[] botones = new Boton[3];
        // botones[0] = boton1;

        Boton[] botones =  {boton1, boton2, boton3};
        Camisa camisa1 = new Camisa("Blanco", 29.90, "M", botones);

        Maniqui maniqui2 = new Maniqui(902030, pantalon, camisa1);
        Maniqui maniqui3 = new Maniqui(992233);

        // Boton b = maniqui2.getCamisa().getBoton()[0];
        // System.out.println(b.getColor());
        // System.out.println(b.getForma());
        // System.out.println(b.getTamanio());

        Maniqui[] maniquies = {maniqui1, maniqui2, maniqui3};

        return maniquies;
    }

    private void mostrarEscaparate(Maniqui[] maniquies){
        for (Maniqui maniqui : maniquies){
            double precioTotal = 0;
            System.out.println("Información del maniqui: " + maniqui.getId());
            
            //Datos del pantalón
            Pantalon pantalon = maniqui.getPantalon();
            if(pantalon!=null){                              //A través del control de los null, nos mostrará solo lo que lleve puesto el maniqui.
                System.out.println("- Pantalón:");
                System.out.println("\t Color: " + pantalon.getColor());
                System.out.println("\t Talla: " + pantalon.getTalla());
                System.out.println("\t Precio: " + pantalon.getPrecio());
                System.out.println("\t Botón: " + pantalon.getBoton().getColor());
                precioTotal += pantalon.getPrecio();
            }
            
            Camisa camisa = maniqui.getCamisa();
            if (camisa!=null){
                System.out.println("Camisa:");
                System.out.println("\t Color: "+ camisa.getColor());
                System.out.println("\t Talla: "+ camisa.getTalla());
                System.out.println("\t Precio: "+ camisa.getPrecio());
                Boton[] botones = camisa.getBoton();
                if (botones!=null){
                    for (Boton boton : botones) {
                        System.out.println("\t\t Boton: "+ boton.getColor() +" "+ boton.getForma() 
                        +" "+ boton.getTamanio() );
                        
                    }
                }
                precioTotal += camisa.getPrecio();
            }

            Vestido vestido = maniqui.getVestido();
            if(camisa!=null){
                System.out.println("- Vestido:");
                System.out.println("\t Color: " + vestido.getColor());
                System.out.println("\t Talla: " + vestido.getTalla());
                System.out.println("\t Precio: " + vestido.getPrecio());
                precioTotal += vestido.getPrecio();
            }
            System.out.println("Precio total: "+precioTotal);
        }
    }

    private void desvestirManiquies(Maniqui[] maniquies){       //Le pasamos la referencia al Array y desreferenciar a los objetos.
        for (Maniqui maniqui : maniquies) {
            maniqui.desvestir();
        }
    }
}
