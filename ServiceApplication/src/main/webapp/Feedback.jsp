<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.serviceprovider.Admin.*" %>
      <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Feedback</title>
<link rel="stylesheet" href="Feedback.css">
</head>
<body>
<div id="Fullpage" class="Fullpage">
<ul>
  <li><a class="Home" href="ServiceProviderhomePage.jsp">Home</a></li>
  <li><a class="Requests" href="Requests.jsp">Requests</a></li>
  <li><a class="active"href="#Feedback">Feedback</a></li>
</ul>
<div id="Feedback">
<table>
<tr>
<th>CustomerID</th>
<th>Feedback</th>
</tr>
<%AdminDAO adao=new AdminDAO();

int id=(Integer)session.getAttribute("spid");
ResultSet r=adao.viewFeedback(id);
AdminBean ab;
while(r.next())
{
	
	ab=new AdminBean();
  ab.setCust_id(r.getInt(2));%>
  <tr>
  <td><%=ab.getCust_id()%></td>
  <td><%=r.getString(1)%></td>
  <%} %>
  </tr>
  </table>
  </div>
  </div>
</body>
</html>