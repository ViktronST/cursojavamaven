package es.cursojava.hibernate.ratondebiblioteca.dto;

public class EstudianteDTO {
    private String nombre;

    public EstudianteDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
