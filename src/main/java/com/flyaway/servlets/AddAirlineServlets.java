package com.flyaway.servlets;

import java.io.IOException;

import com.flyaway.models.Airlines;
import com.flyaway.services.AirlinesOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAirlineServlets
 */
@WebServlet("/AddAirlineServlets")
public class AddAirlineServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddAirlineServlets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String airname = request.getParameter("txtAirName");
		String fligthno = request.getParameter("txtFlightNo");
		
		response.setContentType("text/html");
		AirlinesOps ao = new AirlinesOps();
		Airlines al = new Airlines();
		
		try {
			al.setAirlinesname(airname);
			al.setFlightno(fligthno);
			
			String result= ao.AddAirline(al);
			if (result.equals("Success")){
				response.sendRedirect("IndexAirlines");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
