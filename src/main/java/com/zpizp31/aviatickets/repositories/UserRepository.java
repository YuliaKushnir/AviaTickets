package com.zpizp31.aviatickets.repositories;

import com.zpizp31.aviatickets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName AND u.middleName = :middleName AND u.lastName = :lastName AND u.gender = :gender AND u.dateOfBirth = :dob")
    List<User> findUser(String firstName, String middleName, String lastName, String gender, LocalDate dob);

}
