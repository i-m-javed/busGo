package com.busticket.controller;

import java.util.List;
import com.busticket.dto.response.TripFullDetailsResponse;
import com.busticket.service.interfaces.ITripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.busticket.dto.response.DriverTripSummaryResponse;
import com.busticket.dto.response.TripResponse;

@RestController
@RequestMapping("/api/trips")
public class TripsController {

	private final ITripService service;

	public TripsController(ITripService service) {
		this.service = service;
	}
	
	@GetMapping("/route/{id}")
	public ResponseEntity<List<TripResponse>> getTripsWithAvailableSeatsInARoute(@PathVariable Integer id) {
	    List<TripResponse> trips = service.getTripsWithAvailableSeatsInARoute(0,id);
	    return ResponseEntity.ok(trips);
	}

	@GetMapping
	public ResponseEntity<List<TripResponse>> getTripsWithAvailableSeats() {
	    List<TripResponse> trips = service.getTripsWithAvailableSeats(0);
	    return ResponseEntity.ok(trips);
	}

    @GetMapping("/completed")
    public List<DriverTripSummaryResponse> getCompletedTrips(
            @RequestParam String fromCity,
            @RequestParam String toCity
    ) {
        return service.getCompletedTrips(fromCity, toCity);
    }

    @GetMapping("/{tripId}")
    public ResponseEntity<TripFullDetailsResponse> getTripById(
            @PathVariable Integer tripId) {
    
        TripFullDetailsResponse trip = service.getTripById(tripId);
    
        return ResponseEntity.ok(trip);
    }
}



