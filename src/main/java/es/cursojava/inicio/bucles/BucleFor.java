package es.cursojava.inicio.bucles;

public class BucleFor {
	public static void main(String[] args) {
		
		//Primero declaramos las variables dentro del for.
		//Segundo declaramos la condición que queremos que se cumpla justo después.
		//Tercero como aumenta la variable según cada interacción.
		
		//Ejemplo 1:
//		for(int i=0 ; i<10 ; i++ ) {
//			System.out.println(i);
//		}
//		System.out.println("Termina");
		
		//Ejemplo 2:
//		for(int i=1 ; i<=10 ; i++) {
//			System.out.println("5x" + i + "=" + (5*i));
//		}
//		System.out.println("Termina");
		
		//Ejemplo 3:
//		for(int i=1 ; i<=10 ; i++) {
//			int resultado = 5*i;
//			if(i%2==0) {
//				System.out.println("5x" + i + "=" + resultado);
//			}
//		}
//		System.out.println("Termina");
		
		
		//Ejemplo 4: Instrucción continue
//		for(int i=0 ; i<10 ; i++) {
//			//System.out.println("Entra " + i);
//			if(i%2==0) {
//				continue;
//			}
//			//System.out.println("Pasa");
//			System.out.println(i);
//		}
		
		//Ejemplo 5: Instrucción break
		for(int i=0 ; i<10 ; i++) {
			//System.out.println("Entra " + i);
			if(i%2!=0) {
				break;
			}
			//System.out.println("Pasa");
			System.out.println(i);
		}
	}

}
