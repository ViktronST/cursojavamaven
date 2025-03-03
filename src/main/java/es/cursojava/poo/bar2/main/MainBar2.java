package es.cursojava.poo.bar2.main;

import es.cursojava.poo.bar2.clases.TazaCafe;
import es.cursojava.poo.bar2.clases.hija.ClienteAsiduo;
import es.cursojava.poo.bar2.clases.hija.Comensal;
import es.cursojava.poo.bar2.clases.hija.Huesped;
import es.cursojava.poo.bar2.excepcion.hija.TooColdTemperatureException;
import es.cursojava.poo.bar2.excepcion.hija.TooHotTemperatureException;
import es.cursojava.poo.bar2.interfaz.Cafeteable;

public class MainBar2 {
    
    private String nombre;
	
	public MainBar2(String nombre) {
		super();
		this.nombre = nombre;
	}

	public static void main(String[] args) {
		MainBar2 bar = new MainBar2("Casa Lola");
		bar.abrirBar();
	}
	
	public void abrirBar() {
		System.out.println("Abriendo el bar "+ this.nombre);
		
		Huesped huesped = new Huesped("N1", "1111A");
		Comensal comensal = new Comensal("N2",true);
		ClienteAsiduo clienteAsiduo = new ClienteAsiduo("N3", "ErPesao");
		
		Cafeteable[] cafeteros = {comensal,clienteAsiduo};
		servirCafe(cafeteros);
		
	}
	
	public void servirCafe(Cafeteable[] clientes) {
		
		for (Cafeteable cliente : clientes) {
			TazaCafe taza = new TazaCafe("Arabigo",50);
			try {
				cliente.tomarCafe(taza);
			} catch (TooHotTemperatureException e) {
				System.out.println("El cliente se ha quemado "+e.getMessage());
				//e.printStackTrace();
			} catch (TooColdTemperatureException e) {
				System.out.println("El cliente se ha quejado "+e.getMessage());
			}
		}
		
	}
}
