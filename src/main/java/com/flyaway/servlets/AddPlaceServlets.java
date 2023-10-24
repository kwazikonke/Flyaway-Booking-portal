package com.flyaway.servlets;

import java.io.IOException;

import com.flyaway.models.Places;
import com.flyaway.services.PlaceOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPlaceServlets
 */
@WebServlet("/AddPlaceServlets")
public class AddPlaceServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddPlaceServlets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String plcname = request.getParameter("txtPlaceName");
          String cityn  = request.getParameter("txtCity");
          String airpname = request.getParameter("txtAirport");
          
          response.setContentType("text/html");
  		  PlaceOps po = new PlaceOps();
  		  Places plc = new Places();
  		  
  		  try {
  			  plc.setPlacename(plcname);
  			  plc.setCityname(cityn);
  			  plc.setAirportname(airpname);
  			  
  			  String result = po.AddNewSource(plc);
  			  if(result.equals("Success")) {
  				  response.sendRedirect("IndexPlace");
  			  }
  		  }
  		  catch(Exception ex) {
  			  ex.printStackTrace();
  		  }
	}

}
