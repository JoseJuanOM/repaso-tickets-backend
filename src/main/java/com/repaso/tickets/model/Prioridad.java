package com.repaso.tickets.model;

public enum Prioridad {
    // definimos las constantes con su valor interno
    BAJA(1, "Normal"),
    MEDIA(2, "Atencion requerida"),
    ALTA(3, "Urgente");

    // Atributos inmutables
    private final int nivel;
    private final String etiqueta;

    // Constructor privado ( los enums siempre lo tienen privado)
    Prioridad(int nivel, String etiqueta) {
        this.nivel = nivel;
        this.etiqueta = etiqueta;
    }

    // GETTERS -> como son inmutables no usamos SETTERS
    public int getNivel() {
        return nivel;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}
