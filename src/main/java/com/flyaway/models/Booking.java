package com.flyaway.models;

public class Booking {

	private int registrationid;
	//private int bookingid;
	private int passenger;
	private int flightid;
	private Registration registration;
	private Flight flight;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int registrationid, int passenger, int flightid,Registration registration, Flight flight) {
		super();
		this.registrationid = registrationid;
		//this.bookingid = bookingid;
		this.passenger = passenger;
		this.flightid = flightid;
		this.registration = registration;
		this.flight = flight;
	}
	
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public int getRegistrationid() {
		return registrationid;
	}
	public void setRegistrationid(int registrationid) {
		this.registrationid = registrationid;
	}
	
	public int getPassenger() {
		return passenger;
	}
	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}


}
