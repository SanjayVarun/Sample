<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"  %>
    <%@ page import="com.serviceprovider.ServiceProvider.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<label class="loclabel">Location</label>
<% String loc=request.getParameter("location");%>
<%=loc%>
<label class="servelabel">Service Type Requested : </label>
<% String servicetype=request.getParameter("profession");%>
<%=servicetype %>
<%ServiceProviderDAO sdao=new ServiceProviderDAO();
List<ServiceProviderBean> list=new ArrayList<ServiceProviderBean>();
list=sdao.search(loc, servicetype);%>
<div class="SearchDetails">
<table>
<tr>
<th rowspan="2">ServiceProvider ID</th>
<th rowspan="2">Name </th>
<th rowspan="2">Phone number </th>
<th rowspan="2">Location</th>
<th colspan="2">Work timings</th></tr>
<tr>
<th>From </th>
<th> To</th>
</tr>
<form action="Appointment.jsp">
<% for(ServiceProviderBean sb : list)
{%>

    <tr>
    <td><%=sb.getService_provider_id() %></td>
    <td><%=sb.getService_provider_name() %></td>
    <td><%=sb.getService_provider_phone_number() %></td>
    <td><%=sb.getService_provider_location() %></td>
    <td><%=sb.getService_provider_from_time() %></td>
    <td><%=sb.getService_provider_to_time() %></td>
   
    <td><input type="radio" name="choice" id="choice" value=<%=sb.getService_provider_id()%>></td>
	</tr>
	
 <% }
%>
<button type="submit">Submit</button>
</form>
</table>

</div>
</body>
</html>