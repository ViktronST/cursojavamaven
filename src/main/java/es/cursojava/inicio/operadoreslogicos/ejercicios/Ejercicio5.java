package es.cursojava.inicio.operadoreslogicos.ejercicios;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		
//		Escribe un programa que:
//		    1. Pida al usuario una temperatura en grados Celsius.
//		    2. Convierta la temperatura a Fahrenheit utilizando la fórmula: F=C×9/5+32 
//		    3. Muestre el resultado en pantalla.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduce la temperatura en grados Celsius: ");
	
		double tempCelsius = scan.nextDouble();
		
		double tempFahrenheit = tempCelsius*(9/5)+32;
		
		System.out.print("La temperatura en Fahrenheir es: " + tempFahrenheit);
		
		scan.close();

	}

}
