package es.cursojava.inicio.string;

public class FuncionesString {

	public static void main(String[] args) {
		
		String mensaje = "Hola qué tal?";
		char caracter = mensaje.charAt(0); //Nos dá el caracter en la posición que deseemos.
		System.out.println(caracter);
		
		System.out.println(mensaje.contains("Hola")); //Indica si el mensaje contiene o no la letra indicada (cuidado con mayus y minus).
		
		System.out.println(mensaje.endsWith("tal?")); //Indica si el mensaje termina con dicho término o palabra.
		
		System.out.println(mensaje.startsWith("Hola")); //Indica si el mensaje empieza con dicho término o palabra.
		
		System.out.println(mensaje.indexOf("a")); //Nos dá el puesto del primer dato que sea igual al que hemos dado (siempre empieza desde la izq).
		
		System.out.println(mensaje.lastIndexOf("a")); //Nos dá el puesto primer dato que sea igual al que hemos dado (empiza por la derecha).
		//Si le damos un dato que no esté presente, este nos contestará con un -1.
		
		String msg2 = "      ";
		String mensaj = msg2.trim(); //Elimina los espacios en blanco que tengamos del caracter a la izq y derech.
		                    //Sin ningun caracter elimina todos los espacios en blanco.
		                    //Si hay una frase no elimina los espacios entre medias.
		
		System.out.println(msg2.isBlank()); //Sin carácteres, los espacios no cuentan.
		System.out.println(msg2.isEmpty()); //Indica si está vació, los espacios si cuentan.
		
		System.out.println(mensaj.length()); //Indica lo largo que es el mensaje (su tamaño).
		System.out.println(msg2.length());
		
		System.out.println(mensaje.substring(4)); //Devuelve la posición indica hasta el final del mensaje.
		System.out.println(mensaje.substring(4,8)); //Devuelve solo el mensaje entre las dos posiciones.
		
		//***** NUEVO ***** (12/12/2024)
		String textoOriginal = "reco;nocer";
		String[] datos = textoOriginal.split(";"); //Trocea desde el punto o caracter que le indiquemos.
		               //textoOriginal.split("")   //De esta forma separa los caracteres uno a uno.                       
		
		for (String string : datos) {
			System.out.println(string);
		}
		
		for(int i=0 ; i<datos.length/2 ; i++) {
			if(!datos[i].equals(datos[datos.length-1-i])) {
				System.out.println("No es palíndromo");
				break;
			}
		}
	}
}
