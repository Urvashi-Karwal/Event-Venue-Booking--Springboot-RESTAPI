package com.infy.eventvenuebooking;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.eventvenuebooking.dto.CustomerDTO;
import com.infy.eventvenuebooking.dto.EventDTO;
import com.infy.eventvenuebooking.repository.CustomerRepository;
import com.infy.eventvenuebooking.repository.EventRepository;
import com.infy.eventvenuebooking.service.EventService;
import com.infy.eventvenuebooking.service.EventServiceImpl;

//@SpringBootTest
public class EventVenueBookingApplicationTests {

//	@Mock
	private EventRepository eventRepository;
	
//	@Mock
	private CustomerRepository customerRepository;
	
//	@InjectMocks
	private EventService eventService = new EventServiceImpl();
	
	// DO NOT CHANGE METHOD SIGNATURE AND DELETE/COMMENT METHOD
//	@Test
	public void getCustomerByEventVenueNoCustomerFoundTest(){
		//your code goes here
		
	}
	
	
	// DO NOT CHANGE METHOD SIGNATURE AND DELETE/COMMENT METHOD
//	@Test
	public void registerCustomerEventVenueBookingClosedTest() {
		//your code goes here
//		EventDTO edto = new EventDTO();
//		edto.setEventId(1011);
//		edto.setEventName("Meeting");
//		edto.setVenue("ConferenceCentre");
//		edto.setSlotAvailable(null);
//		
//		CustomerDTO cdto = new CustomerDTO();
//		cdto.setCustomerId(1008);
//		cdto.setCustomerName("Jack");
//		cdto.setEmailId("jack@abc.com");
//		cdto.setEventDate(LocalDate.of(2022,12,20));
//		cdto.setEventName("Meeting");
//		
//		CustomerDTO cust = new CustomerDTO();
//		cust.setCustomerId(1011);
//		cust.setEventDTO(edto);
		
//		Mockito.when(eventRepository.findByVenue(null));
	}
	
}



