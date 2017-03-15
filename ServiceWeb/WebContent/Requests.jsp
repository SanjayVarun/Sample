<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.serviceprovider.Admin.*" %>
    <%@ page import="com.serviceprovider.customer.*" %>
    <%@ page import="java.util.*" %>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Requests</title>
<link rel="stylesheet" href="Requests.css">
</head>
<body>
<div id="Fullpage" class="Fullpage">
<ul>
  <li><a class="Home" href="ServiceProviderhomePage.jsp">Home</a></li>
  <li><a class="active" href="#Requests">Requests</a></li>
  <li><a href="Feedback.jsp">Feedback</a></li>
</ul>
<div id="Requests">
<table>
<tr>
<th>CustomerID</th>
<th> Customer Name</th>
<th>Customer Location </th>
<th>Requested Time </th>
</tr>
<%AdminDAO adao=new AdminDAO();

int id=(Integer)session.getAttribute("spid");
ResultSet r=adao.retrieveDetails(id);
AdminBean ab=null;
CustomerBean cb=null;
while(r.next())
{
	
	ab=new AdminBean();
cb=new CustomerBean();
  ab.setCust_id(r.getInt(1));%>
  <tr>
  <td><%=ab.getCust_id()%></td>
  
  
  <%cb.setCustomer_name(r.getString(2));%>
  
  <td><%=cb.getCustomer_name()%></td>
  
  <%cb.setLocation(r.getString(3));%>
 
  <td><%=cb.getLocation()%></td>
  
  <%ab.setTime(r.getString(4));%>
  
  <td><%=ab.getTime()%></td>
  </tr>
   
  
<%}%>

</table>
</div>
</div>	
</body>
</html>