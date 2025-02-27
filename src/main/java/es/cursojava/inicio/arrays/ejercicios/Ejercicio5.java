package es.cursojava.inicio.arrays.ejercicios;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
//		+ Definir array bidimensional de enteros de 4x4
//		+ Pedir los valores de cada posición de una en una
//		+ Mostrar todos los datos en formato matriz con dos for anidados
//		+ Por cada fila mostrar la media de los numeros
//		+ Mostrar los números de la diagonal
		
		Scanner scan = new Scanner(System.in);
		
		int[][] numeros = new int[4][4];
		
		System.out.println("Dame el número para la posición:");
		for(int i=0 ; i<numeros.length ; i++) {
			for(int j=0 ; j<numeros[i].length ; j++) {
				scan = new Scanner(System.in);
				System.out.print("["+i+"]["+j+"]: ");
				numeros[i][j] = scan.nextInt();
			}
		}
		
		System.out.println("\n - - - Matríz - - - ");
		for(int i=0 ; i<numeros.length ; i++) {
			for(int j=0 ; j<numeros[i].length ; j++) {
				System.out.print(numeros[i][j] + "\t");
			}
			System.out.println("");
		}
		
		System.out.println("\n - - - Media - - - ");
		int suma = 0;
		for(int i=0 ; i<numeros.length ; i++) {
			for(int j=0 ; j<numeros[i].length ; j++) {
				suma += numeros[i][j];
			}
			System.out.println("Media de la fila " + i + ": " + suma/numeros.length);
		}
		
		System.out.print("\nNúmeros en la diagonal principal: ");
		for(int i=0 ; i<numeros.length ; i++) {
			System.out.print(numeros[i][i]+", ");
		}
	}

}
