package com.zpizp31.aviatickets.repositories;

import com.zpizp31.aviatickets.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.fromCity = :cityFrom AND f.destinationCity = :cityTo AND f.departDate = :date")
    List<Flight> findFlightByCityNameAndDate(String cityFrom, String cityTo, LocalDate date);

}
