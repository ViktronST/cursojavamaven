package es.cursojava.inicio.bucles.ejercicios;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		
//		Solicitar por consola el numero de números de la serie de Fibonacci que se quieren mostrar
//		Serie de Fibonacci: 0,1,1,2,3,5,8,13,21,34,55,....
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("¿Cuántos números de la serie de Fibonacci quieres?");
		int num = scan.nextInt();
		
		int a = 0;
		int b = 1;
		int c = 0;
		
		for(int i=0 ; i<num ; i++) {
			System.out.println(c);
			c = a + b;
			b = a;
			a = c;
		}
		
//		int num1 = 0;
//		int num2 = 1;
//		
//		System.out.println(num1);
//		System.out.println(num2);
//		
//		for(int i=2 ; i<num ; i++) {
//			int suma = num1 + num2;
//			System.out.println(suma);
//			num1 = num2;
//			num2 = suma;
//		}

	}

}
