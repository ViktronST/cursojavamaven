package es.cursojava.inicio.arrays.ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Pedir el número de alumnos.
		//Crear un Array de String con el número de alumnos indicado.
		//Pedir para cada alumno su nombre y guardarlo en el Array.
		//Mostrar el nombre de todos los alumnos.
		//Mostrar el nombre de todos los alumnos que empiecen por A.
		
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Cunántos alumnos vas a registrar?");
		int numAlumnos = scan.nextInt();
		String[] nombresAlumnos = new String[numAlumnos];
		
		for(int i=0 ; i<nombresAlumnos.length ; i++) {   //Tambien se puede poner i<numAlumnos.
			scan = new Scanner(System.in);
			System.out.print("Introduce el nombre del alumno: ");
			nombresAlumnos[i] = scan.nextLine();
		}
		
		//Otra manera de hacerlo
//		int i=0;
//		for(String nombre : nombresAlumnos) {
//			scan = new Scanner(System.in);
//			System.out.print("Introduce el nombre del alumno: ");
//			nombresAlumnos[i] = scan.nextLine();
//			i++;
//		}
		
		System.out.println("\nLista de Alumnos:");
		for(int i=0 ; i<nombresAlumnos.length ; i++) {
			System.out.println(nombresAlumnos[i]);
		}
		
		System.out.println("\nNombres que empiezan por A:");
		for(String nombre : nombresAlumnos) {
			if(nombre.toLowerCase().startsWith("a")) {
				System.out.println(nombre);
			}
		}
		
		//Ejemplo con null y apellidos
//		String[] apellidosAlumnos = {"Martín",null,"Caro"};
//		int i=0;
//		for(String apellido : apellidosAlumnos) {
//			if(apellido==null) {
//				scan = new Scanner(System.in);
//				System.out.print("Introduce el apellido del alumno: ");
//				apellidosAlumnos[i] = scan.nextLine();
//			}
//			i++;
//		}
		
	}
}
