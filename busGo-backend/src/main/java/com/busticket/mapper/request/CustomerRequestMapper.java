package com.busticket.mapper.request;

import com.busticket.dto.request.CustomerRequest;
import com.busticket.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequestMapper {

    private final AddressRequestMapper addressRequestMapper;

    public CustomerRequestMapper(AddressRequestMapper addressRequestMapper) {
        this.addressRequestMapper = addressRequestMapper;
    }

    public Customer requestToEntity(CustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(addressRequestMapper.requestToEntity(request.getAddress()));
        return customer;
    }

    public CustomerRequest entityToRequest(Customer customer) {
        CustomerRequest request = new CustomerRequest();
        request.setName(customer.getName());
        request.setEmail(customer.getEmail());
        request.setPhone(customer.getPhone());
        request.setAddress(addressRequestMapper.entityToRequest(customer.getAddress()));
        return request;
    }
}