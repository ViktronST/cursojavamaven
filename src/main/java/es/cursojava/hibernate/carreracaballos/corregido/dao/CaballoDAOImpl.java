package es.cursojava.hibernate.carreracaballos.corregido.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import es.cursojava.hibernate.carreracaballos.corregido.entities.CaballoCarrera;
import es.cursojava.utiles.HibernateUtil;

public class CaballoDAOImpl implements CaballoDAO {

    @Override
    public void insertar(CaballoCarrera caballo) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(caballo);
        tx.commit();
    }

    @Override
    public List<CaballoCarrera> obtenerTodos() {
        Session session = HibernateUtil.getSession();
        List<CaballoCarrera> lista = session.createQuery("from CaballoCarrera", CaballoCarrera.class).list();
        return lista;
    }

    @Override
    public List<CaballoCarrera> obtenerActivos() {
        Session session = HibernateUtil.getSession();
        String queryActivos = "from CaballoCarrera cc where cc.estaActivo =: activo";

        Query<CaballoCarrera> query = session.createQuery(queryActivos, CaballoCarrera.class);
        query.setParameter("activo", true);
        List<CaballoCarrera> lista = query.list();
        
        return lista;
    }

    @Override
    public void eliminar(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        // Eliminar el caballo de la base de datos según su id (primary key).
        CaballoCarrera c = session.find(CaballoCarrera.class, id);
        // Si el caballo existe, lo eliminamos.
        if (c != null) session.remove(c);
        tx.commit();
    }

    @Override
    public void actualizar(CaballoCarrera caballo) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(caballo);
        tx.commit();
    }
}
