package com.repaso.tickets.dto;

import com.repaso.tickets.model.Prioridad;

public class TicketDTO {
    private final String id;
    private final String descripcion;
    // aqui el truco: guardamos el String formateado o el Enum,
    // pero para el frontend es mejor mandar el String listo o ambos
    private final String prioridadTexto;
    private final String prioridadTecnica;

    // contructor parametrizado
    public TicketDTO(String id, String descripcion, Prioridad prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridadTexto = prioridad.getEtiqueta();
        this.prioridadTecnica = prioridad.name();
    }

    // GETTERS solamente para inmutabilidad
    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrioridadTexto() {
        return prioridadTexto;
    }

    public String getPrioridadTecnica() {
        return prioridadTecnica;
    }

}
