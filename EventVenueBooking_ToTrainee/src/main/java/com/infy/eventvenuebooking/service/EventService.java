package com.infy.eventvenuebooking.service;

import java.util.List;

import com.infy.eventvenuebooking.dto.CustomerDTO;
import com.infy.eventvenuebooking.exception.EventVenueBookingException;

public interface EventService {
	Integer registerCustomer(CustomerDTO customerDTO) throws EventVenueBookingException;
	List<CustomerDTO> getCustomerByEventVenue(String venue) throws EventVenueBookingException;
}
