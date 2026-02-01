package com.repaso.tickets.service;

import com.repaso.tickets.model.Prioridad;
import com.repaso.tickets.model.Ticket;
import com.repaso.tickets.dto.TicketDTO;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private final List<Ticket> db = new ArrayList<>();

    public void crearTicket(String desc, Prioridad prioridad) {
        db.add(new Ticket(desc, prioridad));
    }

    public List<TicketDTO> obtenerTicketsUrgentes() {
        return db.stream()
                // Filtro mucho mas legible y seguro
                // usamos '==' para enums
                .filter(t -> t.getPriority() == Prioridad.ALTA)

                // Mapeo -> el constructor del DTO se encarga de extraer el texto del Enum
                .map(t -> new TicketDTO(
                        t.getId().toString(),
                        t.getDescription(),
                        t.getPriority()))
                .collect(Collectors.toList());
    }

}
