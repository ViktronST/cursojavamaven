package es.cursojava.inicio.pruebas;

import java.util.Scanner;

public class pruebas2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Preguntar cuántas aulas tiene el colegio
        System.out.println("¿Cuántas aulas tiene el colegio?");
        int numAulas = scan.nextInt();

        // Crear un array bidimensional para almacenar los nombres de los alumnos
        String[][] aulas = new String[numAulas][5];

        int opcion;
        final int OPCION_SALIR = 5;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Introducir Datos de los Alumnos");
            System.out.println("2. Mostrar Alumnos por Aula");
            System.out.println("3. Buscar Alumno");
            System.out.println("4. Borrar Alumno");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scan.nextInt();
            scan.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Introducir datos de los alumnos
                    for (int i = 0; i < numAulas; i++) {
                        System.out.println("Aula " + (i + 1) + ":");
                        for (int j = 0; j < 5; j++) {
                            System.out.print("Introduce el nombre del alumno para la mesa " + (j + 1) + ": ");
                            aulas[i][j] = scan.nextLine();
                        }
                    }
                    break;

                case 2:
                    // Mostrar alumnos por aula
                    for (int i = 0; i < numAulas; i++) {
                        System.out.println("Aula " + (i + 1) + ":");
                        for (int j = 0; j < 5; j++) {
                            System.out.println("Mesa " + (j + 1) + ": " + (aulas[i][j] == null ? "Vacío" : aulas[i][j]));
                        }
                    }
                    break;

                case 3:
                    // Buscar alumno
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
                        if (encontrado) break;
                    }

                    if (!encontrado) {
                        System.out.println("El alumno " + nombreBuscado + " no se encuentra en ninguna aula.");
                    }
                    break;

                case 4:
                    // Borrar un alumno específico
                    System.out.print("Introduce el nombre del alumno que deseas borrar: ");
                    String nombreBorrar = scan.nextLine();
                    boolean borrado = false;

                    for (int i = 0; i < numAulas; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (aulas[i][j] != null && aulas[i][j].equalsIgnoreCase(nombreBorrar)) {
                                aulas[i][j] = null; // Eliminar al alumno
                                System.out.println("El alumno " + nombreBorrar + " ha sido eliminado del aula " + (i + 1) + ", mesa " + (j + 1));
                                borrado = true;
                                break;
                            }
                        }
                        if (borrado) break;
                    }

                    if (!borrado) {
                        System.out.println("El alumno " + nombreBorrar + " no se encuentra en ninguna aula.");
                    }
                    break;

                case 5:
                    System.out.println("¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        } while (opcion != OPCION_SALIR);

        scan.close();
    }
}


