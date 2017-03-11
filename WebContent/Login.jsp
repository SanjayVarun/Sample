<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.serviceprovider.login.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="HomePage.css">
</head>
<body>
<div class="WholePage">
<div class="LoginContent">
<form method="post" action="Login.jsp">
<input type="radio" class="Serviceproviderradio" name="radio1" value=2> ServiceProvider
<input type="radio" class="Customerradio" name="radio1" value=1>Customer
<%
LoginDetailsBean lb=new LoginDetailsBean();
LoginDAO ldao=new LoginDAO();

/* String type=request.getParameter("radio1");

 if(type.equals("2"))
{
	
	lb.setType(2);
	
}
else if(type.equals("1"))
{
	
	lb.setType(1);
	
}  */  %>
<table>
<tr> 
<td> Username </td>
<td> : </td>
<td> <input type="text" class="usernamefield" name="Username"></td>
</tr>

<tr>
<td> Password </td>
<td> : </td>
<td> <input type="password" class="passwordfield" name="Password"> </td>
</tr> 

<tr>
<td> <input type="submit" value="Submit" class="submitbutton" name="Submit"> </td>
</tr>
</table>
<div class=registerlink>
<a href="Register.html"> Not a member? Register here!</a>
</div>
</form>
</div>

</div>
</body>

<%
lb=(LoginDetailsBean)request.getAttribute("bean");
boolean c=ldao.check(lb);
if(c)
{
	RequestDispatcher rd=request.getRequestDispatcher("ServiceProviderHomePage.jsp");
	rd.forward(request, response);
}
else
{
	RequestDispatcher rd=request.getRequestDispatcher("Homepage.html");
	rd.forward(request, response);
}

%>
