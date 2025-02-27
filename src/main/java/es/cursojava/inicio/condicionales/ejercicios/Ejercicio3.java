package es.cursojava.inicio.condicionales.ejercicios;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
//		Pintar menu
//		1. Pintar Cuadrado
//		2. Validar email
//		3. Añadir Alumno
//		4. Salir
//
//		Elige una opción
//
//		Se pide la opción por teclado, dependiendo de la opción introducida le indicamos la que ha seleccionado, 
//		si selecciona la 4 le decimos "Adios!" y si no es ninguna de las que existe que se ha equivocado
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Bienvenido al Menú");
		System.out.println("1. Pintar Cuadrado");
		System.out.println("2. Validar email");
		System.out.println("3. Añadir alumno");
		System.out.println("4. Salir");
		System.out.print("\nElige una opción: ");
		scan = new Scanner(System.in);
		String opcion = scan.nextLine();
		
		if(opcion.equals("uno") || opcion.equals("1")) {
			System.out.println("Ha seleccionado Pintar Cuadrado");
		}else if(opcion.equals("dos") || opcion.equals("2")) {
			System.out.println("Ha seleccionado Validar email");
		}else if(opcion.equals("tres") || opcion.equals("3")) {
			System.out.println("Ha seleccionado Añadir alumno");
		}else if(opcion.equals("cuatro") || opcion.equals("4")) {
			System.out.println("Adiós!");
		}else {
			System.out.println("Oops!, error...");
		}
		
//		int opcion = scan.nextInt();
//		switch(opcion) {
//		case 1: System.out.println("Has elegido la opcion " + opcion + " Pintar Cuadrado.");break;
//		case 2: System.out.println("Has elegido la opcion " + opcion + " Pintar Cuadrado.");break;
//		case 3: System.out.println("Has elegido la opcion " + opcion + " Pintar Cuadrado.");break;
//		case 4: System.out.println("Adiós!");break;
//		default: System.out.println("Oops!, error...");
//		}
	}

}
