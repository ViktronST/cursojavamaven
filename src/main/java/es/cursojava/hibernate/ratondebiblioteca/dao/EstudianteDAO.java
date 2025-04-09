package es.cursojava.hibernate.ratondebiblioteca.dao;

import java.util.List;

import es.cursojava.hibernate.ratondebiblioteca.entities.Estudiante;

public interface EstudianteDAO {
    void insertar(Estudiante estudiante);
    List<Estudiante> obtenerTodos();
    Estudiante obtenerPorNombre(String nombre);
}
