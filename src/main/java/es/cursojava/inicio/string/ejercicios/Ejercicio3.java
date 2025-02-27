package es.cursojava.inicio.string.ejercicios;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		
		//Crea un programa que cuente cuántas vocales (a, e, i, o, u) tiene un String. Ignora las mayúsculas y minúsculas.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce un texto:");
		String texto = scan.nextLine().toLowerCase();
		int contador = 0;
		
		for(int i=0 ; i<texto.length() ; i++) {
			if(texto.charAt(i)=='a' || texto.charAt(i)=='e' || texto.charAt(i)=='i' || texto.charAt(i)=='o' || texto.charAt(i)=='u') {
				contador++;
			}
		}
		System.out.println(texto + " contiene " + contador + " vocales.");
		
//		//Otra manera de hacerlo
//		String vocales = "aeiou";
//		for(int i=0 ; i<texto.length() ; i++) {
//			char caracter = texto.charAt(i);
//			if(texto.indexOf(caracter)!=-1) {
//				contador++;
//			}
//		}
//		System.out.println(texto + " contiene " + contador + " vocales.");
		
		scan.close();
	}
}
