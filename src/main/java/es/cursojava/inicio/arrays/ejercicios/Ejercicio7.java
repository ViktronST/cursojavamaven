package es.cursojava.inicio.arrays.ejercicios;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		
//		De una matriz 4x4
//		Pedir los datos de la matriz
//		Sacar los números de la diagonal
//		Invertir la diagonal y mostrar la matriz (que estén al reves dentro del array)
		
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
		
		System.out.print("\nNúmeros en la diagonal principal: ");
		for(int i=0 ; i<numeros.length ; i++) {
			System.out.print(numeros[i][i]+", ");
		}
		
//		System.out.print("\nNúmeros en la diagonal invertida: ");
//		for(int i=0 ; i<numeros.length ; i++) {
//			for(int j=0 ; j<numeros[i].length ; j++) {
//				if(i==j) {
//					System.out.print(numeros[i][j] + "\t");
//				}else {
//					System.out.println("*\t");
//			}
//		}
//		System.out.println("");
		
		for(int i=0 ; i<numeros.length/2 ; i++) {
			int numAux = numeros[i][i];
			numeros[i][i] = numeros[numeros.length-1-i][numeros.length-1-i];
			numeros[numeros.length-1-i][numeros.length-1-i] = numAux;
		}
		
		System.out.print("\nNúmeros en la diagonal invertida: ");
		for(int i=0 ; i<numeros.length ; i++) {
			System.out.print(numeros[i][i]+", ");
		}
		System.out.println("");
		
		System.out.println("\n - - - Matríz - - - ");
		for(int i=0 ; i<numeros.length ; i++) {
			for(int j=0 ; j<numeros[i].length ; j++) {
				System.out.print(numeros[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
