package es.cursojava.inicio.operadoreslogicos.ejercicios;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		
//		Crea un programa que:
//		    1. Pida al usuario dos números.
//		    2. Solicite la operación a realizar (+, -, *, /).
//		    3. Realice la operación correspondiente y muestre el resultado.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Escribe un número: ");
		int num1 = scan.nextInt();
		
		System.out.print("Escribe otro número: ");
		int num2 = scan.nextInt();
		
		System.out.println("La suma de los números da: " + (num1+num2));
		System.out.println("La resta de los números da: " + (num1-num2));
		System.out.println("La multiplicación de los números da: " + (num1*num2));
		System.out.println("La división de los números da: " + (num1/num2));
		
		scan.close();
		
	}
	

}
