package es.cursojava.hibernate.ejercicios.carreracaballos.corregido.services;

import java.util.ArrayList;
import java.util.List;

import es.cursojava.hibernate.ejercicios.carreracaballos.corregido.dao.CaballoDAO;
import es.cursojava.hibernate.ejercicios.carreracaballos.corregido.dao.CaballoDAOImpl;
import es.cursojava.hibernate.ejercicios.carreracaballos.corregido.dto.CaballoDTO;
import es.cursojava.hibernate.ejercicios.carreracaballos.corregido.entities.CaballoCarrera;
import es.cursojava.hibernate.ejercicios.carreracaballos.corregido.entities.Jinete;
import es.cursojava.hibernate.ejercicios.carreracaballos.corregido.exceptions.CaballoException;

public class CarreraService {

    private final int DISTANCIA = 1000;
    private CaballoDAO dao = new CaballoDAOImpl();

    public void insertarCaballo(CaballoDTO caballoDto) {
        if (caballoDto.getVelocidadMaxima() < 30 || caballoDto.getVelocidadMaxima() > 80) {
            throw new CaballoException("Velocidad no permitida 30-80" + caballoDto.getVelocidadMaxima());
        }

        Jinete jinete = new Jinete(caballoDto.getNombreJinete(), caballoDto.getNacionalidadJinete());
        CaballoCarrera caballo = new CaballoCarrera(
            caballoDto.getNombre(),
            caballoDto.getEdad(),
            caballoDto.getVelocidadMaxima(),
            caballoDto.getNumeroDeTriunfos(),
            caballoDto.getExperiencia(), 
            caballoDto.isActivo());
        caballo.setJinete(jinete);
        dao.insertar(caballo);
    }

    public List<CaballoDTO> obtenerCaballos(boolean activos) {
        List<CaballoCarrera> caballos = null;
        if (!activos){
            caballos = dao.obtenerTodos();
        }else{
            caballos = dao.obtenerActivos();
        }
        
        return generaDTO(caballos);
    }

    public CaballoDTO obtenerJineteCaballo(long idCaballo) {
        return dao.obtenerJinete(idCaballo);
    }

    public void simularCarrera(List<CaballoDTO> caballosDTO) {

        CaballoDTO caballoGanador = null;
        if (caballosDTO.size()>=2) {
            System.out.println("Empieza la carrera");

            do {
                for (CaballoDTO caballoDTO : caballosDTO) {
                    double avance = getAvance(caballoDTO);
                    caballoDTO.setAvance(caballoDTO.getAvance() + avance);

                    if (caballoDTO.getAvance() >= DISTANCIA) {
                        caballoGanador = caballoDTO;
                        System.out.println("El caballo " + caballoGanador.getNombre() + " ha ganado la carrera!");
                        break;
                    } else {
                        System.out.println("El caballo " + caballoDTO.getNombre() + " ha avanzado " + caballoDTO.getAvance() + " metros.");
                    }
                }

                // Tiempo de espera entre cada avance.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } while (caballoGanador==null);
        }
        
        
        if (caballosDTO.size()>=2){
            System.out.println("Empieza la carrera");
        }else{
            System.out.println("No hay suficientes caballos activos");
        }
    }

    private double getAvance(CaballoDTO caballoDTO) {
        double avance = (Math.random()*50) + caballoDTO.getVelocidadMaxima() * (Math.random()*10) + caballoDTO.getExperiencia() * 
                (Math.random()*10) - caballoDTO.getEdad() * (Math.random()*10);
        
        return avance<0?0:avance;   // Para controlar que no haya avance negativo.
    }

    private List<CaballoDTO> generaDTO (List<CaballoCarrera> caballos){
        List<CaballoDTO> dtos = new ArrayList<>();
        for (CaballoCarrera c : caballos) {
            dtos.add(new CaballoDTO(
                    c.getNombre(),
                    c.getEdad(),
                    c.getVelocidadMaxima(),
                    c.getNumeroTriunfos(),
                    c.getExperiencia(),
                    c.isEstaActivo()
            ));
        }
        return dtos;
    }

    public void eliminarCaballo(long id) {
        dao.eliminar(id);
    }

    public void actualizarJineteCaballo(Long idCaballo, CaballoDTO caballoDTO){
        //Obtengo el caballo a actualizar
        CaballoCarrera cc = dao.getCaballoPorId(idCaballo);

        //Genero el jinete a partir de la información del DTO
        Jinete jinete = new Jinete(caballoDTO.getNombreJinete(), caballoDTO.getNacionalidadJinete());

        //Asigno el nuevo jinete al caballo
        cc.setJinete(jinete);

        dao.actualizar(cc);
    }

    public List<CaballoCarrera> obtenerCaballosNacionalidadJinete(String nacionalidad) {
        return dao.obtenerCaballosPorNacionalidadJinete(nacionalidad);
    }
}
