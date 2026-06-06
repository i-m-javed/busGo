package com.busticket.controller;

import com.busticket.dto.response.CustomerBookingPaymentResponse;
import com.busticket.dto.response.CustomerResponse;
import com.busticket.service.interfaces.ICustomerService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final ICustomerService customerService;
    
    public CustomerController(ICustomerService customerService) {
    	this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Integer id) {

        CustomerResponse response = customerService.getCustomerWithAddress(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/bookings-payments")
    public List<CustomerBookingPaymentResponse> getAllCustomerBookingsPayments() {
        return customerService.getCustomerBookingsPayments();
    }
}