package com.flyaway.models;

//import java.util.Date;

public class Flight {

	private int flightid; 
	private String flightno; 
	private String airlinename;
	private String source; 
	private String destination; 
	private Float flightprice;
	private String depaturedate;
	private String depaturetime;
	
	
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Flight(int flightid, String flightno,String airlinename, String source, String destination, Float flightprice,
			String depaturedate, String depaturetime) {
		super();
		this.flightid = flightid;
		this.flightno = flightno;
		this.airlinename=airlinename;
		this.source = source;
		this.destination = destination;
		this.flightprice = flightprice;
		this.depaturedate = depaturedate;
		this.depaturetime = depaturetime;
	}


	public int getFlightid() {
		return flightid;
	}


	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}


	public String getFlightno() {
		return flightno;
	}


	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}
	public String getAirlinename() {
		return airlinename;
	}


	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	

	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Float getFlightprice() {
		return flightprice;
	}


	public void setFlightprice(Float flightprice) {
		this.flightprice = flightprice;
	}


	public String getDepaturedate() {
		return depaturedate;
	}


	public void setDepaturedate(String depdate) {
		this.depaturedate = depdate;
	}


	public String getDepaturetime() {
		return depaturetime;
	}


	public void setDepaturetime(String depaturetime) {
		this.depaturetime = depaturetime;
	}


	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", flightno=" + flightno + ", airlinename=" + airlinename + ", source="
				+ source + ", destination=" + destination + ", flightprice=" + flightprice + ", depaturedate="
				+ depaturedate + ", depaturetime=" + depaturetime + "]";
	}


	
}