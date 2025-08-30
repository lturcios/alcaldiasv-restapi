package com.fernando9825.alcaldiasvrestapi.models.dto;

public class TuriMovimientoResponseDTO {
    private String pagoId;
    private String mensaje;
    private boolean exitoso;

    public TuriMovimientoResponseDTO(String pagoId, String mensaje, boolean exitoso) {
        this.pagoId = pagoId;
        this.mensaje = mensaje;
        this.exitoso = exitoso;
    }

    // Getters y Setters
    public String getPagoId() { return pagoId; }
    public void setPagoId(String pagoId) { this.pagoId = pagoId; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public boolean isExitoso() { return exitoso; }
    public void setExitoso(boolean exitoso) { this.exitoso = exitoso; }
}
