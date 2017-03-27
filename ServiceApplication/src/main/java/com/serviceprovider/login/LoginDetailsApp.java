package com.serviceprovider.login;
import java.util.Scanner;

import com.serviceprovider.ServiceProvider.ServiceProviderApp;
import com.serviceprovider.ServiceProvider.ServiceProviderBean;
import com.serviceprovider.ServiceProvider.ServiceProviderDAO;
import com.serviceprovider.customer.CustomerApp;
import com.serviceprovider.customer.CustomerBean;
import com.serviceprovider.customer.CustomerDAO;


public class LoginDetailsApp {
 static	String uname,password,cpassword;
	
	/*public static void main(String args[])
	{
		
		Scanner in=new Scanner(System.in);
		System.out.println("1.Avail services? \n 2.Serve others");
		int type=in.nextInt();
		System.out.println("Enter your choice");
		System.out.println("1.Signup \n 2.Login \n 3.Cancel");
		int choice=in.nextInt();
//		switch(choice)
//		{
//		case 1:
//		    signupdetails(type);
//			break;
//		case 2:
//			logindetails(type);
//			break;
//		case 3:
//			System.out.println("Thank you :)");
//			break;
//			default:
//				System.out.println("Please enter a valid value(1,2 or 3) Thank you :)");
//		}
//		in.close();
//	}
*/	
	public static String signupdetails(LoginDetailsBean lb,CustomerBean cb,ServiceProviderBean sb)
	{
		LoginDAO ldao=new LoginDAO();
		String check="";
		System.out.println(lb.getUsername());
		boolean isNewUser=ldao.isNewUser(lb.getUsername());
		if(isNewUser)
		{ 
			System.out.println("Inside signupdetails.chcking validity");
			boolean validity=isUsernameValid(lb.getUsername());
			if(validity)
			{
				System.out.println("uname valid");
				ldao.insert(lb);
				
			if(lb.getType()==1)
			{
			CustomerApp capp=new CustomerApp();
			capp.getCustomerSignupDetails(lb.getUsername(),cb);
			}
			else if(lb.getType()==2)
			{
			ServiceProviderApp sapp=new ServiceProviderApp();
			sapp.getServiceProviderSignupDetails(lb.getUsername(),sb);
			}
			}
	
		else
		{
			check="Not valid";
			}
			}
		else
		{
				check="Already registered";
		}
		return check;
		
	}
	private static boolean isPasswordMatch(String pwd,String cpwd)
	{
		boolean truth=false;
		if(pwd.equals(cpwd))
		{
			truth=true;
		}
		return truth;
	}
	private static boolean isUsernameValid(String username)
	{
		boolean truth=false;
		System.out.println("checking validity 8 cjars");
		char firstChar = username.charAt(0);
		if(username.length()==8 && (firstChar >= 'A' || firstChar <= 'Z'))
		{
			truth=true;
		}
		
		return truth;
	}
	public static boolean logindetails(LoginDetailsBean lb)
	{
		boolean truth=true;
		/*Scanner in=new Scanner(System.in);
		System.out.println("Enter username");*/
		uname=lb.getUsername();
		/*System.out.println("Enter password");*/
		password=lb.getPassword();
		int type=lb.getType();
		LoginDAO ldao=new LoginDAO();
		ldao.insert(lb);
		/*if(ldao.check(uname,password))
		{
			ServiceProviderBean sb=new ServiceProviderBean();
			CustomerBean cb=new CustomerBean();
			
		    
			CustomerDAO cdao=new CustomerDAO();
			ServiceProviderDAO sdao=new ServiceProviderDAO();
			System.out.println("Logged in successfully :)");
			if(type==1)
			{
				CustomerApp capp=new CustomerApp();
			int usid=ldao.getCustomerId(uname);
			//capp.getChoice(usid);
			}
			else if(type==2)
			{
				int spid=ldao.getSpId(uname);
				ServiceProviderApp sapp=new ServiceProviderApp();
				//sapp.getChoice(spid);
			}*/
		
		/*else
		{
			truth=false;
			System.out.println("Invalid Login credetials");
			logindetails(type);
		}*/
	
		return truth;
	
	}
	public boolean isUnameCorrect(String username)
	{
		boolean truth=false;
		char firstChar = username.charAt(0);
		if(username.length()==8 && (firstChar >= 'A' && firstChar <= 'Z'))
		{
			truth=true;
		}
		
		return truth;
	}

	
}
