package com.zpizp31.aviatickets.repositories;

import com.zpizp31.aviatickets.model.Flight;
import com.zpizp31.aviatickets.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s WHERE s.fromCity = :cityFrom AND s.destinationCity = :cityTo")
    List<Schedule> findScheduleByCities(String cityFrom, String cityTo);

}
