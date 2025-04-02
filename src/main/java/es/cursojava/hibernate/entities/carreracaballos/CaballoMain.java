package es.cursojava.hibernate.entities.carreracaballos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.utiles.HibernateUtil;
import es.cursojava.utiles.UtilidadesHibernate;

public class CaballoMain {
    public static void main(String[] args) {
        CaballoMain main = new CaballoMain();
        //main.iniciarCaballos2();
        main.iniciarCaballosValidos();
        
    }

    // ========================= PARTE 1 =========================
    private void iniciarCaballos() {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure() // Carga hibernate.cfg.xml
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            System.out.println(session);
            
            CaballoCarrera c1 = new CaballoCarrera("Spirit", 12, 75, -7, 6.7, true);
            CaballoCarrera c2 = new CaballoCarrera("Rocinante", 30, 80, 10, 9.9, false);
            CaballoCarrera c3 = new CaballoCarrera("El Caballo Blanco de Santiago", 25, 60, 5, 7.2, false);
            CaballoCarrera c4 = new CaballoCarrera("Ramona", 15, 63, 11, 10, true);
            CaballoCarrera c5 = new CaballoCarrera("El Tullido", 1, 50, 1, 3.1, true);

            session.persist(c1);
            session.persist(c2);
            session.persist(c3);
            session.persist(c4);
            session.persist(c5);
    
            tx.commit();

        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private void iniciarCaballos2() {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            System.out.println(session);
            
            CaballoCarrera c1 = new CaballoCarrera("Spirit", 12, 75, -7, 6.7, true);
            CaballoCarrera c2 = new CaballoCarrera("Rocinante", 30, 80, 10, 9.9, false);
            CaballoCarrera c3 = new CaballoCarrera("El Caballo Blanco de Santiago", 25, 60, 5, 7.2, false);
            CaballoCarrera c4 = new CaballoCarrera("Ramona", 15, 63, 11, 10, true);
            CaballoCarrera c5 = new CaballoCarrera("El Tullido", 1, 50, 1, 3.1, true);

            session.persist(c1);
            session.persist(c2);
            session.persist(c3);
            session.persist(c4);
            session.persist(c5);
    
            tx.commit();

        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // ========================= PARTE 2 =========================
    private void iniciarCaballosValidos() {
        List<CaballoCarrera> caballos = new ArrayList<>();

        CaballoCarrera c1 = new CaballoCarrera("Spirit", 12, 75, -7, 6.7, true); 
        CaballoCarrera c2 = new CaballoCarrera("Rocinante", 30, 80, 10, 9.9, false);
        CaballoCarrera c3 = new CaballoCarrera("El Caballo Blanco de Santiago", 225, 60, 5, 7.2, false);
        CaballoCarrera c4 = new CaballoCarrera("Ramona", 15, 63, 11, 10, true);
        CaballoCarrera c5 = new CaballoCarrera("El Tullido", 1, 50, 1, 3.1, true);

        caballos.add(c1);
        caballos.add(c2);
        caballos.add(c3);
        caballos.add(c4);
        caballos.add(c5);

        ServicioCaballo caballoService = new ServicioCaballo();

        List<CaballoCarrera> caballosValidos = caballoService.filtrarCaballosValidos(caballos);

        try (Session session = UtilidadesHibernate.getSession()) {
            Transaction tx = session.beginTransaction();

            for (CaballoCarrera caballo : caballosValidos) {
                session.persist(caballo);
            }

            tx.commit();
            System.out.println("Caballos insertados correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar caballos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            UtilidadesHibernate.cerrarSessionFactory();
        }
    }

    private void iniciarCaballosValidos2() {
        Session session = UtilidadesHibernate.getSession();

        CaballoCarrera c1 = new CaballoCarrera("Spirit", 12, 75, -7, 6.7, true); 
        CaballoCarrera c2 = new CaballoCarrera("Rocinante", 30, 80, 10, 9.9, false);
        CaballoCarrera c3 = new CaballoCarrera("El Caballo Blanco de Santiago", 225, 60, 5, 7.2, false);
        CaballoCarrera c4 = new CaballoCarrera("Ramona", 15, 63, 11, 10, true);
        CaballoCarrera c5 = new CaballoCarrera("El Tullido", 1, 50, 1, 3.1, true);

        List<CaballoCarrera> caballos = Arrays.asList(c1, c2, c3, c4, c5);

        for (CaballoCarrera caballo : caballos) {
            Transaction tx = session.beginTransaction();

            try {
                System.out.println("Insertando caballo: " + caballo.getNombre());
                session.persist(caballo);
                tx.commit();

            } catch (Exception e) {
                tx.rollback();
                System.err.println("Error al insertar caballos: " + e.getMessage());
                e.printStackTrace();
            }   
        }
        System.out.println("Caballos insertados correctamente.");
    }
}
