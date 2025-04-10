package es.cursojava.hibernate.ratondebiblioteca.dto;

public class EstudianteDTO {
    private String nombre;
    private String apellidos;
    private String edad;
    private String dni;
    private String email;
    private CarnetBibliotecaDTO carnetBibliotecaDTO;

    public EstudianteDTO(String nombre) {
        this.nombre = nombre;
    }

    public EstudianteDTO(String nombre, CarnetBibliotecaDTO carnetBibliotecaDTO) {
        this.nombre = nombre;
        this.carnetBibliotecaDTO = carnetBibliotecaDTO;
    }

    public EstudianteDTO(String nombre, String apellidos, String edad, String dni, String email, CarnetBibliotecaDTO carnetBibliotecaDTO) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.email = email;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
