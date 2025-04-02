package es.cursojava.hibernate.entities.carreracaballos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import es.cursojava.hibernate.entities.carreracaballos.CaballoCarrera;
import es.cursojava.hibernate.entities.carreracaballos.excepciones.AgeException;
import es.cursojava.hibernate.entities.carreracaballos.excepciones.ExperienceException;
import es.cursojava.hibernate.entities.carreracaballos.excepciones.SpeedException;
import es.cursojava.hibernate.entities.carreracaballos.excepciones.WinsException;

public class CaballoMain {
    public static void main(String[] args) {
        
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure() // Carga hibernate.cfg.xml
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            System.out.println(session);
            
            CaballoCarrera c1 = new CaballoCarrera("Spirit", 12, 200, 7, 6.7, true);
            CaballoCarrera c2 = new CaballoCarrera("Rocinante", 30, 80, 10, 9.9, false);
            CaballoCarrera c3 = new CaballoCarrera("El Caballo Blanco de Santiago", 25, 120, 5, 7.2, false);
            CaballoCarrera c4 = new CaballoCarrera("Ramona", 15, 220, 11, 10, true);
            CaballoCarrera c5 = new CaballoCarrera("El Tullido", 2, 180, 1, 3.1, true);

            session.persist(c1);
            session.persist(c2);
            session.persist(c3);
            session.persist(c4);
            session.persist(c5);
    
            tx.commit();

        } catch (AgeException | ExperienceException | SpeedException | WinsException ex) {
            System.err.println("Error al crear la SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
