package com.repaso.tickets.dto;

public class CrearTicketRequest {
    private String descripcion;
    private String prioridad;

    // Constructor Vacio
    public CrearTicketRequest() {
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
