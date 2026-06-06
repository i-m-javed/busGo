package com.busticket.controller;

import org.springframework.web.bind.annotation.*;

import com.busticket.dto.response.DriverScheduleResponse;
import com.busticket.service.interfaces.IDriverService;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final IDriverService driverService;
    
    public DriverController(IDriverService driverService) {
    	this.driverService = driverService;
    }

    @GetMapping("/{driverId}/upcoming-trips")
    public DriverScheduleResponse getUpcomingTrips(@PathVariable Integer driverId) {
        return driverService.getDriverUpcomingTrips(driverId);
    }
}