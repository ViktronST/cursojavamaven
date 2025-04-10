package es.cursojava.hibernate.ratondebiblioteca.dto;

public class EstudianteDTO {
    private String nombre;
    private CarnetBibliotecaDTO carnetBibliotecaDTO;

    public EstudianteDTO(String nombre) {
        this.nombre = nombre;
    }

    public EstudianteDTO(String nombre, CarnetBibliotecaDTO carnetBibliotecaDTO) {
        this.nombre = nombre;
        this.carnetBibliotecaDTO = carnetBibliotecaDTO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CarnetBibliotecaDTO getCarnetBibliotecaDTO() {
        return carnetBibliotecaDTO;
    }

    public void setCarnetBibliotecaDTO(CarnetBibliotecaDTO carnetBibliotecaDTO) {
        this.carnetBibliotecaDTO = carnetBibliotecaDTO;
    }

    
}
