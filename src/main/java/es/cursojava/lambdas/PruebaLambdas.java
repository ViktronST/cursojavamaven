package es.cursojava.lambdas;

public class PruebaLambdas {

	public static void main(String[] args) {
		
		// = = = = INTERFAZ COMPARABLE = = = =

		// El método no devulve nada, vamos a pintar la información por consola.
		Comparable compare = (text, num) -> System.out.println(text + " " + num);
		compare.pintaDatos("Texto", 5);

		Comparable compare2 = (text, num) -> {
			System.out.println(text + " " + num);
			int operacion = num * 2;
			System.out.println("Operación: " + operacion);
		};
		compare2.pintaDatos("Texto2", 10);

		// = = = = INTERFAZ SALUDOS = = = =

		Saludos saludar = () -> System.out.println("Hola desde una lambda" + Math.random());
		saludar.metodo1();

		Saludos saludar2 = () -> System.out.println("Adios desde una lambda" + Math.random());
		saludar2.metodo1();

		// = = = = INTERFAZ PRUEBA = = = =

		Prueba prueba = (a) -> {
			System.out.println("Hola desde una lambda" + a + Math.random());
		};
		prueba.metodo1("Prueba");

		// = = = = INTERFAZ OPERACION = = = =

		// Esto es lo que haríamos nosotros antes de las lambdas.
		// Operacion suma = new Suma();
		// suma.operar(2, 3);
		
		Operacion ope1 = (a,b) -> (int)Math.random();

		// Esta operacion sería lo mismo que la clase Suma, pero sin necesidad de crear una clase que implemente la interfaz Operacion.
		Operacion ope2 = (a,b) -> a+b;
		
		miOperacion(6,8,ope2);
		
		miOperacion(9,18, (f,g)-> f-g );
		
		miOperacion(9,18, (f,g) -> { 
						if (f>5) {
							f= f*4;
						}
						g=g+3;
						return f*g;
					});
		
//		System.out.println(ope.operar(2, 3));
//		ope = (a,b) -> a+b;
//		System.out.println(ope.operar(2, 3));

	}
	
	static void miOperacion (int valor1, int valor2, Operacion op) {
		int resultado = op.operar(valor1, valor2);
		System.out.println(resultado);
	}
	
	

}






