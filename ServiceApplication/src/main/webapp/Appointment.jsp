<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.serviceprovider.ServiceProvider.*" %>
    <%@ page import="com.serviceprovider.Admin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Appointment</title>
</head>
<body>
  <%AdminBean ab=new AdminBean();
 int sp_id=Integer.parseInt(request.getParameter("choice"));
  
 
int cid=(Integer)(session.getAttribute("cid"));
ab.setCust_id(cid);
ServiceProviderBean sb=new ServiceProviderBean();
ServiceProviderDAO sdao=new ServiceProviderDAO();
String time[]=sdao.getTimings(sp_id);
 %> Service Provider is available from : <%=time[0] %>
 To : <%=time[1] %><br>
 <div class="Detailsdisplay">
 <form action-"Appointmentsuccess.jsp">
 Select timing to book appointment : <input type="time" value="10:30" name="time">
 <%String timereq=request.getParameter("time");
 ab.setTime(timereq);%>
 <input type="date" min="2017-03-21" name="date">
 <%String date=request.getParameter("date");
 ab.setDate(date);
 session.setAttribute("adminobj", ab);%>
 <button type="submit">Book Appointment</button> 
 </form>
 </div>
 
</body>
</html>