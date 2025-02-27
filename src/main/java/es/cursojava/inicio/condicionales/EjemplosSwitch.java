package es.cursojava.inicio.condicionales;

public class EjemplosSwitch {
	public static void main(String[] args) {
		
		int nota = 7;
		
		switch(nota) {
		 case 0: 
		 case 1: 
		 case 2: 
		 case 3: 
		 case 4: System.out.print("Suspenso");break;
		 case 5: 
		 case 6: System.out.print("Aprobado");break;
		 case 7: 
		 case 8: System.out.print("Notable");break;
		 case 9: 
		 case 10: System.out.print("Sobresaliente");break;
		 default: System.out.print("Nota incorrecta");break;
		}
	}

}
