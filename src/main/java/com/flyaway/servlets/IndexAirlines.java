package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.flyaway.models.Airlines;
import com.flyaway.services.AirlinesOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexAirlines
 */
@WebServlet("/IndexAirlines")
public class IndexAirlines extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IndexAirlines() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		AirlinesOps ao = new AirlinesOps();
		try {
			List<Airlines> list = ao.ListAirlines();
			out.print("<center><h2><u>Airline's Information</u></h2></center>");
			out.print("<a href='Logout'style='color:black'>Log out</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='AdminDashboard.html'style='color:black'>Dashboard</a> ");
			out.print("<br>");
			out.print("<br>");
			out.print("<table width=100% border='1'>");
		    out.print("<tr><th>Airline ID</th><th>Airline Name</th><th>Flight Number</th></tr>");
			for (Airlines al:list) {
				out.print("<tr>");
				out.print("<td>"+al.getAirlinesid()+"</td>");
				out.print("<td>"+al.getAirlinesname()+"</td>");
				out.print("<td>"+al.getFlightno()+"</td>");
				out.print("<td><a href='DeleteAirline?aId="+al.getAirlinesid()+"'>Delete</a></td>");
			//	out.print("<td><a href='UpdatingAirline?aId="+al.getAirlinesid()+"'>Update</a></td>");
				
				out.print("</tr>");
			}
			out.print("</table>");	
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
			
	}

}
