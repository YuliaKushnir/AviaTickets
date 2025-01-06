package com.zpizp31.aviatickets.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "confirmation_id")
    private Long confirmation_id;

//    @Column(name = "flight_id")
//    private Long flightId;
//
//    @Column(name = "user_id")
//    private Long userId;

    @Column(name = "seat")
    private String seat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="flight_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;


//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//    private User user;
//
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//    private Flight flight;
}
