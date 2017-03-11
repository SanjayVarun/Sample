package com.serviceprovider.ServiceProvider;

import java.util.Scanner;

import com.serviceprovider.Admin.AdminDAO;
import com.serviceprovider.customer.CustomerApp;
import com.serviceprovider.customer.CustomerDAO;
import com.serviceprovider.login.LoginDetailsApp;

public class ServiceProviderApp {
	private String service_provider_name;
	private int service_provider_id;
	private String service_provider_phone_number;
	private String service_provider_location,service_provider_from_time,service_provider_to_time;
  
	ServiceProviderBean sb=new ServiceProviderBean();
	ServiceProviderDAO sdao=new ServiceProviderDAO();
	Scanner in=new Scanner(System.in);
	int number;
	public void getServiceProviderSignupDetails(String username,ServiceProviderBean sb)
	{
		
		/*System.out.println("Enter name");
		service_provider_name=in.nextLine();
		sb.setService_provider_name(service_provider_name);
		service_provider_id = (int )(Math. random() * 50 + 1);
		sb.setService_provider_id(service_provider_id);
		System.out.println("Enter Phone number");
		service_provider_phone_number=in.nextLine();
		sb.setService_provider_phone_number(service_provider_phone_number);
		System.out.println("Enter Location");
		service_provider_location=in.nextLine();
		sb.setService_provider_location(service_provider_location);
		System.out.println("Enter Work Timings \n From :");
		service_provider_from_time=in.nextLine();
		sb.setService_provider_from_time(service_provider_from_time);
		System.out.println("To:");
		service_provider_to_time=in.nextLine();
		sb.setService_provider_to_time(service_provider_to_time);
		System.out.println("Enter number of Types of services that you wish to offer");
		System.out.println("1.Electrical \n 2.Plumbing \n 3.Carpentry \n 4.Mechanic \n 5.Technical assistance \n 6.House Cleaning");
		number=in.nextInt();
		int i=0;
		  int[] Service_Type=new int[number];
		System.out.println("Enter service ids");
		while(number>=1 && i<number)
		{
		Service_Type[i]=in.nextInt();
		i++;
		}
		sb.setService_Type(Service_Type);*/
		service_provider_id = (int )(Math. random() * 50 + 1);
		sb.setService_provider_id(service_provider_id);
		sb.setSp_uname(username);
	     sdao.insert(sb);
	    /* System.out.println("You have signed up! Login to avail services :) ");
			LoginDetailsApp.logindetails(2);
	    
	    in.close();*/
	}
	/*public void acceptAppointment(int customer_id, int serviceprovider_id,String time,int servicetype) {
          CustomerDAO cdao=new CustomerDAO();
          AdminDAO adao=new AdminDAO();
          cdao.displayCustomerDetails(customer_id);
          System.out.println("Accept request? Yes or no");
          String choice=in.nextLine();
          boolean status=false;
          CustomerApp capp=new CustomerApp();
          if(choice.equalsIgnoreCase("yes"))
          {
        	  adao.setstatus("yes");
        	  
          }
          */
	public void getChoice(int service_provider_id) {
		 AdminDAO adao=new AdminDAO();
		System.out.println("Enter your choice : \n 1.CheckRequests \n 2.View feedback \n 3.signout");
		int choice=in.nextInt();
		switch(choice)
		{
		case 1:
			adao.retrieveDetails(service_provider_id);
		     break;
		case 2:
			adao.viewFeedback(service_provider_id);
			break;
		case 3:
			System.out.println("Thank you!");
			break;
		}
		
	}
		
	
	/*public void checkRequests(int sp_id)                                  
	{
		CustomerApp capp=new CustomerApp();
	  AdminDAO adao=new AdminDAO();
	 boolean choice=adao.retrieveDetails(sp_id);
	  if(choice)
	  {
	   capp.setStatus(true);
	  }
	  else
	  {
	   capp.setStatus(false);
	  }
	}
*/

}
