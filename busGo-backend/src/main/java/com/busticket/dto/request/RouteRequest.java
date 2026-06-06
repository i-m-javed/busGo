// RouteRequest.java
package com.busticket.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RouteRequest {

    @NotBlank(message = "Origin city is required")
    @Size(max = 255, message = "Origin city must not exceed 255 characters")
    private String fromCity;

    @NotBlank(message = "Destination city is required")
    @Size(max = 255, message = "Destination city must not exceed 255 characters")
    private String toCity;

    @NotNull(message = "Number of break points is required")
    @Min(value = 0, message = "Break points cannot be negative")
    private Integer breakPoints;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer duration;                   // stored in minutes
}