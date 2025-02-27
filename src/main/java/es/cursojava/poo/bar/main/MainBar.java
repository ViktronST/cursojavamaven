package es.cursojava.poo.bar.main;

import java.util.ArrayList;
import java.util.List;

import es.cursojava.poo.bar.clases.TazaCafe;
import es.cursojava.poo.bar.clases.hija.ClienteAsiduo;
import es.cursojava.poo.bar.clases.hija.Comensal;
import es.cursojava.poo.bar.clases.hija.Huesped;
import es.cursojava.poo.bar.clases.padre.Cliente;
import es.cursojava.poo.bar.excepcion.hija.TooColdTemperatureException;
import es.cursojava.poo.bar.excepcion.hija.TooHotTemperatureException;

public class MainBar {

    private String nombreBar;
    private List<Cliente> clientes;

    public MainBar(String nombreBar){
        this.nombreBar = nombreBar;
        this.clientes = new ArrayList<>();
    }

    public static void main(String[] args) {
        MainBar bar = new MainBar("= = = = = Bar Akuda = = = = =");
        bar.mostrarNombreBar();
        bar.abrirBar(bar.clientes);
        bar.mostrarClientes(bar.clientes);
        bar.servirCafe(bar.clientes);
    }

    // Método para mostrar el nombre del bar.
    public void mostrarNombreBar() {
        System.out.println(nombreBar);
    }

    // Método abrirBar con un Huesped, un Comensal y un ClienteAsiduo.
    private void abrirBar(List<Cliente> clientes) {
        System.out.println("- Abriendo bar -");

        clientes.add(new Huesped("Juan", "12345678A"));
        clientes.add(new Comensal("Pedro", true));
        clientes.add(new ClienteAsiduo("Luis", "El Rápido"));

        // // Huesped
        // Huesped huesped = new Huesped("Juan", "12345678A");
        // System.out.println(huesped.toString());

        // // Comensal
        // Comensal comensal = new Comensal("Pedro", true);
        // System.out.println(comensal.toString());

        // // ClienteAsiduo
        // ClienteAsiduo clienteAsiduo = new ClienteAsiduo("Luis", "El Rápido");
        // System.out.println(clienteAsiduo.toString());

    }

    // Método para mostrar los clientes.
    private void mostrarClientes(List<Cliente> clientes) {
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    // Método para servir cafe al Comensal y al ClienteAsiduo.
    private void servirCafe(List<Cliente> clientes) {;
        System.out.println("\nSirviendo café...");

        for (Cliente cliente : clientes) {
            if (cliente instanceof Comensal || cliente instanceof ClienteAsiduo) {
                System.out.println("· El cliente " + cliente.getNombre() + " recibe una taza de café.");

                TazaCafe taza = new TazaCafe("Expreso", 60);

                try {
                    taza.tomarCafe();
                    System.out.println("\tEl cliente " + cliente.getNombre() + " ha tomado su café sin problemas.");
                } catch (TooHotTemperatureException | TooColdTemperatureException e) {
                    System.out.println("\tEl cliente " + cliente.getNombre() + " no pudo tomar su café: " + e.getMessage());
                }
            } else {
                System.out.println("· El cliente " + cliente.getNombre() + " no puede tomar café.");
            }
        }
        
        // System.out.println("\nSirviendo café...");
        // // Comensal
        // Comensal comensal = new Comensal("Pedro", true);
        // System.out.println(comensal.toString());
        // try {
        //     comensal.tomarCafe();
        // } catch (TooColdTemperatureException | TooHotTemperatureException error1) {
        //     error1.printStackTrace();
        // }
        
        // System.out.println("\nSirviendo café...");
        // // ClienteAsiduo
        // ClienteAsiduo clienteAsiduo = new ClienteAsiduo("Luis", "El Rápido");
        // System.out.println(clienteAsiduo.toString());
        // try {
        //     clienteAsiduo.tomarCafe();
        // } catch (Exception error2) {
        //     error2.printStackTrace();
        // }   
    }
}
