package es.cursojava.inicio.bucles.ejercicios;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		
//		Solicitar un numero:
//		Si el numero es par, se divide entre dos
//		Si es impar se multiplicar por 3 y se le suma 1
//		Se repite hasta que el valor del numero es 1
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Introduce un número: ");
		int num = scan.nextInt();
		
		boolean esPar = num%2==0;
		do {
			if(esPar) {
				num = num/2;
			}else {
				num = num*3+1;
			}
			System.out.println(num);
		}while (num!=1);
		
//		do {
//			if(num%2==0) {
//				num = num/2;
//				System.out.println(num);
//			}else if(num%2!=0) {
//				num = (num*3) + 1;
//				System.out.println(num);
//			}else {
//				System.out.println("FIN"); //Esta parte no es necerias ya que si un num no es par, si o si, será impar.
//			}
//		}while(num!=1);
		
		scan.close();

	}

}
