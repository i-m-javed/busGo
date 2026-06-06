package com.busticket.mapper.request;

import com.busticket.dto.request.TripRequest;
import com.busticket.entity.*;
import org.springframework.stereotype.Component;

@Component
public class TripRequestMapper {

    public Trip requestToEntity(TripRequest request) {
        Trip trip = new Trip();

        Route route = new Route();
        route.setRouteId(request.getRouteId());
        trip.setRoute(route);

        Bus bus = new Bus();
        bus.setBusId(request.getBusId());
        trip.setBus(bus);

        Address boardingAddress = new Address();
        boardingAddress.setAddressId(request.getBoardingAddressId());
        trip.setBoardingAddress(boardingAddress);

        Address droppingAddress = new Address();
        droppingAddress.setAddressId(request.getDroppingAddressId());
        trip.setDroppingAddress(droppingAddress);

        Driver driver1 = new Driver();
        driver1.setDriverId(request.getDriver1Id());
        trip.setDriver1(driver1);

        Driver driver2 = new Driver();
        driver2.setDriverId(request.getDriver2Id());
        trip.setDriver2(driver2);

        trip.setDepartureTime(request.getDepartureTime());
        trip.setArrivalTime(request.getArrivalTime());
        trip.setAvailableSeats(request.getAvailableSeats());
        trip.setFare(request.getFare());
        trip.setTripDate(request.getTripDate());

        return trip;
    }

    public TripRequest entityToRequest(Trip trip) {
        TripRequest request = new TripRequest();
        request.setRouteId(trip.getRoute().getRouteId());
        request.setBusId(trip.getBus().getBusId());
        request.setBoardingAddressId(trip.getBoardingAddress().getAddressId());
        request.setDroppingAddressId(trip.getDroppingAddress().getAddressId());
        request.setDriver1Id(trip.getDriver1().getDriverId());
        request.setDriver2Id(trip.getDriver2().getDriverId());
        request.setDepartureTime(trip.getDepartureTime());
        request.setArrivalTime(trip.getArrivalTime());
        request.setAvailableSeats(trip.getAvailableSeats());
        request.setFare(trip.getFare());
        request.setTripDate(trip.getTripDate());
        return request;
    }
}