package es.cursojava.inicio.string.ejercicios;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Escribe un programa que reciba un String y devuelva el texto invertido.
		
		String texto = "Hola";
		String invertir = "";
		
		for(int i=texto.length()-1 ; i>=0 ; i--) {
			//System.out.print(texto.charAt(i));
			invertir += texto.charAt(i);
		}
		System.out.print(invertir);
		
//		// Otra forma de hacerlo
//		for(int i=0; i<texto.length() ; i++) {
//			invertir = texto.charAt(i) + invertir;
//		}
//		System.out.println(invertir);
	}

}
