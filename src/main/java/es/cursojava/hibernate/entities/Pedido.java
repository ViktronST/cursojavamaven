package es.cursojava.hibernate.entities;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PEDIDOS", indexes = { @Index(name = "idx_fecha_pedido", columnList = "fecha_pedido") })
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @Column(name = "descripcion_pedido", nullable = false, length = 100)
    private String descripcionPedido;

    @Column(nullable = false)
    private LocalDate fechaPedido;

    @Column(name = "coste_pedido", nullable = false)
    private double costePedido;

    @ManyToOne
    @JoinColumn(name = "FK_CLIENTE")
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(String descripcionPedido, LocalDate fechaPedido, double costePedido) {
        this.descripcionPedido = descripcionPedido;
        this.fechaPedido = fechaPedido;
        this.costePedido = costePedido;
    }  

    public Pedido(Long idPedido, String descripcionPedido, LocalDate fechaPedido, double costePedido) {
        this.idPedido = idPedido;
        this.descripcionPedido = descripcionPedido;
        this.fechaPedido = fechaPedido;
        this.costePedido = costePedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(String descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getCostePedido() {
        return costePedido;
    }

    public void setCostePedido(double costePedido) {
        this.costePedido = costePedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
