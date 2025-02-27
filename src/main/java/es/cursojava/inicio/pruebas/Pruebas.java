package es.cursojava.inicio.pruebas;

import java.util.Scanner;

public class Pruebas {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int option;
		
		do {
			System.out.println("==== MENÚ ====");
			System.out.println("1. Pintar Triángulo");
			System.out.println("2. Validar Email");
			System.out.println("3. Añadir Alumno");
			System.out.println("4. Salir");
			option = scan.nextInt();
			scan.nextLine();
		    
			switch(option) {
				case 1:
					//Pintar un triángulo
					System.out.println("Dame la altura del árbol navideño: ");
					int altura = scan.nextInt();
					
					//Generar árbol de navidad
					for(int i=1 ; i<=altura ; i++) {
						for(int j=1 ; j<=altura-i ; j++) {		//Imprimir espacios en blanco
							System.out.print(" ");
						}
						for(int j=1; j<=(2*i-1); j++) {			//Imprimir asteriscos
							System.out.print("*");
						}
						System.out.println();					//Salto de línea
					}
					
					
//			        // Generar el triángulo invertido
//			        for (int i = altura; i >= 1; i--) {
//			            for (int j = 1; j <= i; j++) {
//			                System.out.print("*");
//			            }
//			            System.out.println(); // Salto de línea
//			        }
					
					break;
				case 2:
					System.out.println("Introduce el email a validar: ");
					String email = scan.nextLine().trim().toLowerCase();
					String errores = "";
					
					//Debe contener solo un @.
					int countArroba = 0;
					boolean valido = true;
					for(int i=0 ; i<email.length() ; i++) {
						if(email.charAt(i)=='@') {
							countArroba++;
						}
					}
					if(countArroba!=1) {
						errores+="Debe tener exactamente un @.\n";
						valido = false;
					}
					
					//No puede tener espacios en blanco.
					if(email.contains(" ")) {
						errores+="No debe tener espacios en blanco.\n";
						valido = false;
					}
					
					//Después del @ tiene que haber al menos un punto.
					int posicionArroba = email.indexOf("@");
					int posicionUltPunto = email.lastIndexOf(".");
					if(posicionUltPunto < posicionArroba || posicionUltPunto == -1) {
						errores+="Debe ver un punto después del @.\n";
						valido = false;
					}
					
					//Punto antes del @.
					int posicionAntesArroba = email.lastIndexOf(".", posicionArroba-1);
					if(posicionAntesArroba != -1 && posicionUltPunto > posicionArroba) {
						errores+="No puede haber un punto antes de la @.\n";
						valido = false;
					}
					
					//Entre el @ y el primer punto debe haber al menos 2 caracteres.
					if(posicionUltPunto > posicionArroba && posicionUltPunto - posicionArroba <= 2) {
						errores+="Debe haber 2 caracteres después del @ y antes del punto.\n";
						valido = false;
					}
					
					//Después del último punto solo puede haber entre 2 y 6 carácteres.
					int caracteresDespuesPunto = email.length() - posicionUltPunto -1;
					if(caracteresDespuesPunto < 2 || caracteresDespuesPunto > 6) {
						errores+= "Debe haber entre 2 y 6 caracteres";
						valido = false;
					}
					
					if(valido = true) {
						System.out.println("El correo es válido");
					}else {
						System.out.println("Correo inválido. Revisa los siguientes errores: " + errores);
					}
										
					break;
				case 3:
					System.out.println("Introduce un alumno.");
					break;
				case 4:
					System.out.println("Adiós!");
					break;
				default:
					System.out.println("Opción incorrecta.");
					break;
			}
		}while(option!=4);
		
	}

}
