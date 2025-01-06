package com.zpizp31.aviatickets.services;

import com.zpizp31.aviatickets.model.Flight;
import com.zpizp31.aviatickets.model.Ticket;
import com.zpizp31.aviatickets.model.User;
import com.zpizp31.aviatickets.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> addTickets(User user, Flight flightDeparture, Flight flightReturn, String seat){
        Long confirmationNumber = new Random(100000000).nextLong();

        Ticket ticket1 = new Ticket();
        ticket1.setConfirmation_id(confirmationNumber);
        ticket1.setUser(user);
        ticket1.setFlight(flightDeparture);
        ticket1.setSeat(seat);

        Ticket ticket2 = new Ticket();
        ticket2.setConfirmation_id(confirmationNumber);
        ticket2.setUser(user);
        ticket2.setFlight(flightReturn);
        ticket2.setSeat(seat);

        ticketRepository.save(ticket1);
        ticketRepository.save(ticket2);

        return List.of(ticket1, ticket2);
    }

    public Map<String, String> getTicketAttributes(User user, Ticket ticket){
        Map<String, String> attr = new HashMap<>();

        attr.put("fullName", user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName());

        attr.put("confirmationNumber", ticket.getConfirmation_id().toString());
        attr.put("seat", ticket.getSeat());

        return attr;
    }



}
