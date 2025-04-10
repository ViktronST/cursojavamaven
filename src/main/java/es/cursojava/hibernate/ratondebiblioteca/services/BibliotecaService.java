package es.cursojava.hibernate.ratondebiblioteca.services;

import java.util.ArrayList;
import java.util.List;

import es.cursojava.hibernate.ratondebiblioteca.dao.EstudianteDAO;
import es.cursojava.hibernate.ratondebiblioteca.dao.EstudianteDAOImpl;
import es.cursojava.hibernate.ratondebiblioteca.dto.CarnetBibliotecaDTO;
import es.cursojava.hibernate.ratondebiblioteca.dto.EstudianteDTO;
import es.cursojava.hibernate.ratondebiblioteca.entities.CarnetBiblioteca;
import es.cursojava.hibernate.ratondebiblioteca.entities.Estudiante;
import es.cursojava.hibernate.ratondebiblioteca.exceptions.RatonDeBibliotecaException;

public class BibliotecaService {

    private EstudianteDAO dao = new EstudianteDAOImpl();

    public void insertarEstudiante(EstudianteDTO estudianteDto, CarnetBibliotecaDTO carnetDto) {
        if (estudianteDto.getNombre() == null || estudianteDto.getNombre().isEmpty()) {
            throw new RatonDeBibliotecaException("Nombre no puede estar vacío");
        }
        if (carnetDto.getFechaEmision() == null || carnetDto.getFechaVencimiento() == null) {
            throw new RatonDeBibliotecaException("Las fechas no pueden estar vacías");
        }
        if (carnetDto.getFechaEmision().after(carnetDto.getFechaVencimiento())) {
            throw new RatonDeBibliotecaException("La fecha de emisión no puede ser posterior a la fecha de vencimiento");
        }
        Estudiante estudiante = new Estudiante(estudianteDto.getNombre());
        estudiante.setCarnetBiblioteca(new CarnetBiblioteca(carnetDto.getFechaEmision(), carnetDto.getFechaVencimiento()));
        dao.insertar(estudiante);
    }

    public void insertarCarnetBiblioteca(EstudianteDTO estudianteDto) {
        if (estudianteDto.getNombre() == null) {
            throw new RatonDeBibliotecaException("ID no puede estar vacío");
        }
        Estudiante estudiante = dao.obtenerPorNombre(estudianteDto.getNombre());
        if (estudiante == null) {
            throw new RatonDeBibliotecaException("Estudiante no encontrado");
        }
    }

    public List<EstudianteDTO> obtenerEstudiantes() {
        List<Estudiante> estudiantes = dao.obtenerTodos();
        return generaEstudianteDTO(estudiantes);
    }

    private List<EstudianteDTO> generaEstudianteDTO(List<Estudiante> estudiantes) {
        List<EstudianteDTO> dtos = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            dtos.add(new EstudianteDTO(e.getNombre()));
        }
        return dtos;
    }
}
