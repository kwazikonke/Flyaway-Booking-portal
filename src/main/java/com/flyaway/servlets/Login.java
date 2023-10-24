package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.flyaway.models.Registration;
import com.flyaway.services.RegistrationOps;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname= request.getParameter("txtUname");
		String pwd = request.getParameter("txtPwd");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		if(uname.equalsIgnoreCase("Admin")&& pwd.equals("admin@123")) {
			session.setAttribute("user", "Administrator");
			response.sendRedirect("AdminDashboard.html");
		}
		else {
			RegistrationOps ro = new RegistrationOps();
			Registration reg = ro.CheckUser(uname, pwd);
			if(reg!=null) {
			 session.setAttribute("registrationid", reg.getRegistrationid());
			 response.sendRedirect("IndexFlight");
			}
			else {
				out.print("<p style='text-align:center'>Error: Please check your username and password</p>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
			
		}
	}

}
