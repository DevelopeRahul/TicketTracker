package com.gl.TicketTracker.Service;

import com.gl.TicketTracker.Entity.Ticket;
import com.gl.TicketTracker.Exception.TicketNotFoundException;
import com.gl.TicketTracker.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException("Ticket not found with id: " + id));
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Ticket existingTicket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException("Ticket not found with id: " + id));

        existingTicket.setTitle(updatedTicket.getTitle());
        existingTicket.setDescription(updatedTicket.getDescription());
        existingTicket.setStatus(updatedTicket.getStatus());

        return ticketRepository.save(existingTicket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException("Ticket not found with id: " + id));
        ticketRepository.deleteById(id);
    }
}