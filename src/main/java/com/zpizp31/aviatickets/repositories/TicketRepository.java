package com.zpizp31.aviatickets.repositories;

import com.zpizp31.aviatickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
