package com.busticket;

import com.busticket.dto.response.BookingResponse;
import com.busticket.entity.*;
import com.busticket.entity.enums.BookingStatus;
import com.busticket.exception.ResourceNotFoundException;
import com.busticket.respository.IBookingRepo;
import com.busticket.respository.IPaymentRepo;
import com.busticket.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private IBookingRepo bookingRepo;

    @Mock
    private IPaymentRepo paymentRepo;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private Booking booking;
    private Payment payment;

    @BeforeEach
    void setUp() {
        Route route = new Route();
        route.setFromCity("Mirzapur");
        route.setToCity("New Delhi");

        Trip trip = new Trip();
        trip.setTripId(1);
        trip.setRoute(route);
        trip.setDepartureTime(LocalDateTime.now());
        trip.setArrivalTime(LocalDateTime.now().plusHours(10));
        trip.setFare(BigDecimal.valueOf(2500));

        booking = new Booking();
        booking.setBookingId(1);
        booking.setTrip(trip);
        booking.setSeatNumber(5);
        booking.setStatus(BookingStatus.Booked);

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setName("Shreshtha");

        payment = new Payment();
        payment.setPaymentId(1);
        payment.setBooking(booking);
        payment.setCustomer(customer);  // <-- this was missing
    }


    @Test
    void getAllBookings_callsFindAllWithPayment() {
        Object[] row = {booking, payment};
        List<Object[]> rows = new ArrayList<>();
        rows.add(row);
        when(bookingRepo.findAllWithPayment()).thenReturn(rows);

        List<BookingResponse> result = bookingService.getAllBookings();

        assertEquals(1, result.size());
        verify(bookingRepo).findAllWithPayment();
        verifyNoInteractions(paymentRepo);
    }

    @Test
    void getBookingByID_found_callsBothReposAndReturnsResponse() {
        when(bookingRepo.findById(1)).thenReturn(Optional.of(booking));
        when(paymentRepo.findFirstByBooking_BookingId(1)).thenReturn(Optional.of(payment));

        BookingResponse result = bookingService.getBookingByID(1);

        assertNotNull(result);
        assertEquals(1, result.getBookingId());
        verify(bookingRepo).findById(1);
        verify(paymentRepo).findFirstByBooking_BookingId(1);
    }

    @Test
    void getBookingByID_notFound_throwsAndNeverCallsPaymentRepo() {
        when(bookingRepo.findById(99)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class, () -> bookingService.getBookingByID(99));
        System.out.println(ex.getMessage());
        assertEquals("Booking not found with id: 99", ex.getMessage());
        verify(bookingRepo).findById(99);
        verifyNoInteractions(paymentRepo);
    }
}
