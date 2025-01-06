package com.zpizp31.aviatickets.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "from_city")
    private String fromCity;

    @Column(name = "from_country")
    private String fromCountry;

    @Column(name = "from_airport")
    private String fromAirport;

    @Column(name = "from_iata")
    private String fromIATA;

    @Column(name = "destination_city")
    private String destinationCity;

    @Column(name = "destination_country")
    private String destinationCountry;

    @Column(name = "destination_airport")
    private String destinationAirport;

    @Column(name = "destination_iata")
    private String destinationIATA;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "duration")
    private LocalTime duration;

    @Column(name = "cost")
    private double cost;

    @Column(name = "taxes")
    private double taxes;

    @Column(name = "flight_number")
    private String flightNumber;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getFromIATA() {
        return fromIATA;
    }

    public void setFromIATA(String fromIATA) {
        this.fromIATA = fromIATA;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getDestinationIATA() {
        return destinationIATA;
    }

    public void setDestinationIATA(String destinationIATA) {
        this.destinationIATA = destinationIATA;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Schedule(String fromCity, String fromCountry, String fromAirport, String fromIATA, String destinationCity, String destinationCountry, String destinationAirport, String destinationIATA, LocalTime departureTime, LocalTime duration, double cost, double taxes, String flightNumber) {
        this.fromCity = fromCity;
        this.fromCountry = fromCountry;
        this.fromAirport = fromAirport;
        this.fromIATA = fromIATA;
        this.destinationCity = destinationCity;
        this.destinationCountry = destinationCountry;
        this.destinationAirport = destinationAirport;
        this.destinationIATA = destinationIATA;
        this.departureTime = departureTime;
        this.duration = duration;
        this.cost = cost;
        this.taxes = taxes;
        this.flightNumber = flightNumber;
    }
}
