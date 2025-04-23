package es.cursojava.hibernate.dto;

import java.time.LocalDate;

public class PedidoDTO {
    private Long idPedido;
    private String descripcion;
    private LocalDate fechaPedido;
    private double costePedido;
    
    public PedidoDTO(String descripcion, LocalDate fechaPedido, double costePedido) {
        this.descripcion = descripcion;
        this.fechaPedido = fechaPedido;
        this.costePedido = costePedido;
    }

    public PedidoDTO(Long idPedido, String descripcion, LocalDate fechaPedido, double costePedido) {
        this.idPedido = idPedido;
        this.descripcion = descripcion;
        this.fechaPedido = fechaPedido;
        this.costePedido = costePedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "PedidoDTO [idPedido=" + idPedido + ", descripcion=" + descripcion + ", fechaPedido=" + fechaPedido
                + ", costePedido=" + costePedido + "]";
    }

    
}
