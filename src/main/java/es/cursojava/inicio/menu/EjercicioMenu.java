package es.cursojava.inicio.menu;

import java.util.Scanner;

public class EjercicioMenu {
	public static void main(String[] args) {
		
//		Pintar menu mientras que el usuario no seleccione la opción 4
//
//		1. Pintar Cuadrado
//		2. Validar email
//		3. Añadir Alumno
//		4. Salir
//
//		Elige una opción
//
//
//		Si el usuario selecciona la opción 1
//			+ Vamos a preguntar por el tamaño del cuadrado:
//				Ejemplo: 5
//				* * * * *
//				*  		*
//				*       *
//				*       *
//				* * * * *
//				
//		Si el usuario selecciona la opción 2
//			+ Vamos a preguntar por un email:
//				-Debe tener solo una @
//				-No puede tener espacios en blanco
//				-Después de la @ tiene que haber al menos un punto
//				-Entre la @ y el primer punto después de la @ tiene que haber al menos 2 carcateres
//				-Después del último punto solo puede haber entre 2 y 6 caracter
		
		Scanner scan = new Scanner(System.in);
		
		int opcion = 0;
		final int OPCION_SALIR = 4;
		
		do {
			System.out.println("Bienvenido al Menú");
			System.out.println("1. Pintar Cuadrado");
			System.out.println("2. Validar email");
			System.out.println("3. Añadir alumno");
			System.out.println("4. Salir");
			System.out.print("\nElige una opción: ");
			scan = new Scanner(System.in);
			
			opcion = scan.nextInt();
			
			switch(opcion) {
			
				case 1: 
					System.out.println("- Has elegido la opcion " + opcion + ": Pintar cuadrado.");
					System.out.println("\n¿De que tamaño será el cuadrado?");
					scan = new Scanner(System.in);
					int tamanio = scan.nextInt();
					
					for(int fila=0 ; fila<tamanio ; fila++) {
						
						for(int columna=0 ; columna<tamanio ; columna++) {
							
							if(fila==0 || fila==tamanio-1 || columna==0 || columna==tamanio-1) {
								System.out.print(" * ");
							}else {
								System.out.print("   ");
							}
						}
						System.out.println();
					}
					break;
					
				case 2: 
					System.out.println("Has elegido la opcion " + opcion + ": Validar email.");
					System.out.println("\nIntroduce el email:");
					scan = new Scanner(System.in);
					String email = scan.nextLine();
					email = email.toLowerCase().trim(); // Se pueden ir concatenando...
					email = email.replace(" ", "");
					
					String error = "";
					
					if(email.contains(" ") || email.contains("\t")) {
						error += "Contiene uno o más espacios en blanco.\n";
					}
					
					if(!email.contains("@")) {
						error += "No tiene un @.\n";
						
					}else {
						
						if(email.indexOf("@")>email.lastIndexOf(".")) {
							error += "Tiene un que haber un punto después del @.\n";
							
						}else {
							
							String dominoCorreo = email.substring(email.indexOf("@")+1);
							
							if(dominoCorreo.indexOf(".")<2) {
								error += "Tiene que haber una separación de 2 o más carácteres entre el @ y el punto.\n";
							}
							
							 String subDominio = dominoCorreo.substring(dominoCorreo.lastIndexOf(".")+1);
							 
							 if(subDominio.length()<2 || subDominio.length()>6) {
								error += "Después del último punto, sólo puede haber entre 2 y 6 carácteres.\n";
							}
						}
						
					}
					
//					// Una forma de validar el @.
//					int contadorArrobas = 0;
//					for(int i=0 ; i<email.length() ; i++) {
//						char caracter = email.charAt(i);
//						if(caracter=='@') {
//							contadorArrobas++;
//						}
//					}
//					
//					if(contadorArrobas>1) {
//						error += "El email tiene más de un @.\n";
//					}
					
					// Otra forma de validar el @.
					if(email.indexOf("@")!=email.lastIndexOf("@")) {
						error += "Contiene uno o más @.\n";
					}
					
					if(email.indexOf("@")==-1) {
						error += "No contiene ningún @.\n";
					}
					
					System.out.println(error);
					
					if(error.isBlank()) {
						System.out.println("El email " + email + " es válido.\n");
					}else {
						System.out.println("El email " + email + " es incorrecto por:\n" + error);
					}
					
					break;
					
				case 3: 
					System.out.println("Has elegido la opcion " + opcion + ": Añadir alumno.");
					break;
					
				case 4: 
					System.out.println("= = = Adiós! = = =");
					break;
					
				default: 
					System.out.println("- Opción Incorrecta -");
			}
			
		}while(opcion!=OPCION_SALIR);

	}

}
