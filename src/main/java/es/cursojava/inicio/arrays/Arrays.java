package es.cursojava.inicio.arrays;

public class Arrays {

	public static void main(String[] args) { 
		
		//Ejemplos Arrays
		
		int[] numeros = new int[6];
		
		System.out.println(numeros[1]);  //Devuelve el numero en la posicion 1 que es 0.
		numeros[1] = 8;                  //Sustituye el valor del numero en la posición 1 por el valor 8.
		System.out.println(numeros[1]);  //Devuelve el numero en la posicion 1 que es 8.
		numeros[1] = 5; 				 //Sustituye el valor del numero en la posición 1 por el valor 5.
		numeros[1] = 7;  				 //Sustituye el valor del numero en la posición 1 por el valor 7.
		System.out.println(numeros[6]);  //Devuelve error ya que nos salimos del tamaño del Array.
		
		String[] colores = new String[2];
		System.out.println(colores[0]);  //Dará null, ya que las posición no estará apuntando a ningún String.
		                                 //Dará 0 si hablamos de un Int.
		
		//Crea un Array de colores
		//Declaro el array y le indeico que tiene tamaño 4.
//		String[] colores = new String[4];
		//Asigno valores a cada posición.
		colores[0]="Rojo";
		colores[1]="Verde";
		colores[2]="Azul";
		colores[3]="Amarillo";
		
		for(int i=0 ; i<colores.length ; i++) {
			System.out.println(colores[i]);
		}
		
		System.out.println(colores[0]);
		System.out.println(colores[1]);
		System.out.println(colores[2]);
		System.out.println(colores[3]);
		
		
		//Bucle foreach:
		//Tiene una separación por dos puntos (:).
		//Establecemos el elemento que queremos recorrer en el segundo espacio (el array).
		//En el primer espacio declararemos una variable la cual java irá recorriendo todos los valores.
		for( String color : colores ) {
			System.out.println("Color: " + color);
		}
		
		//Declaro e inicializo un array con dos valores directamente.
		String[] colores2 = {"Balnco","Negro"};
		
	}

}
