package es.cursojava.inicio.bucles.ejercicios;

public class Ejercicio3 {
	static public void main(String[] args) {
		
		//Mostrar los pares del 2 al 100 y al mismo tiempo los impares del 99 al 1
		
		//Si se pueden meter dos variables en un mismo bucle
		for (int i=2, j=99 ; i<=100 ; i+=2,j-=2) {
			System.out.println(i + " - " + j);
		}
		
//		int pares = 2;
//		int impares = 99;
//		while(pares<=100) {
//			System.out.println(pares + " - " + impares);
//			pares+=2;
//			impares-=2;
//		}
		
	}
	
}
