package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.flyaway.models.Flight;
import com.flyaway.services.FlightOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexBooking
 */
@WebServlet("/IndexBooking")
public class IndexBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IndexBooking() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		FlightOps fo = new FlightOps();
		try {
			List<Flight> list = fo.ListFlight();
			out.print("<center><h2><u>Flight's Information</u></h2></center>");
			out.print("<a href='Logout'style='color:black'>Log out</a>");
			out.print("<br>");
			out.print("<br>");
			out.print("<table width=100% border='1'>");
			out.print("<tr><th>Flight ID</th><th>Flight Number</th><th>Airline Name</th><th>Source Name</th><th>Destination</th><th>Flight Price</th><th>Departure Date</th><th>Departure Time</th></tr>");
			for (Flight fl:list) {
				out.print("<tr>");
				out.print("<td>"+fl.getFlightid()+"</td>");
				out.print("<td>"+fl.getFlightno()+"</td>");
				out.print("<td>"+fl.getAirlinename()+"</td>");
				out.print("<td>"+fl.getSource()+"</td>");
				out.print("<td>"+fl.getDestination()+"</td>");
				out.print("<td>"+fl.getFlightprice()+"</td>");
				out.print("<td>"+fl.getDepaturedate()+"</td>");
				out.print("<td>"+fl.getDepaturetime()+"</td>");
				
				out.print("<td><a href='bookFlight?registrationid="+fl.getFlightid()+"'>Book</a></td>");
				
				out.print("</tr>");
			}
			out.print("</table>");	
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}


}
