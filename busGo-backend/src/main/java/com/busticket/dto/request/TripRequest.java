// TripRequest.java
package com.busticket.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TripRequest {

    @NotNull(message = "Route ID is required")
    private Integer routeId;

    @NotNull(message = "Bus ID is required")
    private Integer busId;

    @NotNull(message = "Boarding address ID is required")
    private Integer boardingAddressId;

    @NotNull(message = "Dropping address ID is required")
    private Integer droppingAddressId;

    @NotNull(message = "Departure time is required")
    @Future(message = "Departure time must be in the future")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival time is required")
    @Future(message = "Arrival time must be in the future")
    private LocalDateTime arrivalTime;

    @NotNull(message = "Primary driver ID is required")
    private Integer driver1Id;

    @NotNull(message = "Secondary driver ID is required")
    private Integer driver2Id;

    @NotNull(message = "Available seats is required")
    @Min(value = 1, message = "Available seats must be at least 1")
    private Integer availableSeats;

    @NotNull(message = "Fare is required")
    @Positive(message = "Fare must be greater than zero")
    private BigDecimal fare;

    @NotNull(message = "Trip date is required")
    @Future(message = "Trip date must be in the future")
    private LocalDateTime tripDate;
}