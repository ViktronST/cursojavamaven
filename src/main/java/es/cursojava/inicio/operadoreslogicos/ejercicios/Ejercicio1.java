package es.cursojava.inicio.operadoreslogicos.ejercicios;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		
//		Crea un programa que:
//		    1. Pida al usuario la base y la altura de un rectángulo.
//		    2. Calcule el área del rectángulo usando la fórmula área = base * altura.
//		    3. Muestre el resultado en pantalla.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Dame la base del rectángulo: ");
		int base = scan.nextInt();
		System.out.println(base);
		
		System.out.print("Dame la altura del rectángulo: ");
		int altura = scan.nextInt();
		System.out.println(altura);
		
		System.out.print("El área del rectángulo es: " + (base * altura));
		
		scan.close();

	}

}
