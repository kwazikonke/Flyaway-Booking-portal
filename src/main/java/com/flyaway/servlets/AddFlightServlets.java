package com.flyaway.servlets;

import java.io.IOException;
//import java.util.Date;

import com.flyaway.models.Flight;
import com.flyaway.services.FlightOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddFlightServlets
 */
@WebServlet("/AddFlightServlets")
public class AddFlightServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddFlightServlets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flightno = request.getParameter("txtFno");
		String airlinename= request.getParameter("txtAirL");
		String source = request.getParameter("txtSource");
		String dest = request.getParameter("txtDest");
		Float price = Float.parseFloat(request.getParameter("txtPrice"));
		String depdate = request.getParameter("txtDate");
		String deptime = request.getParameter("txtTime");
		
		response.setContentType("text/html");
		FlightOps fo = new FlightOps();
		Flight fl = new Flight();
		
		try {
			fl.setFlightno(flightno);
			fl.setAirlinename(airlinename);
			fl.setSource(source);
			fl.setDestination(dest);
			fl.setFlightprice(price);
			fl.setDepaturedate(depdate);
			fl.setDepaturetime(deptime);
			
			String result = fo.AddFlight(fl);
			if(result.equals("Success")) {
				response.sendRedirect("IndexFlight");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
