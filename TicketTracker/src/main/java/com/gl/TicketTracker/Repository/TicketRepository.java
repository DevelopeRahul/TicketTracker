package com.gl.TicketTracker.Repository;

import com.gl.TicketTracker.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket,Long>{


}
