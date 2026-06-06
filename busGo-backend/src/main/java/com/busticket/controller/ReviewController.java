package com.busticket.controller;

import com.busticket.dto.response.ReviewResponse;
import com.busticket.mapper.response.ReviewResponseMapper;
import com.busticket.service.interfaces.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class ReviewController {

    private final IReviewService reviewService;

    @Autowired
    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/customer/{customerId}/reviews")

    public ResponseEntity<List<ReviewResponse>> getReviewsByCustomerId(@PathVariable Integer customerId) {

        List<ReviewResponse> reviews = reviewService.findReviewByCustomerId(customerId)
                .stream()
                .map(ReviewResponseMapper::entityToResponse)
                .toList();
        return ResponseEntity.ok(reviews);
    }
}
