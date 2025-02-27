package es.cursojava.inicio.operadoreslogicos.ejercicios;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		
//		Haz un programa que:
//		    1. Pida al usuario un número entero.
//		    2. Determine si el número es par o impar utilizando el operador módulo (%).
//		    3. Muestre el resultado.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduce un número: ");
		int num1 = scan.nextInt();
		
		boolean esPar = num1%2==0;
		//boolean esImpar = num1%2!=0;
		
		System.out.println("El número " + num1 + " es par " + esPar);
		System.out.println("El número " + num1 + " es impar " + !esPar);
		
		scan.close();
		
	}

}
