<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.serviceprovider.ServiceProvider.ServiceProviderDAO"%>
<%@ page import="com.serviceprovider.ServiceProvider.ServiceProviderBean"%>

<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Service Provider Home </title>
<link rel="stylesheet" href="ServiceProviderHomePage.css">
</head>
<body>
<div id="Fullpage" class="Fullpage">
<ul>
  <li><a class="active" href="#home">Home</a></li>
  <li><a class="Requests" href="Requests.jsp">Requests</a></li>
  <li><a href="Feedback.jsp">Feedback</a></li>
</ul>
<div id="home">
<div class="Details">
<% 

List<ServiceProviderBean> list=new ArrayList<ServiceProviderBean>();
//ServiceProviderBean s1=new ServiceProviderBean();
ServiceProviderDAO sd=new ServiceProviderDAO();

list=sd.display((String)session.getAttribute("uname"));
String[] n;
for(ServiceProviderBean s : list)
{
	session.setAttribute("spid",s.getService_provider_id()); 
%>
	<table>
	<tr>
	<td>Name:</td>
	<td><%=s.getService_provider_name()%></td></tr>
	<tr>
	<td>Phone number :</td>
	<td><%=s.getService_provider_phone_number() %></td>
	</tr>
	<tr>
	<td>Location:</td>
	<td><%=s.getService_provider_location() %></td>
	</tr>
	<tr>
	<td>You offer : </td>
	<td><%=s.getService_Type()%></td>
	</tr>
	</table>
	

<%}%>
</div>
</div>


</div>


</body>
</html>