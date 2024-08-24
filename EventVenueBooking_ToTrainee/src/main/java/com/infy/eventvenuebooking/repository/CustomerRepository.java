package com.infy.eventvenuebooking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.eventvenuebooking.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	// your code goes here
	
	List<Customer> findCustomersByEventVenue(String venue);
	
	List<Customer> findCustomersByEmailId(String emailId);
}
