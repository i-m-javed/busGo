package com.busticket.mapper.request;

import com.busticket.dto.request.BookingRequest;
import com.busticket.entity.Booking;
import com.busticket.entity.Trip;
import com.busticket.entity.enums.BookingStatus;
import org.springframework.stereotype.Component;

@Component
public class BookingRequestMapper {

    public Booking requestToEntity(BookingRequest dto) {
        if (dto == null) return null;

        Booking booking = new Booking();

        Trip trip = new Trip();
        trip.setTripId(dto.getTripId());

        booking.setTrip(trip);
        booking.setSeatNumber(dto.getSeatNumber());
        booking.setStatus(BookingStatus.Booked);

        return booking;
    }

    public BookingRequest entityToRequest(Booking entity) {
        if (entity == null) return null;

        BookingRequest dto = new BookingRequest();
        dto.setTripId(entity.getTrip().getTripId());
        dto.setSeatNumber(entity.getSeatNumber());

        return dto;
    }
}