package com.busticket;

import com.busticket.entity.Customer;
import com.busticket.entity.Review;
import com.busticket.entity.Trip;
import com.busticket.respository.IReviewRepo;
import com.busticket.service.impl.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

    @Mock
    private IReviewRepo reviewRepo;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    private Review review;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setName("Shreshtha");

        Trip trip = new Trip();
        trip.setTripId(1);

        review = new Review();
        review.setReviewId(1);
        review.setCustomer(customer);
        review.setTrip(trip);
        review.setRating(5);
        review.setComment("Great trip!");
        review.setReviewDate(LocalDateTime.now());
    }

    @Test
    void findReviewByCustomerId_callsRepoWithCustomerId() {
        when(reviewRepo.findByCustomer_CustomerId(1)).thenReturn(List.of(review));

        List<Review> result = reviewService.findReviewByCustomerId(1);

        assertEquals(1, result.size());
        verify(reviewRepo).findByCustomer_CustomerId(1);
    }

    @Test
    void findReviewByCustomerId_noReviews_returnsEmptyList() {
        when(reviewRepo.findByCustomer_CustomerId(99)).thenReturn(List.of());

        List<Review> result = reviewService.findReviewByCustomerId(99);

        assertTrue(result.isEmpty());
        verify(reviewRepo).findByCustomer_CustomerId(99);
    }
}
