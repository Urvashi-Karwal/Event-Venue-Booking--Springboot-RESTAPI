package com.infy.eventvenuebooking.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.eventvenuebooking.dto.CustomerDTO;
import com.infy.eventvenuebooking.exception.EventVenueBookingException;
import com.infy.eventvenuebooking.service.EventService;

@RestController
@RequestMapping("/event-api")
@Validated
public class EventAPI {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private Environment environment;
	
	// DO NOT CHANGE METHOD SIGNATURE AND DELETE/COMMENT METHOD
	
	@PostMapping(value = "/events")
	public ResponseEntity<String> registerCustomer(@Valid @RequestBody CustomerDTO customerDTO)
			throws EventVenueBookingException {
		Integer customerId = eventService.registerCustomer(customerDTO);
		String message = environment.getProperty("API.REGISTRATION_SUCCESS")+customerId;
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	// DO NOT CHANGE METHOD SIGNATURE AND DELETE/COMMENT METHOD
	
	@GetMapping("/events/{venue}")
	public ResponseEntity<List<CustomerDTO>> getCustomerByEventVenue(@PathVariable @Valid @Pattern(regexp = "AcademicVenue|Arena|ConferenceCentre", 
	       message = "{event.venue.invalid}") String venue)throws EventVenueBookingException {
		List<CustomerDTO> custDto = eventService.getCustomerByEventVenue(venue);
		return new ResponseEntity<List<CustomerDTO>>(custDto, HttpStatus.OK);
	}

	
}
