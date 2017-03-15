package com.serviceprovider.ServiceProvider;

import java.util.List;

public class ServiceProviderBean {

	private String service_provider_name;
	private String sp_uname;
	public String getSp_uname() {
		return sp_uname;
	}
	public void setSp_uname(String sp_uname) {
		this.sp_uname = sp_uname;
	}
	public String getService_provider_from_time() {
		return service_provider_from_time;
	}
	public void setService_provider_from_time(String service_provider_from_time) {
		this.service_provider_from_time = service_provider_from_time;
	}
	public String getService_provider_to_time() {
		return service_provider_to_time;
	}
	public void setService_provider_to_time(String service_provider_to_time) {
		this.service_provider_to_time = service_provider_to_time;
	}
	private int service_provider_id;
	private String service_provider_phone_number;
	private String service_provider_location,service_provider_from_time,service_provider_to_time;
	private String Service_Type;
	public String getService_provider_name() {
		return service_provider_name;
	}
	public void setService_provider_name(String service_provider_name) {
		this.service_provider_name = service_provider_name;
	}
	public int getService_provider_id() {
		return service_provider_id;
	}
	public void setService_provider_id(int service_provider_id) {
		this.service_provider_id = service_provider_id;
	}
	public String getService_provider_phone_number() {
		return service_provider_phone_number;
	}
	public void setService_provider_phone_number(String service_provider_phone_number2) {
		this.service_provider_phone_number = service_provider_phone_number2;
	}
	public String getService_provider_location() {
		return service_provider_location;
	}
	public void setService_provider_location(String service_provider_location) {
		this.service_provider_location = service_provider_location;
	}
	public String getService_Type() {
		return Service_Type;
	}
	public void setService_Type(String service_Type2) {
		Service_Type = service_Type2;
	}
	
	
}
