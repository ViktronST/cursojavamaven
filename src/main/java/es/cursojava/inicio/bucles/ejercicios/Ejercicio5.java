package es.cursojava.inicio.bucles.ejercicios;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
//		Solicitar por consola el numero de alumnos de un aula. 
//		Pedir para cada alumno su nota
//		Indicar la nota media de todos los alumnos del aula.
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el número de alumnos del aula: ");
		int numAlumnos = scan.nextInt();
		
		if(numAlumnos<=0) {
			System.out.println("El número de alumnos debe ser mayor que 0.");
			return;
		}
		
		double sumaNotas = 0;
		
		for(int i=1 ; i<=numAlumnos ; i++) {
			System.out.println("Introduce la nota del alumno " + i + ": ");
			double nota = scan.nextDouble();
			
			if(nota<0 || nota>10) {
				System.out.println("Nota inválida");
				i--;
				continue;
			}
			sumaNotas += nota;
		}
		
//		int i = 1;
//		
//		do {
//			System.out.println("Introduce la nota del alumno " + i + ": ");
//			int nota = scan.nextInt();
//			
//			if(nota<0 || nota>10) {
//				System.out.println("Nota inválida");
//			}else {
//				sumaNotas += nota;
//				i++;
//			}
//		}while (i<=numAlumnos);
//		
		Double notaMedia = sumaNotas/numAlumnos;
		System.out.println("La nota media de los " + numAlumnos + " alumnos es: " + notaMedia);
		
		if(notaMedia>=9) {
			System.out.println("¡Excelente rendimiento!");
		}else if(notaMedia>=7) {
			System.out.println("Buen rendimiento.");
		}else if(notaMedia>=5) {
			System.out.println("Rendimiento promedio.");
		}else {
			System.out.println("Rendimiento insuficiente.");
		}
		
	}

}
