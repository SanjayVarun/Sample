package com.serviceprovider.login;
public class LoginDetailsBean {
String username;
String password;
int type;
public  LoginDetailsBean(){
	type=10;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}
