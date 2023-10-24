package com.flyaway.servlets;

import java.io.IOException;

import com.flyaway.models.Registration;
import com.flyaway.services.RegistrationOps;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlets
 */
@WebServlet("/RegistrationServlets")
public class RegistrationServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationServlets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("txtFname");
		String lname = request.getParameter("txtLname");
		String email = request.getParameter("txtEmail");
		String phone = request.getParameter("txtPhone");
		String pwd = request.getParameter("txtPwd");
		
		response.setContentType("text/html");
		RegistrationOps ro = new RegistrationOps();
		Registration reg = new Registration();
		
		try {
			reg.setFirstname(fname);
			reg.setLastname(lname);
			reg.setEmail(email);
			reg.setPhone(phone);
			reg.setPassword(pwd);
			
			String result = ro.NewRegistration(reg);
			if(result.equals("Success")) {
				response.sendRedirect("SearchResult.html");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
