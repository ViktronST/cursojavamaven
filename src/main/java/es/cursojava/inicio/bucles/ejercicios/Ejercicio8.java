package es.cursojava.inicio.bucles.ejercicios;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		
//		Numero tenistas en el top 10 --> 
//		Pedir por teclado la cantidad de tenistas que se apuntan a un torneo, 
//		Por cada uno de ellos preguntar en que puesto de la ATP se encuentran. 
//		Indicar cuantos tenistas estarían entre los diez primeros.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("¿Cuántos tenistas se apuntan al torneo?");
		int numTenistas = scan.nextInt();
		int contadorTop10 = 0;
		
		for(int i=1 ; i<numTenistas ; i++) {
			System.out.println("Ingresa el puesto ATP del tenista " + i + ": ");
			int puestoATP = scan.nextInt();
			
			if(puestoATP>=1 && puestoATP<=10) {
				contadorTop10++;
			}
		}
		System.out.println("Número de tenistas en el top 10 :" + contadorTop10);
		
		
//		for(int i=1 ; i<numTenistas ; i++) {
//			int puestoATP = 0;
//			do {
//				System.out.println("Ingresa el puesto ATP del tenista " + i + ": ");
//				puestoATP = scan.nextInt();
//			}while (puestoATP<0);
//			
//			if(puestoATP<=10) {
//				contadorTop10++;
//			}
//		}
//		System.out.println("Número de tenistas en el top 10 :" + contadorTop10);

	}

}
