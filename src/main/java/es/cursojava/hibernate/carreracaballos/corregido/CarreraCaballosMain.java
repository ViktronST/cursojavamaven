package es.cursojava.hibernate.carreracaballos.corregido;

import es.cursojava.hibernate.carreracaballos.corregido.front.CarreraCaballosFront;

public class CarreraCaballosMain {
    public static void main(String[] args) {
        CarreraCaballosFront front = new CarreraCaballosFront("Carrera 1");
        front.iniciaMenuCarrera();
    }
}
