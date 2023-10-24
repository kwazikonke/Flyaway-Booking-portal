package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.flyaway.models.Places;
import com.flyaway.services.PlaceOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexPlace
 */
@WebServlet("/IndexPlace")
public class IndexPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IndexPlace() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		PlaceOps po = new PlaceOps();
		try {
			List<Places> list = po.ListPlace();
			out.print("<center><h2><u>Source Information</u></h2></center>");
			out.print("<a href='Logout'style='color:black'>Log out</a> &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp;<a href='AdminDashboard.html'style='color:black'>Dashboard</a> ");
			out.print("<br>");
			out.print("<br>");
			out.print("<table width=100% border='1'>");
			out.print("<tr><th>Source ID</th><th>Source Name</th><th>City Name</th><th>Airport Name</th></tr>");
			for (Places plc:list) {
				out.print("<tr>");
				out.print("<td>"+plc.getPlaceid()+"</td>");
				out.print("<td>"+plc.getPlacename()+"</td>");
				out.print("<td>"+plc.getCityname()+"</td>");
				out.print("<td>"+plc.getAirportname()+"</td>");
				out.print("<td><a href='DeleteSource?pId="+plc.getPlaceid()+"'>Delete</a></td>");
				
				out.print("</tr>");
			}
			out.print("</table>");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
