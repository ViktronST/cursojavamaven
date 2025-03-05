package es.cursojava.utiles;

import java.util.Scanner;

public class Utilidades {
	
	public static int pideDatoNumerico(String texto) {
		System.out.print(texto);
		Scanner scan = new Scanner(System.in);
		int numero = scan.nextInt();
		
		return numero;
	}
	
	public static String pideDatoCadena(String texto) {
		System.out.print(texto);
		Scanner scan = new Scanner(System.in);
		String cadena = scan.nextLine();
		
		return cadena;
	}
	
	public static void pintaMenu(String[] menuArray) {
//		for (String opcion : menuArray) {
//			System.out.println(opcion);
//		}
//		System.out.println("Introduce una opción: ");
		pintaMenu(menuArray, "Introduce una opción: ");
	}
	
	public static void pintaMenu(String[] menuArray, String texto) {
		for (String opcion : menuArray) {
			System.out.println(opcion);
		}
		System.out.println(texto);
	}
	
	
}
