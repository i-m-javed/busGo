// BusRequest.java
package com.busticket.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BusRequest {

    @NotNull(message = "Office ID is required")
    private Integer officeId;

    @NotBlank(message = "Registration number is required")
    @Size(max = 20, message = "Registration number must not exceed 20 characters")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$",
            message = "Invalid registration number format (e.g. DL01AB1234)")
    private String registrationNumber;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    @NotBlank(message = "Bus type is required")
    @Size(max = 30, message = "Bus type must not exceed 30 characters")
    private String type;
}