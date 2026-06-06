package com.busticket.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// BookingRequest.java
@Data
public class BookingRequest {

    @NotNull(message = "Trip ID is required")
    private Integer tripId;

    @NotNull(message = "Seat number is required")
    @Min(value = 1, message = "Seat number must be at least 1")
    private Integer seatNumber;
}
