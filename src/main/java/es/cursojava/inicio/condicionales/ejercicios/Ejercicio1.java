package es.cursojava.inicio.condicionales.ejercicios;

public class Ejercicio1 {
	public static void main(String[] args) {
		
//		+ Crear paquete ejercicios dentro de condicionales
//		+ Declarar la variables asignatura de tipo String, nombreAlumno de tipo String y nota de tipo int 
//		+ Inicializar las variables con valores inventados
//		+ El resultado a mostrar sería: El alumno Juan en la asignatura Matemáticas tiene un Notable
//
//		0 <5 suspenso
//		5 <7 aprobado
//		7 <9 notable
//		9-10 sobresaliente
		
		String alumno = "Mario";
		String asignatura = "Lengua y Literatura";
		
		int nota = 8;
		
//		switch (nota){
//		case 0,1,2,3,4 -> System.out.print("El alumno " + alumno + " en la asignatura de " + asignatura + " tiene un Suspenso");
//		case 5,6 -> System.out.print("El alumno " + alumno + " en la asignatura de " + asignatura + " tiene un Bien");
//		case 7,8 -> System.out.print("El alumno " + alumno + " en la asignatura de " + asignatura + " tiene un Notable");
//		case 9,10 -> System.out.print("El alumno " + alumno + " en la asignatura de " + asignatura + " tiene un Sobresaliente");
//		default -> System.out.print("Nota incorrecta");
//		}
		
//	    boolean esSobresaliente = (nota>=9);
//		if(esSobresaliente) {
//			System.out.println("El alumno " + alumno + " en la asignatura de " + asignatura + " tiene un Sobresaliente");
//		}else if(nota>=7) {
//			System.out.println("El alumno " + alumno + " en la asignatura de " + asignatura + " tiene un Notable");
//		}else if(nota>=5) {
//			System.out.println("El alumno " + alumno + " en la asignatura de " + asignatura + " tiene un Bien");
//		}else {
//			System.out.println("El alumno " + alumno + " en la asignatura de " + asignatura + " tiene un Suspenso");
//		}
		
		String notaText = "";
		if(nota>=9) {
			notaText = "sobresaliente";
		}else if(nota>=7) {
			notaText = "notable";
		}else if(nota>=5) {
			notaText = "aprobado";
		}else {
			notaText = "suspenso";
		}
		
		System.out.println("El alumno " + alumno + " en la asignatura de " + asignatura + " tiene un " + notaText);
	}
}