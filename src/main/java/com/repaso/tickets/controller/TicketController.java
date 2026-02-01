package com.repaso.tickets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import com.repaso.tickets.dto.CrearTicketRequest;
import com.repaso.tickets.dto.TicketDTO;
import com.repaso.tickets.model.Prioridad;
import com.repaso.tickets.service.TicketService;

@RestController
@RequestMapping("/tickets") // Ruta base (sin /api, como tú querías)
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // --- CREAR ---
    // Ruta final: POST http://localhost:8081/tickets
    // (Quitamos "/newTicket" porque el verbo POST ya implica "Crear")
    @PostMapping
    public void crearTicket(@RequestBody CrearTicketRequest request) {
        try {
            // 1. Intentamos convertir (esto es lo peligroso)
            Prioridad prioridadEnum = Prioridad.valueOf(request.getPrioridad().toUpperCase());

            // 2. Si pasa, seguimos normal
            this.ticketService.crearTicket(request.getDescripcion(), prioridadEnum);

        } catch (IllegalArgumentException e) {
            // 3. SI FALLA (no existe el Enum), capturamos el error y lanzamos uno "bonito"
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Prioridad inválida. Valores permitidos: ALTA, MEDIA, BAJA");
        }
    }

    // --- LISTAR URGENTES ---
    // Ruta final: GET http://localhost:8081/tickets/urgentes
    // (Todo en minúsculas es más fácil de recordar)
    @GetMapping("/urgentes")
    public List<TicketDTO> obtenerTicketsUrgentes() {
        return ticketService.obtenerTicketsUrgentes();
    }
}