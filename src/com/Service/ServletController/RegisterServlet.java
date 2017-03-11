package com.Service.ServletController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceprovider.ServiceProvider.ServiceProviderBean;
import com.serviceprovider.customer.CustomerBean;
import com.serviceprovider.login.LoginDetailsApp;
import com.serviceprovider.login.LoginDetailsBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		ServiceProviderBean sb=null;
		CustomerBean cb=null;
		PrintWriter out=response.getWriter();
		LoginDetailsBean lb=new LoginDetailsBean();
		LoginDetailsApp lapp=new LoginDetailsApp();
		
		lb.setUsername(request.getParameter("Username"));
		lb.setPassword(request.getParameter("Password"));
		String type=request.getParameter("radio");
		
		if(type.equals("ServiceProvider"))
		{
			System.out.println("inside servlet");
			sb=new ServiceProviderBean();
			sb.setService_provider_name(request.getParameter("Name"));
			sb.setService_provider_phone_number(request.getParameter("Phonenumber"));
			sb.setService_provider_location(request.getParameter("Location"));
			sb.setService_provider_from_time(request.getParameter("from"));
			sb.setService_provider_to_time(request.getParameter("to"));
			sb.setService_Type(request.getParameter("profession"));

			lb.setType(2);
			
		}
		else if(type.equals("Customer"))
		{
			cb=new CustomerBean();
			cb.setCustomer_name(request.getParameter("Name"));
			cb.setPhone_number(request.getParameter("Phonenumber"));
			cb.setLocation(request.getParameter("Location"));
			cb.setAddress(request.getParameter("Address"));
			cb.setEmail_id(request.getParameter("Email"));
			lb.setType(1);
		}
	String s=LoginDetailsApp.signupdetails(lb,cb,sb);
	System.out.println(s);
	if(s.equals("Not valid"))
	{
		out.println("Credentials not valid");
		RequestDispatcher rd=request.getRequestDispatcher("Register.html");
		rd.forward(request, response);

	}
	else if(s.equals("Already registered"))
	{
		out.println("You are already a registered user! Login to continue!");
		RequestDispatcher rd=request.getRequestDispatcher("Homepage.html");
		rd.forward(request, response);
	}
	else
	{
		RequestDispatcher rd=request.getRequestDispatcher("ServiceProviderHomePage.jsp");
		rd.forward(request, response);
	}
		
	}
	}


