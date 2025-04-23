package es.cursojava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import es.cursojava.hibernate.entities.Persona;

public class HibernateMain {
    public static void main(String[] args) {

        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure() // Carga hibernate.cfg.xml
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            System.out.println(session);
            
            Persona p1 = new Persona("Ana", 25);
            // Persona p2 = new Persona("Luis", 30);
            // Persona p3 = new Persona("Samanta", 25);
            //Persona p4 = new Persona("Piter", "Smith", 25, "casado");
    
            session.persist(p1);
            // session.persist(p2);
            // session.persist(p3);
            //session.persist(p4);
    
            tx.commit();

        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
        
    }
}
