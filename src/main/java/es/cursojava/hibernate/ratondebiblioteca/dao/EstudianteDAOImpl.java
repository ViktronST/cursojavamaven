package es.cursojava.hibernate.ratondebiblioteca.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.hibernate.ratondebiblioteca.entities.Estudiante;
import es.cursojava.utiles.HibernateUtil;

public class EstudianteDAOImpl implements EstudianteDAO {
    
    @Override
    public void insertar(Estudiante estudiante) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(estudiante);
        tx.commit();
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        Session session = HibernateUtil.getSession();
        List<Estudiante> listaEstudiantes = session.createQuery("from Estudiante", Estudiante.class).list();
        return listaEstudiantes;
    }

}
