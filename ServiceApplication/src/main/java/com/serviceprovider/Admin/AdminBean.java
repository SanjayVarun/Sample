package com.serviceprovider.Admin;

public class AdminBean {
String time;
int service_type;
int cust_id,sp_id;
String Date;
String feedback;
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
String status;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public int getService_type() {
	return service_type;
}
public void setService_type(int service_type) {
	this.service_type = service_type;
}
public int getCust_id() {
	return cust_id;
}
public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
}
public int getSp_id() {
	return sp_id;
}
public void setSp_id(int sp_id) {
	this.sp_id = sp_id;
}

}
