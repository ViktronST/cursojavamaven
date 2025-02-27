package es.cursojava.inicio.arrays.ejercicios;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		//Pedir cuantos números se van a guardar
		//Pedir los valores de cada número
		//Mostrar todos los números introducidos
		//Reordenar los números de manera inversa en el array
		//Mostrar de nuevo todos los números

		//Original: 4, 2, 8, 3, 7
		//Inverso: 7, 3, 8, 2, 4
		
		Scanner scan = new Scanner(System.in);
		
	//Pedir cuantos números se van a guardar
		System.out.println("¿Cuántos números vas a utilizar?");
		int numeros = scan.nextInt();
		int[] valores = new int[numeros];
		
		for(int i=0 ; i<valores.length ; i++){
			scan = new Scanner(System.in);
			System.out.print("Escribe el valor del número: ");
			valores[i] = scan.nextInt();
		}
		
	//Mostrar todos los números introducidos
		for(int i=0 ; i<valores.length ; i++){
			System.out.print(valores[i]+", ");
		}
		
//		for (int numero : valores) {
//			System.out.print(numero + ", ");
//		}
		
		System.out.println(""); //Salto de línea
		
	//Reordenar los números de manera inversa en el array
		int n = valores.length;
		for(int i=0 ; i<n/2 ; i++) {
			int invertir = valores[i];
			valores[i] = valores [n-1-i];
			valores[n-1-i] = invertir;
		}
		
//		for(int i=0 ; i<valores.length/2 ; i++) {
//			int numAux = valores[i];
//			valores[i] = valores[valores.length-1-i];
//			valores[valores.length-1-i] = numAux;	
//		}
		
	//Mostrar de nuevo todos los números
		for(int i=0 ; i<valores.length ; i++){
			System.out.print(valores[i]+", ");
		}
		
//		for (int numero : valores) {
//			System.out.print(numero + ", ");
//		}
		
	}

}
