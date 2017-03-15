<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.serviceprovider.customer.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="CustomerHome.js"></script>
</head>
<body>
<div id="Fullpage" class="Fullpage">
<%
CustomerBean cb=new CustomerBean();
CustomerDAO cdao=new CustomerDAO();
cb=cdao.displayCustomerDetails((String)session.getAttribute("uname"));

%>
<div class="Details">
<table>
	<tr>
	<td>Name:</td>
	<td><%=cb.getCustomer_name()%></td></tr>
	<tr>
	<td>Phone number :</td>
	<td><%=cb.getPhone_number() %></td>
	</tr>
	<tr>
	<td>Email - id : </td>
	<td><%=cb.getEmail_id()%></td>
	</tr>
	<tr>
	<td>Location:</td>
	<td><%=cb.getLocation() %></td>
	</tr>
	<tr>
	<td>Address : </td>
	<td><%=cb.getAddress() %></td>
	</tr>
	
	</table>
	
</div>
<div class="Buttons">
<form action="Search.jsp">
<button type="Button" class="buttons">Search for service providers?</button>
</form>
</div>
</div>

</body>
</html>