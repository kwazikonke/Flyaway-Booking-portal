package com.flyaway.servlets;

import java.io.IOException;
import com.flyaway.services.PlaceOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletePlace
 */
@WebServlet("/DeletePlace")
public class DeletePlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeletePlace() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		String Id= request.getParameter("pId");
		
		int pId=Integer.parseInt(Id);
		PlaceOps po = new PlaceOps();
		if(po.DeleteSource(pId).equals("Success"))
		{
			response.sendRedirect("IndexPlace");
		}
	}

}
