package es.cursojava.hibernate.unoauno;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import es.cursojava.utiles.HibernateUtil;
import es.cursojava.utiles.Utilidades;

public class Main {
    private static Session session = HibernateUtil.getSession();

    public static void main(String[] args) {
        
        //insertarUsuario();

        //consultarUsuarios();

        //consultarDirecciones();

        Usuario u = consultarUsuarioPorDireccionID(1L);
        System.out.println(u.getNombre() + " " + u.getDireccion().getCalle() + " " + u.getDireccion().getCiudad());
   
        session.close();
    }

    private static void insertarUsuario() {
        
        String nombre = Utilidades.pideDatoCadena("Nombre del usuario: ");
        String calle = Utilidades.pideDatoCadena("Calel del usuario: ");
        String ciudad = Utilidades.pideDatoCadena("Ciudad del usuario: ");

        Direccion direccion = new Direccion(calle, ciudad);
        Usuario usuario = new Usuario(nombre, direccion);
       
        Transaction tx = session.beginTransaction();
        session.persist(usuario);
        tx.commit();
        System.out.println("Usuario insertado.");
        
    }

    private static void consultarUsuarios() {
        List<Usuario> usuarios = session.createQuery("from Usuario", Usuario.class).getResultList();

        for (Usuario usuario : usuarios) {
            System.out.println("Usuario: " + usuario.getNombre() 
                                + ", Direccion: " + usuario.getDireccion().getCalle() 
                                + ", Ciudad: " + usuario.getDireccion().getCiudad());
        }
    }

    private static void consultarDirecciones() {
        List<Direccion> direcciones = session.createQuery("from Direccion", Direccion.class).getResultList();

        for (Direccion direccion : direcciones) {
            System.out.println("Direccion: " + direccion.getCalle() 
                                + ", Ciudad: " + direccion.getCiudad() 
                                + ", Usuario: " + direccion.getUsuario().getNombre());
        }
    }

    private static Usuario consultarUsuarioPorDireccionID(Long id) {
        Direccion d = session.find(Direccion.class, id);
        
        return d.getUsuario();
    }

    private static Usuario consultarUsuarioPorDireccionIDHQL(Long id) {
        String queryHql = "from Usuaurio u where u.direccion.id = :idDireccion";

        Query<Usuario> query = session.createQuery(queryHql, Usuario.class);
        query.setParameter("idDireccion", id).getSingleResult();    // Si no hay resultado lanza una excepción
        Usuario usuario = query.uniqueResult();  // Si hay mas de un resultado lanza una excepción

        return usuario;
    }
}
