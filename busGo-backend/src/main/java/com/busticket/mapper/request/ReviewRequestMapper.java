package com.busticket.mapper.request;

import com.busticket.dto.request.ReviewRequest;
import com.busticket.entity.Customer;
import com.busticket.entity.Review;
import com.busticket.entity.Trip;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReviewRequestMapper {

    public Review requestToEntity(ReviewRequest request) {
        Review review = new Review();

        Customer customer = new Customer();
        customer.setCustomerId(request.getCustomerId());
        review.setCustomer(customer);

        Trip trip = new Trip();
        trip.setTripId(request.getTripId());
        review.setTrip(trip);

        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setReviewDate(LocalDateTime.now());

        return review;
    }

    public ReviewRequest entityToRequest(Review review) {
        ReviewRequest request = new ReviewRequest();
        request.setCustomerId(review.getCustomer().getCustomerId());
        request.setTripId(review.getTrip().getTripId());
        request.setRating(review.getRating());
        request.setComment(review.getComment());
        return request;
    }
}