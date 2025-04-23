package es.cursojava.hibernate.ejercicios.ratondebiblioteca.dao;

import java.util.List;

import es.cursojava.hibernate.ejercicios.ratondebiblioteca.entities.Estudiante;

public interface EstudianteDAO {
    void insertar(Estudiante estudiante);
    List<Estudiante> obtenerTodos();
    Estudiante obtenerPorNombre(String nombre);
    void eliminar(Estudiante estudiante);
    void eliminar(Long id);
    void actualizar(Estudiante estudiante);
}
