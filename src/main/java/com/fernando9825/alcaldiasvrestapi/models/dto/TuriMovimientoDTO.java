package com.fernando9825.alcaldiasvrestapi.models.dto;

import java.util.ArrayList;
import java.util.List;

public class TuriMovimientoDTO {
    private String pagoId;
    private Integer ubicacionId;
    private String referencia;
    private double montoTotal;
    private String fechaHorapago; // Recibimos como String
    private String fechaHoraAnula;
    private String observaciones;
    private String numeroSerie;
    private String usuarioEmail;
    private List<TuriDetalleDTO> detalles = new ArrayList<>();

    // Getters y Setters
    public String getPagoId() { return pagoId; }
    public void setPagoId(String pagoId) { this.pagoId = pagoId; }

    public Integer getUbicacionId() { return ubicacionId; }
    public void setUbicacionId(Integer ubicacionId) { this.ubicacionId = ubicacionId; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }

    public String getFechaHorapago() { return fechaHorapago; }
    public void setFechaHorapago(String fechaHorapago) { this.fechaHorapago = fechaHorapago; }

    public String getFechaHoraAnula() { return fechaHoraAnula; }
    public void setFechaHoraAnula(String fechaHoraAnula) { this.fechaHoraAnula = fechaHoraAnula; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }

    public String getUsuarioEmail() { return usuarioEmail; }
    public void setUsuarioEmail(String usuarioEmail) { this.usuarioEmail = usuarioEmail; }

    public List<TuriDetalleDTO> getDetalles() { return detalles; }
    public void setDetalles(List<TuriDetalleDTO> detalles) { this.detalles = detalles; }
}
