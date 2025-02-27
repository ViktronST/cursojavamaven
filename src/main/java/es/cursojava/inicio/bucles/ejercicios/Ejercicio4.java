package es.cursojava.inicio.bucles.ejercicios;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		//Mostrar todas las tablas de multiplicar hasta el número que solicitéis al usuario
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Dame un número: ");
		int num = scan.nextInt();
		
		if(num<=0) {
			System.out.println("ingrsa un número mayor a 0");
		}else {
			for(int i=1 ; i<=num ; i++) {
				System.out.println("Tabla del " + i + ": ");
				for(int j=1 ; j<=10 ; j++) {
					System.out.println("\t" + i + " x " + j + " = " + (i*j)); // "\t" se utiliza para tabular, genera un espacio en la consola. 
				}
			}
		}
		scan.close();
	}
}
