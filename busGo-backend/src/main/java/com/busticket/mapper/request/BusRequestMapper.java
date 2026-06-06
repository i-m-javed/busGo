package com.busticket.mapper.request;

import com.busticket.dto.request.BusRequest;
import com.busticket.entity.AgencyOffice;
import com.busticket.entity.Bus;
import org.springframework.stereotype.Component;

@Component
public class BusRequestMapper {

    public Bus requestToEntity(BusRequest dto) {
        if (dto == null) return null;

        Bus bus = new Bus();

        AgencyOffice office = new AgencyOffice();
        office.setOfficeId(dto.getOfficeId());

        bus.setOffice(office);
        bus.setRegistrationNumber(dto.getRegistrationNumber());
        bus.setCapacity(dto.getCapacity());
        bus.setType(dto.getType());

        return bus;
    }

    public BusRequest entityToRequest(Bus entity) {
        if (entity == null) return null;

        BusRequest dto = new BusRequest();
        dto.setOfficeId(entity.getOffice().getOfficeId());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        dto.setCapacity(entity.getCapacity());
        dto.setType(entity.getType());

        return dto;
    }
}