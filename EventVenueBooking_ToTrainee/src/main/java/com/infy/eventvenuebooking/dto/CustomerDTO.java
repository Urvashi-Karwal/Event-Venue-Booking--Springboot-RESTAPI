package com.infy.eventvenuebooking.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDTO {

	private Integer customerId;
	
	@NotNull(message = "{customer.name.notpresent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{customer.name.invalid}")
	private String customerName;
	
	@NotNull(message = "{customer.emailid.notpresent}")
	@Pattern(regexp = "([a-z]+)@abc.com", message = "{customer.emailid.invalid}")
	private String emailId;

	@NotNull(message = "{customer.eventdate.notpresent}")
	@Future(message = "{customer.eventdate.invalid}")
	private LocalDate eventDate;
	
	@NotNull(message = "{customer.eventname.notpresent}")
	@Pattern(regexp = "Workshop|Concert|Meeting", message = "{customer.eventname.invalid}")
	private String eventName;
	
	@NotNull(message = "{customer.event.notpresent}")
	@Valid
	private EventDTO eventDTO;

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public EventDTO getEventDTO() {
		return eventDTO;
	}
	public void setEventDTO(EventDTO eventDTO) {
		this.eventDTO = eventDTO;
	}
}
