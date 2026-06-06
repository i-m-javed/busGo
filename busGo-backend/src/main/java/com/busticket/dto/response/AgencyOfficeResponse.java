package com.busticket.dto.response;

import com.busticket.dto.response.AddressResponse;
import lombok.Builder;
import lombok.Data;

// AgencyOfficeResponse.java
@Data
@Builder
public class AgencyOfficeResponse {

    private Integer officeId;

    // Agency summary (avoid full nesting to prevent circular refs)
    private Integer agencyId;
    private String agencyName;

    private String officeMail;
    private String officeContactPersonName;
    private String officeContactNumber;

    private AddressResponse address;         // full address object in response
}
