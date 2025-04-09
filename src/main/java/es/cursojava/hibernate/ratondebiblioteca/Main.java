package es.cursojava.hibernate.ratondebiblioteca;

import es.cursojava.hibernate.ratondebiblioteca.front.RatonDeBibliotecaFront;

public class Main {
    public static void main(String[] args) {
        RatonDeBibliotecaFront front = new RatonDeBibliotecaFront("Raton de Biblioteca 1");
        front.iniciarMenuBiblioteca();
    }
}
