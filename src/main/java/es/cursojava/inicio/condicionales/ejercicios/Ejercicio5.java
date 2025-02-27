package es.cursojava.inicio.condicionales.ejercicios;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		
//		Diseña un programa que clasifique a los empleados de una empresa en diferentes categorías según los siguientes criterios:
//
//			Edad del empleado:
//
//			Menor de 18 años: Clasificado como "Becario".
//			Entre 18 y 35 años (ambos inclusive): Dependerá del siguiente criterio.
//			Mayor de 35 años: Clasificado como "Veterano".
//			Nivel de experiencia (en años):
//
//			Menos de 1 año:
//			Si tiene menos de 18 años, clasificar como "Becario Junior".
//			Si tiene entre 18 y 35 años, clasificar como "Trainee".
//			Entre 1 y 5 años:
//			Si tiene entre 18 y 35 años, clasificar como "Junior".
//			Si tiene más de 35 años, clasificar como "Especialista".
//			Más de 5 años:
//			Si tiene entre 18 y 35 años, clasificar como "Senior".
//			Si tiene más de 35 años, clasificar como "Experto".
//			Sector de la empresa:
//
//			Si el empleado pertenece al departamento de TI y tiene más de 5 años de experiencia:
//			Independientemente de la edad, clasificar como "Tech Lead".
//			Si pertenece a Recursos Humanos y tiene entre 1 y 5 años de experiencia:
//			Clasificar como "Gestor de Personas".
//			Si pertenece al sector de Ventas y tiene menos de 1 año de experiencia:
//			Clasificar como "Asistente de Ventas".
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Departamento del empleado: ");
		String dep = scan.nextLine();
		
		System.out.print("Edad del empleado: ");
		int edad = scan.nextInt();
		
		System.out.print("Experiencia del empleado: ");
		int exp = scan.nextInt();
		
		String empleado = "";
		
		if(dep.equals("Ventas")) {
			empleado = "Asistente de ventas";
			System.out.println("El empleado de " + edad + " años de edad, con " + exp + " años de experiencia y perteneciente al departamento de " + dep + ", tiene el puesto de: " + empleado);
		}else if(dep.equals("Recursos Humanos")) {
			empleado = "Gestor de personas";
			System.out.println("El empleado de " + edad + " años de edad, con " + exp + " años de experiencia y perteneciente al departamento de " + dep + ", tiene el puesto de: " + empleado);
		}else if(dep.equals("TI")) {
			empleado = "Tech Lead";
			System.out.println("El empleado de " + edad + " años de edad, con " + exp + " años de experiencia y perteneciente al departamento de " + dep + ", tiene el puesto de: " + empleado);
		}else {
			if(exp<1) {
				if(edad<18) {
					empleado = "Becario Juniro";
				}else if (edad>=18 && edad<=35) {
					empleado = "Trainee";
				}else {
					System.out.println("Error");
				}
			}else if(exp>=1 && exp<=5) {
	            if(edad>=18 && edad<=35) {
					empleado = "Junior";
				}else if (edad>35) {
					empleado = "Especialista";
				}else {
					System.out.println("Error");
				}
			}else if(exp>5) {
	            if(edad>=18 && edad<=35) {
	            	empleado = "Senior";
				}else if (edad>35) {
					empleado = "Experto";
				}else {
					System.out.println("Error");
				}
			}else {
				System.out.println("Error");
			}
			System.out.println("El empleado de " + edad + " años de edad y con " + exp + " años de experiencia, tiene el puesto de: " + empleado);
		}
	}

}
