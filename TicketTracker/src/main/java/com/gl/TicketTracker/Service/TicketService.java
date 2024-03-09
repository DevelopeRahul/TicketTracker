package com.gl.TicketTracker.Service;

import com.gl.TicketTracker.Entity.Ticket;


import java.util.List;

public interface TicketService {
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    Ticket createTicket(Ticket ticket);
    Ticket updateTicket(Long id, Ticket updatedTicket);
    void deleteTicket(Long id);
}
