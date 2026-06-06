package com.busticket.mapper.request;

import com.busticket.dto.request.AgencyOfficeRequest;
import com.busticket.dto.request.AddressRequest;
import com.busticket.entity.Agency;
import com.busticket.entity.AgencyOffice;
import com.busticket.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AgencyOfficeRequestMapper {

    private final AddressRequestMapper addressMapper;

    public AgencyOfficeRequestMapper(AddressRequestMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public AgencyOffice requestToEntity(AgencyOfficeRequest dto) {
        if (dto == null) return null;

        AgencyOffice office = new AgencyOffice();

        Agency agency = new Agency();
        agency.setAgencyId(dto.getAgencyId());
        office.setAgency(agency);

        office.setOfficeMail(dto.getOfficeMail());
        office.setOfficeContactPersonName(dto.getOfficeContactPersonName());
        office.setOfficeContactNumber(dto.getOfficeContactNumber());

        office.setAddress(addressMapper.requestToEntity(dto.getAddress()));

        return office;
    }

    public AgencyOfficeRequest entityToRequest(AgencyOffice entity) {
        if (entity == null) return null;

        AgencyOfficeRequest dto = new AgencyOfficeRequest();

        dto.setAgencyId(entity.getAgency().getAgencyId());
        dto.setOfficeMail(entity.getOfficeMail());
        dto.setOfficeContactPersonName(entity.getOfficeContactPersonName());
        dto.setOfficeContactNumber(entity.getOfficeContactNumber());
        dto.setAddress(addressMapper.entityToRequest(entity.getAddress()));

        return dto;
    }
}