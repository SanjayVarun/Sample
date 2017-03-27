package com.Service.ServletController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.serviceprovider.login.LoginDAO;
import com.serviceprovider.login.LoginDetailsApp;
import com.serviceprovider.login.LoginDetailsBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDetailsApp lapp=new LoginDetailsApp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		HttpSession session=request.getSession(true);
		PrintWriter out=response.getWriter();
		LoginDAO ldao=new LoginDAO();
		LoginDetailsBean lb=new LoginDetailsBean();
		String type=request.getParameter("radio1");
System.out.println(type);
		 if(type.equals("2"))
		{
			
			lb.setType(2);
			
		}
		else if(type.equals("1"))
		{
			
			lb.setType(1);
			
		}
		 String username=request.getParameter("usernamefield"); 
		 session.setAttribute("uname", username);
		 lb.setUsername(username);
		 System.out.println(lb.getUsername());
		 String pwd=request.getParameter("passwordfield");
		 lb.setPassword(pwd);
				
			boolean c=ldao.check(lb);
			if(c && lb.getType()==2)
			{
				RequestDispatcher rd=request.getRequestDispatcher("ServiceProviderHomePage.jsp");
				rd.forward(request, response);
			}
			else if(c && lb.getType()==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("CustomerHomePage.jsp");
				rd.forward(request, response);
			}
			else 
			{
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('User or password incorrect');");
				   out.println("location='Home.html';");
				   out.println("</script>");
				
			}

	}

}
