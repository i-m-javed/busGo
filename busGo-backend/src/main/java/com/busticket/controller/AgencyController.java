package com.busticket.controller;

import com.busticket.dto.response.AgencyResponse;
import com.busticket.service.interfaces.IAgencyService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agencies")

public class AgencyController {

    private final IAgencyService agencyService;
    
    public AgencyController(IAgencyService agencyService) {
    	this.agencyService = agencyService;
    }

    @GetMapping
    public List<AgencyResponse> getAgenciesByCity(
            @RequestParam String city) {

        return agencyService.getAgenciesByCity(city);
    }
}