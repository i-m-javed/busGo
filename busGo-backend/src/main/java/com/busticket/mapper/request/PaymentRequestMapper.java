package com.busticket.mapper.request;

import com.busticket.dto.request.PaymentRequest;
import com.busticket.entity.Booking;
import com.busticket.entity.Customer;
import com.busticket.entity.Payment;
import com.busticket.entity.enums.PaymentStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentRequestMapper {

    public Payment requestToEntity(PaymentRequest request) {
        Payment payment = new Payment();

        Booking booking = new Booking();
        booking.setBookingId(request.getBookingId());
        payment.setBooking(booking);

        Customer customer = new Customer();
        customer.setCustomerId(request.getCustomerId());
        payment.setCustomer(customer);

        payment.setAmount(request.getAmount());
        payment.setPaymentDate(LocalDateTime.now());

        return payment;
    }

    public PaymentRequest entityToRequest(Payment payment) {
        PaymentRequest request = new PaymentRequest();
        request.setBookingId(payment.getBooking().getBookingId());
        request.setCustomerId(payment.getCustomer().getCustomerId());
        request.setAmount(payment.getAmount());
        return request;
    }
}