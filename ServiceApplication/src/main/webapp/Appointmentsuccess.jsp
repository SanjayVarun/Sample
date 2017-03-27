<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.serviceprovider.Admin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment status</title>
</head>
<body>
<div class="AppointmentDetails">
<%AdminBean ab=(AdminBean)session.getAttribute("adminobj");%>
<p>Your details : </p>
<div class="Serviceproviderid">
<%=ab.getSp_id() %>
</div>
<div class="ServiceType">
<%=ab.getService_type() %>
</div>
<div class="Serviceproviderid">
<%=ab.getSp_id() %>
</div>
<div class="Serviceproviderid">
<%=ab.getSp_id() %>
</div>
</div>
</body>
</html>