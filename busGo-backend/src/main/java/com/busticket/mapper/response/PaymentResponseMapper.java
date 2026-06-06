package com.busticket.mapper.response;

import com.busticket.dto.response.PaymentResponse;
import com.busticket.entity.Booking;
import com.busticket.entity.Customer;
import com.busticket.entity.Payment;
import com.busticket.entity.Route;
import com.busticket.entity.Trip;
import com.busticket.entity.enums.BookingStatus;

public class PaymentResponseMapper {

    public static PaymentResponse entityToResponse(Payment payment) {
        return PaymentResponse.builder()
                .paymentId(payment.getPaymentId())
                .bookingId(payment.getBooking().getBookingId())
                .seatNumber(payment.getBooking().getSeatNumber())
                .bookingStatus(payment.getBooking().getStatus().getMessage())
                .tripId(payment.getBooking().getTrip().getTripId())
                .fromCity(payment.getBooking().getTrip().getRoute().getFromCity())
                .toCity(payment.getBooking().getTrip().getRoute().getToCity())
                .departureTime(payment.getBooking().getTrip().getDepartureTime())
                .customerId(payment.getCustomer().getCustomerId())
                .customerName(payment.getCustomer().getName())
                .customerEmail(payment.getCustomer().getEmail())
                .amount(payment.getAmount())
                .paymentDate(payment.getPaymentDate())
                .paymentStatus(payment.getPaymentStatus())
                .build();
    }

    public static Payment responseToEntity(PaymentResponse response) {
        Payment payment = new Payment();
        payment.setPaymentId(response.getPaymentId());
        payment.setAmount(response.getAmount());
        payment.setPaymentDate(response.getPaymentDate());
        payment.setPaymentStatus(response.getPaymentStatus());

        Route route = new Route();
        route.setFromCity(response.getFromCity());
        route.setToCity(response.getToCity());

        Trip trip = new Trip();
        trip.setTripId(response.getTripId());
        trip.setDepartureTime(response.getDepartureTime());
        trip.setRoute(route);

        Booking booking = Booking.builder()
                .bookingId(response.getBookingId())
                .seatNumber(response.getSeatNumber())
                .status(BookingStatus.fromValue(response.getBookingStatus()))
                .trip(trip)
                .build();
        payment.setBooking(booking);

        Customer customer = new Customer();
        customer.setCustomerId(response.getCustomerId());
        customer.setName(response.getCustomerName());
        customer.setEmail(response.getCustomerEmail());
        payment.setCustomer(customer);

        return payment;
    }
}
