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
 * Servlet implementation class SearchServlets
 */
@WebServlet("/SearchServlets")
public class SearchServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchServlets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  // Get search criteria from the request (travelDate, source, destination)
		 FlightOps fo = new FlightOps();
        try {
         
            // Retrieve flight search results
            String depdate = request.getParameter("txtdepDate");;
            String source = request.getParameter("txtsource");
            String destination = request.getParameter("txtdestination");
           
            List<Flight>searchResults = fo.searchFlights(depdate, source, destination);
            
            // Display the search results in the response
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("</br>");
            out.println("<center><h1>Flight Search Results</h1></center>");
            if (searchResults.isEmpty()) {
            	out.print("<a href='Logout'style='color:black'>Log out</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='SearchResult.html'style='color:black'>Dashboard</a> ");
    			out.print("<br>");
    			out.print("<br>");
    			out.println("<center><p style=\"text-align:center; width:100%;border: 2px solid black; background-color: skyblue;\">No flights found for the given criteria, please check with another search.</p></center>");
    			
    			
            } 
            else {
            	out.print("<a href='SearchResult.html'style='color:black'>Dashboard</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='IndexBooking'style='color:black'>View All Available Flights</a>  &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='Logout'style='color:black'>Log out</a>");
    			out.print("<br>");
    			out.print("<br>");
            	out.print("<table width=100% border='1'>");
    			out.print("<tr><th>Flight ID</th><th>Flight Number</th><th>Airline Name</th><th>Flight Price</th><th>Departure Time</th></tr>");
                for (Flight fl : searchResults) {
                	out.print("<tr>");
                	out.print("<td>"+fl.getFlightid()+"</td>");
                	out.print("<td>"+fl.getFlightno()+"</td>");
    				out.print("<td>"+fl.getAirlinename()+"</td>");
    				out.print("<td>"+fl.getFlightprice()+"</td>");
    				out.print("<td>"+fl.getDepaturetime()+"</td>");
    				
    				out.print("<td><a href='bookFlight?registrationid="+fl.getFlightid()+"'>Book Flight</a></td>");
    				
    				out.print("</tr>");
    			}
    			out.print("</table>");	
            }
        } catch (Exception ex) {
          ex.printStackTrace();
        } 

	}
}
