package com.busticket.mapper.request;

import com.busticket.dto.request.DriverRequest;
import com.busticket.entity.AgencyOffice;
import com.busticket.entity.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverRequestMapper {

    private final AddressRequestMapper addressRequestMapper;

    public DriverRequestMapper(AddressRequestMapper addressRequestMapper) {
        this.addressRequestMapper = addressRequestMapper;
    }

    public Driver requestToEntity(DriverRequest request) {
        Driver driver = new Driver();
        driver.setLicenseNumber(request.getLicenseNumber());
        driver.setName(request.getName());
        driver.setPhone(request.getPhone());
        driver.setAddress(addressRequestMapper.requestToEntity(request.getAddress()));

        AgencyOffice agencyOffice = new AgencyOffice();
        agencyOffice.setOfficeId(request.getOfficeId());
        driver.setAgencyOffice(agencyOffice);

        return driver;
    }

    public DriverRequest entityToRequest(Driver driver) {
        DriverRequest request = new DriverRequest();
        request.setLicenseNumber(driver.getLicenseNumber());
        request.setName(driver.getName());
        request.setPhone(driver.getPhone());
        request.setOfficeId(driver.getAgencyOffice().getOfficeId());
        request.setAddress(addressRequestMapper.entityToRequest(driver.getAddress()));
        return request;
    }
}