package com.infy.eventvenuebooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
//	@Column(name = "eventId")
	private Integer eventId;
	private String eventName;
	private String venue;
	private Integer slotAvailable;
	
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public Integer getSlotAvailable() {
		return slotAvailable;
	}
	public void setSlotAvailable(Integer slotAvailable) {
		this.slotAvailable = slotAvailable;
	}
	
}
