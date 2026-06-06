package com.busticket.mapper.request;

import com.busticket.dto.request.AgencyRequest;
import com.busticket.entity.Agency;
import org.springframework.stereotype.Component;

@Component
public class AgencyRequestMapper {

    public Agency requestToEntity(AgencyRequest dto) {
        if (dto == null) return null;

        Agency agency = new Agency();
        agency.setName(dto.getName());
        agency.setContactPersonName(dto.getContactPersonName());
        agency.setEmail(dto.getEmail());
        agency.setPhone(dto.getPhone());

        return agency;
    }

    public AgencyRequest entityToRequest(Agency entity) {
        if (entity == null) return null;

        AgencyRequest dto = new AgencyRequest();
        dto.setName(entity.getName());
        dto.setContactPersonName(entity.getContactPersonName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());

        return dto;
    }
}