package com.busticket.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

// AgencyOfficeRequest.java
@Data
public class AgencyOfficeRequest {

    @NotNull(message = "Agency ID is required")
    private Integer agencyId;

    @Email(message = "Invalid email format")
    private String officeMail;

    @NotBlank(message = "Contact person name is required")
    private String officeContactPersonName;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Invalid contact number format")
    private String officeContactNumber;

    @NotNull(message = "Office address is required")
    private AddressRequest address;          // embedded — creates address inline
}
