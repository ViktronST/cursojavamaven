package es.cursojava.inicio.bucles.ejercicios;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		//Pedir 10 números e indicar cuántos son múltiplos de 3 y cuántos múltiplos de 5.
		
		Scanner scan = new Scanner(System.in);
		int contador = 0;
		int contadorMultiplosDe3 = 0;
		int contadorMultiplosDe5 = 0;
		
		do {
			System.out.println("Escribe un número.");
			int num = scan.nextInt();
			
			if(num%3==0) {
				contadorMultiplosDe3++;
			}
			if(num%5==0) {
				contadorMultiplosDe5++;
			}
			
			contador++;
		}while(contador<10);
		
		System.out.println("Hay " + contadorMultiplosDe3 + " múltiplos de 3.");
		System.out.println("Hay " + contadorMultiplosDe5 + " múltiplos de 5.");

	}

}
