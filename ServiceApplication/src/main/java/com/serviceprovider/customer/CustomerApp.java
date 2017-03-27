package com.serviceprovider.customer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.serviceprovider.Admin.AdminApp;
import com.serviceprovider.Admin.AdminBean;
import com.serviceprovider.Admin.AdminDAO;
import com.serviceprovider.ServiceProvider.*;
import com.serviceprovider.login.LoginDetailsApp;

public class CustomerApp {
	String name,address,location,email_id,phone_number;
	int customer_id;
	Scanner in=new Scanner(System.in);
	CustomerBean cb=new CustomerBean();
	ArrayList<CustomerBean> cblist=new ArrayList<CustomerBean>();
	ServiceProviderDAO sdao=new ServiceProviderDAO();
	ServiceProviderApp sapp=new ServiceProviderApp();
	
	public void getCustomerSignupDetails(String username,CustomerBean cb)
	{ 
		    customer_id=(int )(Math. random() * 42 + 1);
		    cb.setCustomer_id(customer_id);
		    cb.setCus_uname(username);
		   // cb.setCustomer_name(cb.getCustomer_name());
			/*cb.setPhone_number(cb);
			System.out.println("Enter Location");
			location=in.nextLine();
			cb.setLocation(location);
			System.out.println("Enter Address");
			address=in.nextLine();
			cb.setAddress(address);
			System.out.println("Enter email");
			email_id=in.nextLine();
			cb.setEmail_id(email_id);*/
			CustomerDAO cdao=new CustomerDAO();
			cdao.insert(cb);
			/*cblist.add(cb);
			System.out.println("You have signed up! Login to avail services :) ");
			LoginDetailsApp.logindetails(1);
			*/
		
	}
	public void getChoice(int cust_id)
	{
		AdminDAO adao=new AdminDAO();
		int choice;
		System.out.println("1.Search 2.check status 3.submit feedback 4.signout");
		choice=in.nextInt();
		switch(choice)
		{
		case 1:
			Search(cust_id);
			break;
		case 2:
			adao.checkStatus(cust_id);
			break;
		case 3:
			submitFeedback(cust_id);
			break;
		case 4:
			System.out.println("Thank you!");
			break;
		}
	}
	 String time=null;
	 AdminDAO adao=new AdminDAO();
	public void bookAppointment(int Customer_id,int serviceprovider_id,int servicetype)
	{
		 AdminBean ab=new AdminBean();
		 System.out.println(Customer_id);
		ab.setSp_id(serviceprovider_id);
		ab.setCust_id(Customer_id);
	   String[] timings=sdao.getTimings(serviceprovider_id);
	   System.out.println("Service provider " +serviceprovider_id+" works from "+timings[0]+" to "+timings[1]);
	   System.out.println("Enter timing to book appointment : ");
	  time=in.next();
	 
	  ab.setTime(time);
	  ab.setService_type(servicetype);
	 
	  adao.insert(ab);
	  adao.update(Customer_id);
	  System.out.println("Please wait for the response from the serviceprovider ");
		  
	   
	}
	
	public void submitFeedback(int customer_id)
	{
		boolean t=adao.checkUserAlreadyBooked(customer_id);
		if(t)
		{
	     int overall_rating;
	     System.out.println("Enter overall rating of your experience on a scale of 5: ");
	     overall_rating=in.nextInt();
	     AdminDAO adao=new AdminDAO();
	     adao.insertFeedback(overall_rating,customer_id);
		}
		else
		{
			System.out.println("You cannot submit feedback");
		}
	     

	}
	

	public void Search(int cust_id)
	{
		List<ServiceProviderBean> providerlist=null;
		System.out.println("Enter your location");
		String loc = in.next();
		int servicetype=0;
		do
		{
		System.out.println("Enter service that you want to avail ");
		System.out.println("1.Electrical \n 2.Plumbing \n 3.Carpentry \n 4.Mechanic \n 5.Technical assistance \n 6.House Cleaning");
		servicetype=in.nextInt();
		}while(servicetype<=0 || servicetype>6);
		ServiceProviderDAO sdao=new ServiceProviderDAO();
		//sproviderlist=sdao.search(loc,servicetype);
		ListIterator<ServiceProviderBean> itr=providerlist.listIterator();
		ServiceProviderBean spb=new ServiceProviderBean();
		for(int i=0;i<providerlist.size();i++)
		{
			System.out.println("Id : "+providerlist.get(i).getService_provider_id());
			System.out.println("Name :"+providerlist.get(i).getService_provider_name());
			System.out.println("Phone number: "+providerlist.get(i).getService_provider_phone_number());
			System.out.println("Location : "+ providerlist.get(i).getService_provider_location());
			System.out.println("From time :"+ providerlist.get(i).getService_provider_from_time());
			System.out.println("To time"+providerlist.get(i).getService_provider_to_time());
		}
		
		System.out.println("Enter the service provider id");
		int cust_chosen=in.nextInt();
		AdminBean ab=new AdminBean();
		
		bookAppointment(cust_id,cust_chosen,servicetype);
	
		
		
	}
	

	
	
	
}
