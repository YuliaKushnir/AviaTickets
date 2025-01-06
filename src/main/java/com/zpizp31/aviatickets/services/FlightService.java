package com.zpizp31.aviatickets.services;

import com.zpizp31.aviatickets.model.Flight;
import com.zpizp31.aviatickets.model.Schedule;
import com.zpizp31.aviatickets.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class FlightService {

    private FlightRepository flightRepository;
    private ScheduleService scheduleService;

    public FlightService(FlightRepository flightRepository, ScheduleService scheduleService) {
        this.flightRepository = flightRepository;
        this.scheduleService = scheduleService;
    }

    public void addFlight(String fromCity, String destinationCity, LocalDate date){
        Flight flight = new Flight();
        Schedule schedule1 = scheduleService.findScheduleByCities(fromCity, destinationCity).get(0);

        flight.setFromCity(fromCity);
        flight.setFromAirport(schedule1.getFromAirport());
        flight.setFromIATA(schedule1.getFromIATA());
        flight.setDestinationCity(destinationCity);
        flight.setDestinationAirport(schedule1.getDestinationAirport());
        flight.setDestinationIATA(schedule1.getDestinationIATA());
        flight.setDepartDate(date);
        flight.setDepartTime(schedule1.getDepartureTime());

        flight.setDuration(schedule1.getDuration());
        flight.setCost(schedule1.getCost());
        flight.setTaxes(schedule1.getTaxes());
        flight.setFlightNumber(getFlightNumber(schedule1.getFlightNumber()));

        flightRepository.save(flight);
    }

    public List<Flight> findFlightByCityNameAndDate(String cityFrom, String cityTo, LocalDate date){
        List<Flight> flights = flightRepository.findFlightByCityNameAndDate(cityFrom, cityTo, date);

        if(flights.isEmpty()){
            addFlight(cityFrom, cityTo, date);
        }

        return flightRepository.findFlightByCityNameAndDate(cityFrom, cityTo, date);
    }

    public Map<String, String> getFlightAttributes(Flight departureFlight, Flight returnFlight){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM", Locale.ENGLISH);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);

        String from = departureFlight.getFromCity();
        String dest = departureFlight.getDestinationCity();
        Schedule schedule1 = scheduleService.findScheduleByCities(from, dest).get(0);

        Map<String, String> attr = new HashMap<>();

        attr.put("destinationCity", dest);

        attr.put("departFlightNumber", departureFlight.getFlightNumber());
        attr.put("departDate", departureFlight.getDepartDate().format(dateFormatter));

        attr.put("departTime", departureFlight.getDepartTime().format(timeFormatter));
        attr.put("departIATA", departureFlight.getFromIATA());
        attr.put("departDuration", String.format("%dh %dmin", departureFlight.getDuration().getHour(), departureFlight.getDuration().getMinute()));

        attr.put("departArrivalTime", departureFlight.getDepartTime().plusMinutes(departureFlight.getDuration().getHour() * 60 + departureFlight.getDuration().getMinute()).format(timeFormatter));
        attr.put("departDestinationIATA", departureFlight.getDestinationIATA());

        attr.put("placeA", departureFlight.getFromAirport()
                + ", T1, "
                + from
                + " (" + schedule1.getFromCountry() + ")"
        );
        attr.put("placeB", departureFlight.getDestinationAirport()
                + ", T1, "
                + dest + " ("
                + schedule1.getDestinationCountry() + ")");

        attr.put("flightNumberReturn", returnFlight.getFlightNumber());
        attr.put("returnDate", returnFlight.getDepartDate().format(dateFormatter));

        attr.put("returnTime", departureFlight.getDepartTime().format(timeFormatter));
        attr.put("returnDuration", String.format("%dh %dmin", departureFlight.getDuration().getHour(), departureFlight.getDuration().getMinute()));
        attr.put("returnArrivalTime", departureFlight.getDepartTime().plusMinutes(departureFlight.getDuration().getHour() * 60 + departureFlight.getDuration().getMinute()).format(timeFormatter));

        attr.put("cost", String.valueOf(departureFlight.getCost()));
        attr.put("taxes", String.valueOf(departureFlight.getTaxes()));
        attr.put("total", String.valueOf(departureFlight.getCost() + departureFlight.getTaxes()));

        return attr;
    }

    public String getFlightNumber(String flightNumber){
        return flightNumber + new Random().nextInt(1000);
    }

}
