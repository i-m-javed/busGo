// DriverRequest.java
package com.busticket.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DriverRequest {

    @NotBlank(message = "License number is required")
    @Size(max = 20, message = "License number must not exceed 20 characters")
    @Pattern(
            regexp = "^[A-Z]{2}[0-9]{2} [0-9]{4} [0-9]{7}$",
            message = "Invalid license number format (e.g. DL01 2024 1234567)"
    )
    private String licenseNumber;

    @NotBlank(message = "Driver name is required")
    @Size(max = 255, message = "Name must not exceed 255 characters")
    private String name;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Invalid phone number format")
    private String phone;

    @NotNull(message = "Office ID is required")
    private Integer officeId;

    @NotNull(message = "Address is required")
    @Valid                              // cascades validation into AddressRequest
    private AddressRequest address;
}