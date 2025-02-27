package es.cursojava.inicio.string.ejercicios;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		//Escribe un programa que reciba un String con varias palabras separadas por espacios y determine cuál es la palabra más larga.
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un texto:");
		String texto = scan.nextLine();
		String palabraLarga = "";
		
		boolean continua = true;
		
		while(continua) {
			int posicionEspacio = texto.indexOf(" ");
			
			String palabra = texto.substring(0,posicionEspacio);
			
			int tamanioPalabra = palabra.length();
			
			System.out.println(palabra);
			
			texto = texto.substring(posicionEspacio+1);
			
			if(tamanioPalabra<palabraLarga.length()) {
				palabraLarga = palabra;
			}
			
			if(!texto.contains(" ")) {
				System.out.println(texto);
				if(texto.length()>palabraLarga.length()) {
					palabraLarga = texto;
				}
				continua = false;
			}
		}
		System.out.println("\nPalabra más larga: " + palabraLarga);
		
		scan.close();
	}

}
