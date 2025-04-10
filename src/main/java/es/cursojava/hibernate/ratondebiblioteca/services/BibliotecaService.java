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
import es.cursojava.utiles.Utilidades2;

public class BibliotecaService {

    private EstudianteDAO dao = new EstudianteDAOImpl();

    public void insertarEstudiante(EstudianteDTO estudianteDto, CarnetBibliotecaDTO carnetDto) {
        if (estudianteDto.getEmail() == null || estudianteDto.getEmail().isBlank() || Utilidades2.validarEmail(estudianteDto.getEmail())) {
            
            if (estudianteDto.getNombre() == null || estudianteDto.getNombre().isEmpty()) {
                throw new RatonDeBibliotecaException("El nombre no puede estar vacío");
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

        }else {
            throw new RatonDeBibliotecaException("No, no, no... El email no es válido");
        }
        
        
    }

    public List<EstudianteDTO> obtenerEstudiantes() {
        List<Estudiante> estudiantes = dao.obtenerTodos();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en la base de datos.");
        } else {
            System.out.println("Lista de estudiantes:");
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante.getNombre() + " - " + estudiante.getCarnetBiblioteca().getFechaEmision() 
                                    + " - " + estudiante.getCarnetBiblioteca().getFechaVencimiento());
            }
        }
        return generaEstudianteDTO(estudiantes);
    }

    private List<EstudianteDTO> generaEstudianteDTO(List<Estudiante> estudiantes) {
        List<EstudianteDTO> dtos = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            dtos.add(new EstudianteDTO(e.getNombre()));
        }
        return dtos;
    }
    
    private EstudianteDTO generaEstudianteDTO(Estudiante estudiante) {
        return new EstudianteDTO(estudiante.getNombre(), estudiante.getApellidos(), estudiante.getEdad(), 
                estudiante.getDni(), estudiante.getEmail(), new CarnetBibliotecaDTO(estudiante.getCarnetBiblioteca().getFechaEmision(), 
                        estudiante.getCarnetBiblioteca().getFechaVencimiento()));
    }
}
