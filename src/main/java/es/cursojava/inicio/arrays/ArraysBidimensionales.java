package es.cursojava.inicio.arrays;

public class ArraysBidimensionales {

	public static void main(String[] args) {
		
		int[][] numeros = new int [2][4];           //El primer Array nos muestra el num de filas y el segundo el num de columnas.
		
		for(int fila=0 ; fila<numeros.length ; fila++) {                     //numeros.length me da el numero de filas.
			for(int columna=0 ; columna<numeros[fila].length ; columna++) {  //numeros[fila].length me da el numero de columnas.
				System.out.println("["+fila+"]["+columna+"]: " + numeros[fila][columna]);
			}
		}
		
		int filas = 2;
		int columnas = 6;
		//int [][] numeros = new int [filas][columnas];
		
		for (int fila=0; fila<numeros.length ; fila++) {
			
			for (int columna=0 ; columna < numeros[fila].length   ; columna++) {
				System.out.println("["+fila+"]["+columna+"]: "+ numeros[fila][columna]);
			}
			
		}
		
		for ( int[] fila    :      numeros   ) {
			for ( int numero   :    fila ) {
				
			}
		}
		
		
		String [] colores = {"Rojo","Amarillo","Verde"};
		for (String string : colores) {
			
		}
	}

}
