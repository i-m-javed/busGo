package com.busticket.mapper.request;

import com.busticket.dto.request.AddressRequest;
import com.busticket.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressRequestMapper {

    public Address requestToEntity(AddressRequest dto) {
        if (dto == null) return null;

        Address address = new Address();
        address.setAddress(dto.getAddress());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());

        return address;
    }

    public AddressRequest entityToRequest(Address entity) {
        if (entity == null) return null;

        AddressRequest dto = new AddressRequest();
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZipCode(entity.getZipCode());

        return dto;
    }
}