package com.infy.eventvenuebooking.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.eventvenuebooking.dto.CustomerDTO;
import com.infy.eventvenuebooking.dto.EventDTO;
import com.infy.eventvenuebooking.entity.Customer;
import com.infy.eventvenuebooking.entity.Event;
import com.infy.eventvenuebooking.exception.EventVenueBookingException;
import com.infy.eventvenuebooking.repository.CustomerRepository;
import com.infy.eventvenuebooking.repository.EventRepository;

@Service(value ="eventService")
@Transactional
public class EventServiceImpl implements EventService {
    
	@Autowired
	private EventRepository eventRepository;
    
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Integer registerCustomer(CustomerDTO customerDTO) throws EventVenueBookingException {
		// your code goes here
		Event event = eventRepository.findEventByVenue(customerDTO.getEventDTO().getVenue());
		if(event == null) {
			throw new EventVenueBookingException("Service.INVALID_EVENT_DETAILS");
		}
		if(event.getSlotAvailable() == null) {
			throw new EventVenueBookingException("Service.EVENT_VENUE_BOOKING_CLOSED");
		}
		List<Customer> customers = customerRepository.findCustomersByEmailId(customerDTO.getEmailId());
		if(!customers.isEmpty()) {
			throw new EventVenueBookingException("Service.CUSTOMER_ALREADY_REGISTERED");
		}
		Customer cust = new Customer();
		cust.setCustomerId(customerDTO.getCustomerId());
		cust.setCustomerName(customerDTO.getCustomerName());
		cust.setEmailId(customerDTO.getEmailId());
		cust.setEventDate(customerDTO.getEventDate());
		cust.setEventName(customerDTO.getEventName());
		cust.setEvent(event);
		
		Customer c = customerRepository.save(cust);
		event.setSlotAvailable(event.getSlotAvailable()-1);
				return c.getCustomerId();
	}
	
	@Override
	public List<CustomerDTO> getCustomerByEventVenue(String venue)
			throws EventVenueBookingException {
		// your code goes here
		List<Customer> customers = customerRepository.findCustomersByEventVenue(venue);
		if(customers.isEmpty()) {
			throw new EventVenueBookingException("Service.CUSTOMER_UNAVAILABLE");
		}
		List<CustomerDTO> customerDTO = new ArrayList();
		customers.forEach(customer -> {
			EventDTO eDTO = new EventDTO();
			eDTO.setEventId(customer.getEvent().getEventId());
			eDTO.setEventName(customer.getEvent().getEventName());
			eDTO.setVenue(customer.getEvent().getVenue());
			eDTO.setSlotAvailable(customer.getEvent().getSlotAvailable());
			
			CustomerDTO cDTO = new CustomerDTO();
			cDTO.setCustomerId(customer.getCustomerId());
			cDTO.setCustomerName(customer.getCustomerName());
			cDTO.setEmailId(customer.getEmailId());
			cDTO.setEventDate(customer.getEventDate());
			cDTO.setEventName(customer.getEventName());
			cDTO.setEventDTO(eDTO);
			customerDTO.add(cDTO);
		});
		return customerDTO.stream().sorted((cdto1, cdto2) -> cdto2.getEventDate().compareTo(cdto1.getEventDate()))
				.toList();
	}
}

