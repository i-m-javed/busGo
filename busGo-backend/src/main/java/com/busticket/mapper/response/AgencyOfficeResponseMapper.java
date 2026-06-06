package com.busticket.mapper.response;

import org.springframework.stereotype.Component;

import com.busticket.dto.response.AgencyOfficeResponse;
import com.busticket.entity.Agency;
import com.busticket.entity.AgencyOffice;

@Component
public class AgencyOfficeResponseMapper {

    public static AgencyOfficeResponse entityToResponse(AgencyOffice office) {
        return AgencyOfficeResponse.builder()
                .officeId(office.getOfficeId())
                .agencyId(office.getAgency().getAgencyId())
                .agencyName(office.getAgency().getName())
                .officeMail(office.getOfficeMail())
                .officeContactPersonName(office.getOfficeContactPersonName())
                .officeContactNumber(office.getOfficeContactNumber())
                .address(AddressResponseMapper.entityToResponse(office.getAddress()))
                .build();
    }

    public static AgencyOffice responseToEntity(AgencyOfficeResponse response) {
        AgencyOffice office = new AgencyOffice();
        office.setOfficeId(response.getOfficeId());
        office.setOfficeMail(response.getOfficeMail());
        office.setOfficeContactPersonName(response.getOfficeContactPersonName());
        office.setOfficeContactNumber(response.getOfficeContactNumber());
        office.setAddress(AddressResponseMapper.responseToEntity(response.getAddress()));

        Agency agency = new Agency();
        agency.setAgencyId(response.getAgencyId());
        agency.setName(response.getAgencyName());
        office.setAgency(agency);

        return office;
    }
}
