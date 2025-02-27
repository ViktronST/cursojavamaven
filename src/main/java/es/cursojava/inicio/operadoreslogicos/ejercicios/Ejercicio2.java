package es.cursojava.inicio.operadoreslogicos.ejercicios;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		
//		Escribe un programa que:
//		    1. Solicite al usuario dos números enteros.
//		    2. Compare si el primer número es mayor, menor o igual al segundo.
//		    3. Muestre un mensaje indicando el resultado de la comparación.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce un número: ");
		int num1 = scan.nextInt();
		
		System.out.println("Introduce otro número ");
		int num2 = scan.nextInt();
		
		boolean comparador = num1>num2;
		
		System.out.println(num1 + " es mayor que " + num2 + " : " + comparador);
		System.out.println(num1 + " es igual a " + num2 + " : " + (num1==num2));
		System.out.println(num1 + " es menor que " + num2 + " : " + (num1<num2));
		
		scan.close();
		
	}

}
