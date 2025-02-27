package es.cursojava.inicio.condicionales.ejercicios;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
	
//		Herramienta para calcular el precio de una llamada
//		Cuando se realiza una llamada, el cobro es por el tiempo que esta dura, 
//		de tal forma que:
//
//		+ los primeros cinco minutos cuestan 1€, 
//		+ los siguientes 3 minutos, 80 céntimos, 
//		+ los siguientes dos minutos a 70 céntimos 
//		+ y a partir del décimo minuto, 50 céntimos cada minuto.
//
//		Se carga un impuesto del 3% cuando es domingo, 
//		y si es otro día, 
//			en turno de mañana 15% (6-12)
//			y en turno de tarde 10%. (12-23)
//			y en turno de noche -10%. (23-6)
//
//		Solicitar tiempo de llamada, dia de la semana y hora y calcular el coste de la llamada
//
//
//		Acciones:
//		Crear una condición que indique que mientras la cantidad de minutos sea mayor a 0 y menor a 5 el coste sea 1 euro. 
//		Crear una condición que indique que si la llamada dura más de 5 minutos y menos de 8, el costo de los minutos 6, 7 y 8 sea de 80 céntimos.
//		Crear una condición que indique que si la llamada dura más de 8 minutos y menos y hasta 10, el costo de los minutos 9 y 10 sea de 70 céntimos.
//		Crear una condición que indique que si la llamada dura más de 10 minutos cada minuto valga 50 céntimos.
//		Crear una condición que indique que si la llamada se hace el día domingo la llamada tenga un impuesto derl 3%
//		Crear una condición que indique que si la llamada se hace en un día diferente al domingo se aplique:
//		15% turno de 06:00am a 12:00m; 10% turno de 12:00m a 23:00pm; -10% turno de 23:00am a 05:59am; 

		
//		Scanner scan = new Scanner(System.in);
		
//		double suma = 0;
//		
//		System.out.println("¿Cuánto ha durado la llamada?");
//		int min = scan.nextInt();
//		int minextra;
//		
//		if(min>10) {
//			suma = (5 + (0.8*3) + (0.7*2));
//			minextra = min-10;
//			suma = suma + (minextra*0.5);
//		}else if(min>8) {
//			suma = (5 + (0.8*3));
//			minextra = min-8;
//			suma = suma + (minextra*0.7);
//		}else if (min>5) {
//			suma = 5;
//			minextra = min-5;
//			suma = suma + (minextra*0.8);
//		}else if(min>0) {
//			suma = min;
//		}else {
//			System.out.println("Introduce un número válido");
//		}
//		
//		suma = Math.round(suma*100.00)/100.00;
//		
//		System.out.println("La llamada ha durado " + min + " minutos y tiene un costo de " + suma + "€.");
		
		int minLlamada = 10;
		double precioLlamada = 0;
		String dia = "Martes";
		int hora = 5;
		
		if(minLlamada>0 && minLlamada<=5) {
			precioLlamada++;
			//precioLlamada+=1;
			//precioLlamada = precioLlamada + 1;
		}else if(minLlamada>5 && minLlamada<=8) {
			precioLlamada+=1.8;
		}else if(minLlamada>8 && minLlamada<=10) {
			precioLlamada+=2.5;
		}else if(minLlamada>10) {
			precioLlamada+= (minLlamada-10)*0.5;
		}else {
			System.out.println("Introduce un número correcto.");
		}
		
		System.out.println("El precio de la llamada total es " + precioLlamada + "€.");
		
		double impuesto = 0.0;
		
		if(dia.equalsIgnoreCase("domingo")) {
			System.out.println("Es domingo.");
			impuesto = precioLlamada*3/100;
		}else {
			if(hora>=6 && hora<12) {
				impuesto = precioLlamada*15/100;
			}else if(hora>=12 && hora<23) {
				impuesto = precioLlamada*10/100;
			}else {
				impuesto = -precioLlamada*10/100;
			}
		}
		
		System.out.println("Impuesto: " + impuesto);
		System.out.println("Total a pagar por " + minLlamada + " minutos " + (precioLlamada+impuesto));
		
        // OPERADOR TERCIARIO EXPLICACION
//		String texto = "";
//		if(minLlamada==1) {
//			texto = "minuto";
//		}else {
//			texto = "minuto";
//		}
//		System.out.println(texto);
//		
		// OPERADOR TERCIARIO CON UN BOOLEAN
//		String textoTernario = (minLlamada==1) ? "minuto" : "minutos" ;
		// OPERADOR TERCIARIO CON DOS BOOLEAN
//		String textoTernario2 = (minLlamada==1) ? "minuto" : (minLlamada==2) ? "minutos" : "minutoss" ;
//		System.out.println(textoTernario);
	}
}
