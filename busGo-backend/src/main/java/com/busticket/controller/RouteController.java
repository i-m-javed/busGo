package com.busticket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.busticket.dto.response.RouteWithTripsDTO;
import com.busticket.service.interfaces.IRouteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final IRouteService routeService;
    
    public RouteController(IRouteService routeService) {
    	this.routeService = routeService;
    }

    @GetMapping("/{routeId}/trips")
    public ResponseEntity<RouteWithTripsDTO> getRouteWithTrips(
            @PathVariable Integer routeId) {

        RouteWithTripsDTO response = routeService.getRouteWithTrips(routeId);

        return ResponseEntity.ok(response);
    }
}