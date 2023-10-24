package com.flyaway.servlets;

import java.io.IOException;
import com.flyaway.services.FlightOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteFlight
 */
@WebServlet("/DeleteFlight")
public class DeleteFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteFlight() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
		
		String Id= request.getParameter("fId");
		
		int fId=Integer.parseInt(Id);
		FlightOps fo = new FlightOps();
		if(fo.DeleteFlight(fId).equals("Success"))
		{
			response.sendRedirect("IndexFlight");
		}
	}

}
