package com.flyaway.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flyaway.dbconn.DbConnection;
import com.flyaway.models.Booking;
import com.flyaway.models.Flight;
import com.flyaway.models.Registration;
import com.flyaway.services.FlightOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookFlight
 */
@WebServlet("/BookFlight")
public class BookFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookFlight() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 FlightOps fo = new FlightOps();
	       
		 try {
			
				int registrationid = 0;
				//= Integer.parseInt(request.getParameter("txtregid"));
		        int flightid = 0;
		        //= Integer.parseInt(request.getParameter("txtflightid"));
		        int passenger = Integer.parseInt(request.getParameter("txtpassenger"));
		
		      // Retrieve the User and Flight objects associated with this Booking
				 Registration registration = getUserById(registrationid); 
				 Flight flight = getFlightById(flightid); 
				 
				   Booking booking = new Booking();
				   
				// Set the user and flight IDs in the Booking object
				    booking.setRegistrationid(registrationid);
				    booking.setFlightid(flightid);
				    booking.setPassenger(passenger);
				    
				 // Associate the User and Flight objects with the Booking
					booking.setRegistration(registration);
					booking.setFlight(flight);
					
					// Insert the booking into the database
					 fo.bookFlight(booking);
					 
		         response.sendRedirect("booking_conf.html");
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	}

	private Flight getFlightById(int flightid) {
		Connection conObj = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
        Flight fl = null;
		try {
			conObj = DbConnection.getConnection();
            String sql = "SELECT * FROM flight WHERE flightid = ?";
            ps = conObj.prepareStatement(sql);
            ps.setInt(1, flightid);
            rs = ps.executeQuery();

            if (rs.next()) {
                fl = new Flight();
                fl.setFlightid(rs.getInt("flightid"));
                fl.setFlightno(rs.getString("flightno"));
                fl.setAirlinename(rs.getString("airlinename"));
                fl.setSource(rs.getString("source"));
                fl.setDestination(rs.getString("destination"));
                fl.setFlightprice(rs.getFloat("flightprice"));
                fl.setDepaturedate(rs.getString("depaturedate"));
                fl.setDepaturetime(rs.getString("depaturetime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conObj != null) {
                try {
                    conObj.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		return fl;
	}
	

	private Registration getUserById(int registrationid) {
		    
		    Connection conObj = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Registration registration = null;

	        try {
	        	conObj = DbConnection.getConnection();
	            String sql = "SELECT * FROM Registration WHERE registrationid = ?";
	            ps = conObj.prepareStatement(sql);
	            ps.setInt(1, registrationid);
	            rs = ps.executeQuery();

	            if (rs.next()) {
	            	registration = new Registration();
	            	registration.setRegistrationid(rs.getInt("registrationid"));
	            	registration.setFirstname(rs.getString("firstname"));
	            	registration.setLastname(rs.getString("lastname"));
	            	registration.setEmail(rs.getString("email"));
	            	registration.setPhone(rs.getString("phone"));
	            	registration.setPassword(rs.getString("password"));
	            	
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                try {
	                    rs.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (ps != null) {
	                try {
	                    ps.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (conObj != null) {
	                try {
	                	conObj.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return registration;
	}
 
}
