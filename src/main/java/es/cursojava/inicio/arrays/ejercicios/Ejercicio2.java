package es.cursojava.inicio.arrays.ejercicios;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		//Meter los valores 4,8,15,16,23,42 en un array.
		//Mostrar todos los números.
		//Mostrar la media de los valores.
		//Mostrar el número mayor y el número menor.
		
		int[] numeros = {4,8,15,16,23,42};
		
	//Mostrar todos los números.
		for(int i=0 ; i<numeros.length ; i++) {
			System.out.println(numeros[i]);
		}
		
//		for(int numero : numeros) {
//			System.out.println(numero);
//		}
		
	//Mostrar la media de los valores.
		int suma = 0;
		int media = suma / numeros.length;
		
		for(int numero : numeros) {
			suma += numero;
		}
		System.out.println("La media es: " + media); //Se podría hacer eliminando el (int media) y sustituir en el syso por (suma / numeros.length)
		
	//Mostrar el número mayor y el número menor.
		int mayor = numeros[0];
		int menor = numeros[0];
		
		for(int numero : numeros) {
			if(numero > mayor) {
				mayor = numero;
			}
			if(numero < menor) {
				menor = numero;
			}
		}
		System.out.println("El menor número es: " + menor);
		System.out.println("El mayor número es: " + mayor);
		
//		int numMayor = numeros[0];
//		int numMenor = numeros[0];     //int numMenor = Integer.MAX_VALUE;

//		for (int i=0 ; i<numeros.length ; i++) {
//			if(numeros[i]>numMayor) {
//				numMayor = numeros[i];
//			}
//			if(numeros[i]<numMenor) {
//				numMenor = numeros[i];
//			}
//		}
//		System.out.println("El menor número es: " + numMenor);
//		System.out.println("El mayor número es: " + numMayor);
		
	}

}
