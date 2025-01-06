package com.zpizp31.aviatickets.controllers;

import com.zpizp31.aviatickets.dto.CardRequest;
import com.zpizp31.aviatickets.dto.FindTicketRequest;
import com.zpizp31.aviatickets.dto.SelectedSeatsRequest;
import com.zpizp31.aviatickets.dto.UserDataRequest;
import com.zpizp31.aviatickets.model.Flight;
import com.zpizp31.aviatickets.model.Ticket;
import com.zpizp31.aviatickets.model.User;
import com.zpizp31.aviatickets.services.FlightService;
import com.zpizp31.aviatickets.services.TicketService;
import com.zpizp31.aviatickets.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FlightController {

    private FlightService flightService;
    private UserService userService;
    private TicketService ticketService;

    private Flight flightDeparture;
    private Flight flightReturn;

    public FlightController(FlightService flightService, UserService userService, TicketService ticketService) {
        this.flightService = flightService;
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @GetMapping("/flight")
    public String flightPage() {
        return "/flight";
    }


    @PostMapping("/flight")
    public String findTicket(FindTicketRequest findTicketRequest, Model model) {
        String cityFrom = findTicketRequest.getFromCity();
        String cityTo = findTicketRequest.getDestinationCity();
        LocalDate departDate = findTicketRequest.getDepartDate();
        LocalDate returnDate = findTicketRequest.getReturnDate();

        flightDeparture = flightService.findFlightByCityNameAndDate(cityFrom, cityTo, departDate).get(0);
        flightReturn = flightService.findFlightByCityNameAndDate(cityTo, cityFrom, returnDate).get(0);

        model.addAllAttributes(flightService.getFlightAttributes(flightDeparture, flightReturn));

        return "/flight.html";
    }


    // -------------------------- Confirmation ------------------------------------------
    @GetMapping("/confirmation")
    public String confirmationPage() {
        return "confirmation.html";
    }

    @PostMapping("/confirmation")
    public String filledConfirmationPage(
            UserDataRequest userDataRequest,
            SelectedSeatsRequest selectedSeatsRequest,
            CardRequest cardRequest,
            Model model
    ) {
        String firstName = userDataRequest.getFirstName();
        String lastName = userDataRequest.getLastName();
        String middleName = userDataRequest.getMiddleName();
        String gender = userDataRequest.getGender();
        LocalDate dob = LocalDate.of(
                userDataRequest.getYear(),
                userDataRequest.getMonth(),
                userDataRequest.getDay()
        );

        String seat = selectedSeatsRequest.getSelectedSeats();

        User user = userService.findOrAddUser(firstName, middleName, lastName, gender, dob);

        List<Ticket> tickets = ticketService.addTickets(user, flightDeparture, flightReturn, seat);

        model.addAllAttributes(ticketService.getTicketAttributes(user, tickets.get(0)));
        model.addAllAttributes(flightService.getFlightAttributes(flightDeparture, flightReturn));

        return "confirmation.html";
    }

}
