package es.cursojava.inicio.string.ejercicios;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		
		//Escribe un programa que determine si un String ingresado por el usuario es un palíndromo 
		//(se lee igual de izquierda a derecha que de derecha a izquierda, ignorando mayúsculas y espacios)
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce una frase:");
		String texto = scan.nextLine().toLowerCase();
		String palindromo = "";
		
		for(int i=texto.length()-1 ; i>=0 ; i--) {
			palindromo = palindromo + texto.charAt(i);
		}
		if(texto.equals(palindromo)) {             //Podríamos utilizar el (.equalsIgnoreCase) en vez de (.toLowerCase).
			System.out.print("La paralabra " + palindromo + " es un palíndromo.");
		}else {
			System.out.println("La palabra " + texto + " no es un palíndromo.");
		}
		
//		//Otra forma de hacerlo
//		boolean esPalindromo = true;               //También se puede hacer con un entero (int esPalindromo = 0;).
//		for(int i=0; i<texto.length()/2 ; i++) {
//			texto.charAt(i);                       //Toma el primer carácter y va aumentado.
//			texto.charAt(texto.length()-1-i);      //Toma el último carácter y va retrocediendo.
//			
//			if(texto.charAt(i) != texto.charAt(texto.length()-1-i)){
//				System.out.print(texto + " NO es palíndromo.");
//				esPalindromo = false;              //Si se hace con un entero: (esPalindromo = 1;).
//				break;
//			}
//		}
//		if(esPalindromo) {
//			System.out.print(texto + " es palíndromo.");
//		}
		
		scan.close();
	}
}
