package es.cursojava.inicio.arrays.ejercicios;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        
//    	Preguntar cuantas aulas tiene un colegio, 
//    	Suponiendo que en cada aula caben 5 alumnos
//
//    	1. Pedir datos
//    		+ Por cada mesa vacía de un aula solicitar el nombre del alumno
//    	2. Mostrar alumnos por aula
//    		+ Mostrar por cada aula los nombres de los alumnos
//    	3. Buscar alumno
//    		+ Pedir nombre del alumno a buscar
//    		+ Indicar en qué aula se encuentra
//    	4. Borrar alumnos
//    		+ Confirmar borrado
//    	5. Salir
//
//    	Selecciona una opción
    	
    	Scanner scan = new Scanner(System.in);
        System.out.println("¿Cuántas aulas tiene el colegio?");
        int numAulas = scan.nextInt();
        String[][] aulas = new String[numAulas][5];
        int opcion;
        final int OPCION_SALIR = 5;

        do {
            System.out.println("\n = = = MENÚ = = =");
            System.out.println("1. Introducir Datos de los Alumnos");
            System.out.println("2. Mostrar Alumnos por Aula");
            System.out.println("3. Buscar Alumno");
            System.out.println("4. Borrar Alumno");
            System.out.println("5. Salir");
            System.out.print("\nElige una opción: ");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < numAulas; i++) {
                        System.out.println("Aula " + (i + 1) + ":");
                        for (int j = 0; j < 5; j++) {
                            System.out.print("Introduce el nombre del alumno para la mesa " + (j + 1) + ": ");
                            aulas[i][j] = scan.nextLine();
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < numAulas; i++) {
                        System.out.println("Aula " + (i + 1) + ":");
                        for (int j = 0; j < 5; j++) {
                            System.out.println("Mesa " + (j + 1) + ": " + (aulas[i][j] == null ? "Vacío" : aulas[i][j]));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Introduce el nombre del alumno que deseas buscar: ");
                    String nombreBuscado = scan.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < numAulas; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (aulas[i][j] != null && aulas[i][j].equalsIgnoreCase(nombreBuscado)) {
                                System.out.println("El alumno " + nombreBuscado + " está en el aula " + (i + 1) + ", mesa " + (j + 1));
                                encontrado = true;
                                break;
                            }
                        }
                        if (encontrado) {
                        	break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("El alumno " + nombreBuscado + " no se encuentra en ninguna aula.");
                    }
                    break;

                case 4:
                    System.out.print("Introduce el nombre del alumno que deseas borrar: ");
                    String nombreBorrar = scan.nextLine();
                    boolean borrado = false;

                    for (int i = 0; i < numAulas; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (aulas[i][j] != null && aulas[i][j].equalsIgnoreCase(nombreBorrar)) {
                                aulas[i][j] = null;
                                System.out.println("El alumno " + nombreBorrar + " ha sido eliminado del aula " + (i + 1) + ", mesa " + (j + 1));
                                borrado = true;
                                break;
                            }
                        }
                    }

                    if (!borrado) {
                        System.out.println("El alumno " + nombreBorrar + " no se encuentra en ninguna aula.");
                    }
                    break;

                case 5:
                    System.out.println("\n- - - ¡Adiós! - - -");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        } while (opcion != OPCION_SALIR);

        scan.close();
    }
}

