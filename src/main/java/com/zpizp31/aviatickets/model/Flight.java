package com.zpizp31.aviatickets.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "from_city")
    private String fromCity;

    @Column(name = "from_airport")
    private String fromAirport;

    @Column(name = "from_iata")
    private String fromIATA;

    @Column(name = "destination_city")
    private String destinationCity;

    @Column(name = "destination_airport")
    private String destinationAirport;

    @Column(name = "destination_iata")
    private String destinationIATA;

    @Column(name = "depart_date")
    private LocalDate departDate;

    @Column(name = "depart_time")
    private LocalTime departTime;

    @Column(name = "duration")
    private LocalTime duration;

    @Column(name = "cost")
    private double cost;

    @Column(name = "taxes")
    private double taxes;

    @Column(name = "flight_number")
    private String flightNumber;




//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Ticket> tickets = new ArrayList<>();

}
