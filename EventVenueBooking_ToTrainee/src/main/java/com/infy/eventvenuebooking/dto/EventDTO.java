package com.infy.eventvenuebooking.dto;


public class EventDTO {

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
