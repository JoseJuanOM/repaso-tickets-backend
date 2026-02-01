package com.repaso.tickets.model;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

public class Ticket {
    // Atributos privados por encapsulamiento
    private UUID id;
    private String description;
    private Prioridad priority;
    private LocalDateTime createdAt;

    // Constructor Vacio sirve para que la clase se pueda instanciar sin parametros
    // y por necesidades de frameworks como Spring y por buenas practicas
    public Ticket() {
    }

    // Constructor Parametrizado
    public Ticket(String desc, Prioridad prio) {
        this.id = UUID.randomUUID(); // java.util.UUID
        this.description = desc;
        this.priority = prio;
        this.createdAt = LocalDateTime.now();
    }

    /*
     * Uso de @Override para sobreescribir metodos de la clase Object
     * equals() compara si dos objetos son iguales
     * Si no lo son devuelve false
     * Si lo son devuelve true
     * Equals compara contenido, no referencias en memoria
     * Dos tickets son iguales si tienen el mismo id
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Ticket ticket = (Ticket) o;
        return id.equals(ticket.id);
    }

    // SETTERS & GETTERS
    // Getters: parametros para que el servicio pueda leer los datos de los
    // atributos privados
    // Setters: parametros para que el servicio pueda modificar los datos de los
    // atributos privados

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Prioridad getPriority() {
        return priority;
    }

    public void setPriority(Prioridad priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Uso de @Override para sobreescribir metodos de la clase Object
    // 2. hashCode() -> devuelve un entero que representa al objeto
    // Necesario para que HashMap encuentre el objeto rapidamente
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // 3. TOSTRING -> Para imprimir el objeto en formato legible en consola en lugar
    // de Ticket@12345678
    @Override
    public String toString() {
        return "Ticket {id = " + id + " , prioridad = " + priority + " , desc = " + description + " }";
    }

}
