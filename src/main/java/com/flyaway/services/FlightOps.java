package com.flyaway.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flyaway.dbconn.DbConnection;
import com.flyaway.models.Booking;
import com.flyaway.models.Flight;

public class FlightOps {

	private Connection conObj = null;
	
	public FlightOps() {
		conObj = DbConnection.getConnection();
	}
	// Adding flights
		public String AddFlight (Flight fl) {
			String result = "Error";
			try {
				String sql = "Insert into Flight(flightno,airlinename,source,destination,flightprice,depaturedate,depaturetime) values(?,?,?,?,?,?,?)";
				PreparedStatement ps = conObj.prepareStatement(sql);
				
				ps.setString(1, fl.getFlightno());
				ps.setString(2, fl.getAirlinename());
				ps.setString(3, fl.getSource());
				ps.setString(4,fl.getDestination());
				ps.setFloat(5, fl.getFlightprice());
				ps.setString(6, fl.getDepaturedate());
				ps.setString(7, fl.getDepaturetime());
				int res = ps.executeUpdate();
				if (res>=1) {
					result = "Success";}
			}
			catch(Exception ex) {
				result= ex.getMessage();
				ex.printStackTrace();
			}
			return result;
		}
		
		// Deleting flight
		
		public String DeleteFlight(int flightid) {
			String result ="Error";
			try {
				String sql= "Delete from Flight where flightid=?";
				PreparedStatement ps = conObj.prepareStatement(sql);
				ps.setInt(1, flightid);
				int r =ps.executeUpdate();
				
				if (r>=1) {
					result="Success";
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				result = ex.getMessage();
			}
			return result;
		}	
	
		// List of Flights
		public List<Flight> ListFlight(){
			List<Flight> list = new ArrayList<Flight>();
			
			Flight fl = null;
			
			try {
				String sql = "select * from Flight";
				PreparedStatement ps = conObj.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					fl = new Flight();
					fl.setFlightid(rs.getInt("flightid"));
					fl.setFlightno(rs.getString("flightno"));
					fl.setAirlinename(rs.getString("airlinename"));
					fl.setSource(rs.getString("source"));
					fl.setDestination(rs.getString("destination"));
					fl.setFlightprice(rs.getFloat("flightprice"));
					fl.setDepaturedate(rs.getString("depaturedate"));
					fl.setDepaturetime(rs.getString("depaturetime"));
					list.add(fl);
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return list;
		}	
	// Book Flight
		public void bookFlight(Booking booking) {
	
		    try {
		        String sql = "INSERT INTO Booking (registrationid, flightid, passenger) VALUES (?, ?, ?)";
		        PreparedStatement ps = conObj.prepareStatement(sql);
		        ps.setInt(1, booking.getRegistrationid());
		        ps.setInt(2, booking.getFlightid());
		        ps.setInt(3, booking.getPassenger());
		        ps.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

	
		// Searching for Flights
		public List<Flight> searchFlights(String depaturedate, String source, String destination) {
	        List<Flight> flights = new ArrayList<>();
	        try {
	            String sql = "SELECT * FROM flight WHERE depaturedate = ? AND source = ? AND destination = ?";
	            PreparedStatement ps = conObj.prepareStatement(sql);
	            ps.setString(1,depaturedate);
	            ps.setString(2, source);
	            ps.setString(3, destination);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Flight fl = new Flight();
	                fl.setFlightid(rs.getInt("flightid"));
	                fl.setFlightno(rs.getString("flightno"));
	                fl.setAirlinename(rs.getString("airlinename"));
	                fl.setFlightprice(rs.getFloat("flightprice"));
	                fl.setDepaturetime(rs.getString("depaturetime"));
	                
	                flights.add(fl);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return flights;
	    }
}
