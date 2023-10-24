package com.flyaway.models;

public class Places {

	private int placeid; 
	private String placename;
	private String cityname; 
	private String airportname;
	
	public Places() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Places(int placeid, String placename, String cityname, String airportname) {
		super();
		this.placeid = placeid;
		this.placename = placename;
		this.cityname = cityname;
		this.airportname = airportname;
	}

	public int getPlaceid() {
		return placeid;
	}

	public void setPlaceid(int placeid) {
		this.placeid = placeid;
	}

	public String getPlacename() {
		return placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getAirportname() {
		return airportname;
	}

	public void setAirportname(String airportname) {
		this.airportname = airportname;
	}

	@Override
	public String toString() {
		return "Place [placeid=" + placeid + ", placename=" + placename + ", cityname=" + cityname + ", airportname="
				+ airportname + "]";
	}
	
}
