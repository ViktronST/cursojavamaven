package es.cursojava.hibernate.ratondebiblioteca.dto;

import java.util.Date;

public class CarnetBibliotecaDTO {
    private Date fechaEmision;
    private Date fechaVencimiento;

    public CarnetBibliotecaDTO(Date fechaEmision, Date fechaVencimiento) {
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
}
