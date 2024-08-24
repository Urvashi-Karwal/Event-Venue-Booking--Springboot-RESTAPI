package com.infy.eventvenuebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infy.eventvenuebooking.exception.EventVenueBookingException;

@SpringBootApplication
public class EventVenueBookingApplication{

	public static void main(String[] args) throws EventVenueBookingException{
			
		SpringApplication.run(EventVenueBookingApplication.class, args);
	}
}