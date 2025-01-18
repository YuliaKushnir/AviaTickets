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
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FlightController {

    private final FlightService flightService;
    private final UserService userService;
    private final TicketService ticketService;

    private Flight flightDeparture;
    private Flight flightReturn;
    private User user;
    private List<Ticket> tickets;

    public FlightController(FlightService flightService, UserService userService, TicketService ticketService) {
        this.flightService = flightService;
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @GetMapping("/flight")
    public String flightPage() {
        return "/index";
    }


    @PostMapping("/flight")
    public String findTicket(
            FindTicketRequest findTicketRequest,
            Model model) {
        String cityFrom = findTicketRequest.getFromCity();
        String cityTo = findTicketRequest.getDestinationCity();
        LocalDate departDate = findTicketRequest.getDepartDate();
        LocalDate returnDate = findTicketRequest.getReturnDate();

        flightDeparture = flightService.findFlightByCityNameAndDate(cityFrom, cityTo, departDate).get(0);
        flightReturn = flightService.findFlightByCityNameAndDate(cityTo, cityFrom, returnDate).get(0);

        model.addAllAttributes(flightService.getFlightAttributes(flightDeparture, flightReturn));


        return "/index";
    }


    // -------------------------- Confirmation ------------------------------------------
    @GetMapping("/confirmation")
    public String confirmationPage(Model model) {

        model.addAllAttributes(ticketService.getTicketAttributes(user, tickets.get(0)));
        model.addAllAttributes(flightService.getFlightAttributes(flightDeparture, flightReturn));

        return "third_page";
    }

    @PostMapping("/confirmation")
    public String filledConfirmationPage(
            UserDataRequest userDataRequest,
            SelectedSeatsRequest selectedSeatsRequest,
            Model model
    ) {
        String firstName = userDataRequest.getFirstName();
        String lastName = userDataRequest.getLastName();
        String middleName = userDataRequest.getMiddleName();
        String gender = userDataRequest.getGender();

        LocalDate dob = userService.getDateOfBirth(
                userDataRequest.getYear(),
                userDataRequest.getMonth(),
                userDataRequest.getDay()
        );

        String seat = selectedSeatsRequest.getSelectedSeats().trim();

        user = userService.findOrAddUser(firstName, middleName, lastName, gender, dob);

        tickets = ticketService.addTickets(user, flightDeparture, flightReturn, seat);



        return "third_page";
    }

}
