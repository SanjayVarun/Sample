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
<script src="Controller.js"></script>
</head>
<body>
<div id="Fullpage" class="Fullpage">
<%
CustomerBean cb=new CustomerBean();
CustomerDAO cdao=new CustomerDAO();
cb=cdao.displayCustomerDetails((String)session.getAttribute("uname"));
session.setAttribute("cid", cb.getCustomer_id());
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
<div class="Buttons" ng-app="customerApp" ng-controller="customerCtrl">
<button type="Button" class="buttons" ng-click="search()">Search for service providers?</button>
<form action="Search.jsp">
<fieldset  ng-show="showTypes">
<div class="searchlocation">
Enter Location : <input type="text" class="location" name="location">
</div>
<div id="ServiceType" class="ServiceType"> 
Choose Service Types : 

<label for="ServiceType"> Service Type </label>
 <input type="radio" class="ServiceType" id="Elec" name="profession" value="Electrical">Electrical
 <input type="radio" class="ServiceType" id="Plumbing" name="profession" value="Plumbing"> Plumbing
 <input type="radio" class="ServiceType" id="PC" name="profession" value="PC Assist">PC Assist
 <input type="radio" class="ServiceType" id="Carpentry" name="profession" value="Carpentry">Carpentry 
 <input type="radio" class="ServiceType" id="Mechanic" name="profession" value="Mechanic"> Mechanic
 <input type="radio" class="ServiceType" id="Houseclean" name="profession" value="House Cleaning">House Cleaning 
</div>
<button type="submit">Search</button>
</fieldset>

</form>
</div>
</div>

</body>
</html>