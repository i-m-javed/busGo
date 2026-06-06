package com.busticket.service.interfaces;

import java.util.List;

import com.busticket.dto.response.CustomerBookingPaymentResponse;

public interface IPaymentService {
	public List<CustomerBookingPaymentResponse> getCustomerBookingsPayments();
}
