package com.railwayservice.controller;

import com.railwayservice.dto.DepartureDto;
import com.railwayservice.model.entity.Departure;
import com.railwayservice.service.CityService;
import com.railwayservice.service.DepartureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartureController {
    private final DepartureService departureService;

    @GetMapping(value = "/departure")
    public String departure(Model model){
        model.addAttribute("departure",new DepartureDto());
        model.addAttribute("currentDate", LocalDate.now());
        return "departure";
    }

    @PostMapping(value = "/departure")
    public String findDepartures(@ModelAttribute("departure") DepartureDto departureDto, Model model){
        List<Departure> departures=departureService.findDepartureForUser(departureDto);
        model.addAttribute("foundDepartures", departures);
        return "departure";
    }

}
