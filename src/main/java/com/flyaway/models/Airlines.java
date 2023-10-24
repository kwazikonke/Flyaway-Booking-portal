package com.flyaway.models;

public class Airlines {
	
	private int airlinesid;
	private String airlinesname;
	private String flightno;
	public Airlines() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airlines(int airlinesid, String airlinesname, String flightno) {
		super();
		this.airlinesid = airlinesid;
		this.airlinesname = airlinesname;
		this.flightno = flightno;
	}
	public int getAirlinesid() {
		return airlinesid;
	}
	public void setAirlinesid(int airlinesid) {
		this.airlinesid = airlinesid;
	}
	public String getAirlinesname() {
		return airlinesname;
	}
	public void setAirlinesname(String airlinesname) {
		this.airlinesname = airlinesname;
	}
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	@Override
	public String toString() {
		return "Airlines [airlinesid=" + airlinesid + ", airlinesname=" + airlinesname + ", flightno=" + flightno + "]";
	}
	
	
}
