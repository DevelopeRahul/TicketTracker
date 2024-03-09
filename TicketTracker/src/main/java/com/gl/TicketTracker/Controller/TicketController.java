package com.gl.TicketTracker.Controller;


import com.gl.TicketTracker.Entity.Ticket;
import com.gl.TicketTracker.Exception.TicketNotFoundException;
import com.gl.TicketTracker.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTicketById(@PathVariable Long id) {
        try {
            Ticket ticket = ticketService.getTicketById(id);
            return ResponseEntity.ok(ticket);
        } catch (TicketNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket) {
        try {
            Ticket updated = ticketService.updateTicket(id, updatedTicket);
            return ResponseEntity.ok(updated);
        } catch (TicketNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        try {
            ticketService.deleteTicket(id);
            return ResponseEntity.noContent().build();
        } catch (TicketNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
