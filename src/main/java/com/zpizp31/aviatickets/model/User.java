package com.zpizp31.aviatickets.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Ticket> tickets = new ArrayList<>();

}
