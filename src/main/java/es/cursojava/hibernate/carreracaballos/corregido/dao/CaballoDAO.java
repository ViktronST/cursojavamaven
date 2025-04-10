package es.cursojava.hibernate.carreracaballos.corregido.dao;

import java.util.List;

import es.cursojava.hibernate.carreracaballos.corregido.entities.CaballoCarrera;

public interface CaballoDAO {
    void insertar(CaballoCarrera caballo);
    List<CaballoCarrera> obtenerTodos();
    List<CaballoCarrera> obtenerActivos();
    void eliminar(Long id);
    void actualizar(CaballoCarrera caballo);
}