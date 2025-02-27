package es.cursojava.inicio.arrays.ejercicios;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
	
//		Ahoracado
//		En un array guardar una palabra. (Cada letra en una posición del array)
//		El usuario tendrá 6 vidas.
//		Empieza el juego
//			+ Preguntar al usuario por las letras. (Se le preguntará hasta que acierte o se quede sin vidas)
//				+ Si acierta una letra mostrar las letras descubiertas
//				+ Si no acierta, se le indica que ha fallado y se le quita una vida
//			+ Si acierta la palabra entera antes de perder todas las vidas habrá ganado
//			+ Si pierde todas las vidas sin acertar la palabra habrá perdido
		
		String[] palabras = {"destornillador","monitor","pirata","murciélago","metamorfosis"};
		
		int random = (int)(Math.random()*5);
		String palabraJuego = palabras[random];
		
		String[] palabraOculta = palabraJuego.split("");
		System.out.println(palabraJuego);               //Nos muestra la palabra.
		System.out.println(palabraOculta.length); 	    //Nos muestra la longitud de la palabra.
		
		int vidas = 6;
		String letraPropuesta = "";                		//Letras guardadas.
		//int contadorAciertos = 0;
		
		do {
			//boolean palabraAcertada = (contadorAciertos==palabraOculta.length);
			boolean palabraAcertada = true;
			for(String letra : palabraOculta) {         //Recorremos todo el Array (la palabra)
				if(letraPropuesta.contains(letra)) {    //Condición por si la letra propuesta coincide con la palbra oculta.
					System.out.print(letra + " ");      //Si cincide se escribirá la letra.
				}else {
					palabraAcertada = false;
					System.out.print("_ ");				//Si no coincide no se pintará la letra.
				}
			}
			
			if(palabraAcertada) {                       //Condicion para cuando el bucle no entra por el else.
				System.out.println("\n= = = ¡HAS GANADO! = = =");
				break;
			}
			
			System.out.print("\nIntroduce una letra:");
			Scanner scan = new Scanner(System.in);
			String letraIntroducida = scan.nextLine();
			letraPropuesta += letraIntroducida;
			
			boolean acierto = false;                           //Creamos un boolean para los aciertos
			for(String letra : palabraOculta) {
				if(!letra.equals(letraIntroducida)) {
					//contadorAciertos++;
					acierto = true;
				}
			}
			
			if(!acierto) {
				System.out.println("La letra " + letraIntroducida + " no es correcta.");
				vidas--;
			}
			
			System.out.println("Te quedan " + vidas + " vidas.");
			
			if(vidas==0) {
				System.out.println("Te has quedado sin vidas. Has perdido...");
			}
			
		}while(vidas>0); //while(vidas>0 && contadorAciertos<palabraOculta.length);
		
	}

}
