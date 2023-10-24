package com.flyaway.servlets;

import java.io.IOException;

import com.flyaway.services.AirlinesOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAirline
 */
@WebServlet("/DeleteAirline")
public class DeleteAirline extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteAirline() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String Id= request.getParameter("aId");
		
		int aId=Integer.parseInt(Id);
		AirlinesOps ao = new AirlinesOps();
		if(ao.DeleteAirline(aId).equals("Success"))
		{
			response.sendRedirect("IndexAirlines");
		}
	}

}
