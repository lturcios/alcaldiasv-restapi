package com.fernando9825.alcaldiasvrestapi.models.dto;

public class TuriDetalleDTO {
    private int codigoPresupuestario;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;

    // Getters y Setters
    public int getCodigoPresupuestario() { return codigoPresupuestario; }
    public void setCodigoPresupuestario(int codigoPresupuestario) { this.codigoPresupuestario = codigoPresupuestario; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }
}
