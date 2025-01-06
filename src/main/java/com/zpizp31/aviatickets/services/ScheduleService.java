package com.zpizp31.aviatickets.services;

import com.zpizp31.aviatickets.model.Schedule;
import com.zpizp31.aviatickets.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ScheduleService {
    ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findScheduleByCities(String cityFrom, String cityTo){
        return scheduleRepository.findScheduleByCities(cityFrom, cityTo);
    }

}
