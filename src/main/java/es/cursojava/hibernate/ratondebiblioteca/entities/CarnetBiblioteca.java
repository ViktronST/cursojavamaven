package es.cursojava.hibernate.ratondebiblioteca.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CARNET_BIBLIOTECA")
public class CarnetBiblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_emision", nullable = false, length = 50)
    private Date fechaEmision;

    @Column(name = "fecha_vencimiento", nullable = false, length = 50)
    private Date fechaVencimiento;

    @OneToOne(mappedBy = "carnetBiblioteca")
    private Estudiante estudiante;

    public CarnetBiblioteca() {
    }

    public CarnetBiblioteca(Date fechaEmision, Date fechaVencimiento) {
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
