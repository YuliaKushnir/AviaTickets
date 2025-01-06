package com.zpizp31.aviatickets.controllers;

import com.zpizp31.aviatickets.dto.FindTicketRequest;
import com.zpizp31.aviatickets.model.Flight;
import com.zpizp31.aviatickets.repositories.ScheduleRepository;
import com.zpizp31.aviatickets.services.FlightService;
import com.zpizp31.aviatickets.services.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(){
        return "main";
    }
}
