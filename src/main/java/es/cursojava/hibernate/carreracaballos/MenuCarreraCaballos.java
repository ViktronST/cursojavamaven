package es.cursojava.hibernate.carreracaballos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.utiles.Utilidades2;
import es.cursojava.utiles.UtilidadesHibernate;

public class MenuCarreraCaballos {
    public static void main(String[] args) {
        MenuCarreraCaballos menu = new MenuCarreraCaballos();
        menu.pintarMenu();
        menu.elegirOpcion();
    }

    private void pintarMenu()   {
        System.out.println(" = = = = Bienvenido al Menú de Carreras de Caballos = = = = ");
        Utilidades2.pintarMenu(new String[] { "1. Registrar Caballo", "2. Iniciar Carrera", "3. Salir" });
    }

    private void elegirOpcion() {
        int opcion = Utilidades2.pideDatoNumerico("Introduce una opción: ");
        switch (opcion) {
            case 1:
                opcion1();
                pintarMenu();
                elegirOpcion();
                break;

            case 2:
                opcion2();
                pintarMenu();
                elegirOpcion();
                break;

            case 3:
                opcion3();
                UtilidadesHibernate.cerrarSessionFactory();
                break;

            default:
                System.out.println("Opción no válida. Inténtalo de nuevo...");
                pintarMenu();
                elegirOpcion();
        }
    }

    private List<CaballoCarrera> opcion1() {
        System.out.println("Registrar Caballo");
        int numCaballos = Utilidades2.pideDatoNumerico("¿Cuántos caballos quieres registrar?: ");

        List<CaballoCarrera> caballos = new ArrayList<>();
        for (int i = 0; i < numCaballos; i++) {
            String nombre = Utilidades2.pideDatoCadena("Introduce el nombre del caballo: ");
            int edad = Utilidades2.pideDatoNumerico("Introduce la edad del caballo: ");
            double velocidadMaxima = Utilidades2.pideDatoDecimal("Introduce la velocidad del caballo: ");
            int numeroTriunfos = Utilidades2.pideDatoNumerico("Introduce el número de Triunfos del caballo: ");
            double experiencia = Utilidades2.pideDatoDecimal("Introduce la experiencia del caballo: ");
            boolean estaActivo = Utilidades2.pideDatoCadena("¿Está activo? (y/n): ").equalsIgnoreCase("y");
            
            CaballoCarrera caballo = new CaballoCarrera(nombre, edad, velocidadMaxima, numeroTriunfos, experiencia, estaActivo);
            caballos.add(caballo);
            System.out.println("Caballo creado: " + caballo);
        }

        try (Session session = UtilidadesHibernate.getSession()) {
            Transaction tx = session.beginTransaction();

            for (CaballoCarrera caballo : caballos) {
                session.persist(caballo);
            }

            tx.commit();
        } catch (Exception e) {
            System.err.println("Error al insertar caballos: " + e.getMessage());
            e.printStackTrace();
        } 

        System.out.println("Caballos registrados con éxito.");

        return caballos;
    }

    private void opcion2() {
        System.out.println("Iniciar Carrera");
        List<CaballoCarrera> listadoCaballos = obtenerCaballosRegistrados();

        if (listadoCaballos.isEmpty()) {
            System.out.println("No hay caballos válidos para iniciar la carrera.");
            return;
        }

        if (listadoCaballos.size() < 2) {
            System.out.println("No hay suficientes caballos activos para iniciar la carrera.");
        } else {
            System.out.println("Iniciando carrera...");
            double distanciaMeta = 1000.0;
            double distanciaRecorrida = 0.0;

            for (CaballoCarrera caballo : listadoCaballos) {
                int aleatorioRandom = (int) Math.random() * 50;
                int experienciaRandom = (int) (caballo.getExperiencia() * (Math.random() * 10));
                int edadRandom = (int) (caballo.getEdad() * (Math.random() * 10));

                if (caballo.isEstaActivo()) {
                    distanciaRecorrida = aleatorioRandom + experienciaRandom - edadRandom;
                    System.out.println(caballo.getNombre() + " ha recorrido " + distanciaRecorrida + " metros.");
                }

                if (distanciaRecorrida < 0) {
                    distanciaRecorrida = 1;
                }

                distanciaRecorrida++;
            }

            if (distanciaRecorrida >= distanciaMeta) {
                System.out.println("El " + listadoCaballos.get(0).getNombre() + " ha ganado la carrera!");
            } else {
                System.out.println("La carrera continúa...");
            }

            System.out.println("El caballo ganador es: " + listadoCaballos.get(0).getNombre() + " con una distancia de " + distanciaRecorrida + " metros.");
            System.out.println("La carrera ha terminado.");
        }

    }

    private List<CaballoCarrera> obtenerCaballosRegistrados() {
        List<CaballoCarrera> caballos = new ArrayList<>();
        try (Session session = UtilidadesHibernate.getSession()) {
            caballos = session.createQuery("FROM CaballoCarrera", CaballoCarrera.class).list();
        } catch (Exception e) {
            System.err.println("Error al obtener caballos registrados: " + e.getMessage());
            e.printStackTrace();
        }
        return caballos;
    }

    private void opcion3() {
        System.out.println("Salir");
    }
}

