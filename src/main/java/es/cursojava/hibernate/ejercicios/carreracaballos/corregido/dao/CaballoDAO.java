package es.cursojava.hibernate.ejercicios.carreracaballos.corregido.dao;

import java.util.List;

import es.cursojava.hibernate.ejercicios.carreracaballos.corregido.dto.CaballoDTO;
import es.cursojava.hibernate.ejercicios.carreracaballos.corregido.entities.CaballoCarrera;

public interface CaballoDAO {
    void insertar(CaballoCarrera caballo);
    List<CaballoCarrera> obtenerTodos();
    List<CaballoCarrera> obtenerActivos();
    void eliminar(Long id);
    void actualizar(CaballoCarrera caballo);
    CaballoDTO obtenerJinete (long caballoId);
    CaballoCarrera getCaballoPorId(long id);
    List<CaballoCarrera> obtenerCaballosPorNacionalidadJinete(String nacionalidad);
}