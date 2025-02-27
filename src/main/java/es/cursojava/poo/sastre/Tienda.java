package es.cursojava.poo.sastre;

public class Tienda {
    public static void main(String[] args) {
        Boton boton1 = new Boton("rojo", "pequeño", "redondo");
        Boton boton2 = new Boton("azul", "mediano", "cuadrado");
        Boton boton3 = new Boton("verde", "grande", "redondo");

        Boton[] botones = {boton1, boton2, boton3};

        Pantalon pantalon1 = new Pantalon("azul", 20.0, "M", boton1);

        Camisa camisa1 = new Camisa("rojo", 15.0, "S", botones);

        Vestido vestido1 = new Vestido("verde", 30.0, "L");

        System.out.println("=====================================");
        Maniqui maniqui1 = new Maniqui(902030, pantalon1, camisa1);
        System.out.println("Maniquí 1: " + maniqui1.getId());
        //Vestimos al maniqui1 con un pantalon y una camisa
        System.out.println("Pantalón: " + maniqui1.getPantalon().getColor() +
                            " | Botón: " + pantalon1.getBoton().getColor() + 
                            " | Talla: " + pantalon1.getTalla());
        System.out.println("Camisa: " + maniqui1.getCamisa().getColor() + 
                            " | Talla: " + camisa1.getTalla());
        for (Boton boton : camisa1.getBoton()) {
            System.out.println("Botones de la camisa: Color = " + boton.getColor() + 
                            " | Tamaño = " + boton.getTamanio() + 
                            " | Forma = " + boton.getForma());
            break;
        }
        // Boton botonesCamisa = camisa1.getBoton()[0];
        // System.out.println("Botones de la camisa: Color = " + botonesCamisa.getColor() + 
        //                " | Tamaño = " + botonesCamisa.getTamanio() + 
        //                " | Forma = " + botonesCamisa.getForma());

        System.out.println("=====================================");
        Maniqui maniqui2 = new Maniqui(922232, vestido1);
        System.out.println("Maniquí 2: " + maniqui2.getId());
        //Vestimos al maniqui2 con un vestido
        System.out.println("Vestido: " + maniqui2.getVestido().getColor() +
                            " | Talla: " + vestido1.getTalla());

        System.out.println("=====================================");
        Maniqui maniqui3 = new Maniqui(992233);
        System.out.println("Maniquí 3: " + maniqui3.getId());

    }
    
}
