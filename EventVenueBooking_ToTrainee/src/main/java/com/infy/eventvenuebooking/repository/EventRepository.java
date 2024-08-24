package com.infy.eventvenuebooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.eventvenuebooking.entity.Event;

public interface EventRepository extends CrudRepository<Event, Integer>{
	// your code goes here
	Event findEventByVenue(String venue);
}
