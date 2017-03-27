package com.serviceprovider.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.serviceprovider.customer.*;
import com.serviceprovider.service.Connectionclass;

public class AdminDAO {
	//Connection con=null;
	Connection con=Connectionclass.getConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	AdminBean ab=new AdminBean();
public void insert(AdminBean ab)
{
	String str="INSERT INTO T_XBBNHFN_ADMIN VALUES(?,?,?,?,?)";
	try {
		ps=con.prepareStatement(str);
		
		ps.setInt(1,ab.getCust_id());
		ps.setInt(2,ab.getSp_id());
		ps.setInt(3,ab.getService_type());
		ps.setString(4,ab.getTime());
		ps.setString(5,ab.getDate());
		ps.setString(6,"Pending");
		ps.setString(7, "0");
		
		ps.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void checkStatus(int cust_id)
{
  String check="SELECT a.service_type,a.status,s.service_name FROM T_XBBNHFN_ADMIN a INNER JOIN SERVICE s ON a.service_type=s.service_id WHERE CUSTOMER_ID=?";
  try {
	ps=con.prepareStatement(check);
	ps.setInt(1,cust_id);
	rs=ps.executeQuery();
	ResultSetMetaData rsmd=rs.getMetaData();
	int col=rsmd.getColumnCount();
	while(rs.next())
	{
		
		System.out.println("Service Type : "+rs.getInt(1));
		System.out.println("Status : "+rs.getString(2));
		System.out.println("Service :"+rs.getString(3));
		
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
}
public void setstatus(String st) {
	String updateQuery="UPDATE T_XBBNHFN_ADMIN VALUES SET STATUS=? WHERE CUSTOMER_ID=?";
	try {
		ps=con.prepareStatement(updateQuery);
		ps.setString(1,"Accepted");
		ps.setInt(2,ab.getCust_id());
		ps.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
public void update(int cid)
{
 //CustomerBean cb=new CustomerBean();
 String updateQuery="UPDATE T_XBBNHFN_ADMIN SET STATUS='PENDING' WHERE CUSTOMER_ID=?";
 try
 {
   ps=con.prepareStatement(updateQuery);
   ps.setInt(1,cid);
   ps.execute();
 }
 catch(SQLException e)
{
   System.out.println(e);
}
}

	public ResultSet retrieveDetails(int sp_id)
	{
	  String searchQuery="SELECT a.customer_id,c.Customer_name,c.customer_location,a.time FROM T_XBBNHFN_ADMIN a inner join T_XBBNHFN_CUSTOMERDETAILS c on a.customer_id=c.customer_id WHERE SERVICE_PROVIDER_ID=? and status='PENDING'";
	  try
	  {
		  
	    ps=con.prepareStatement(searchQuery);
	    ps.setInt(1,sp_id);
	    rs=ps.executeQuery();
	    return rs;
	   // ResultSetMetaData rmd=rs.getMetaData();
	    /*if(rs!=null)
	    {int i=0;
	    while(rs.next())
	    {
	    	ab[i]=new AdminBean();
	    cb[i]=new CustomerBean();
	      ab[i].setCust_id(rs.getInt(1));
	      requests.put("Customer_id"+i,ab[i].getCust_id());
	      cb[i].setCustomer_name(rs.getString(2));
	      requests.put("Customer_name",cb[i].getCustomer_name());
	      cb[i].setLocation(rs.getString(3));
	      requests.put("Customer_location",cb[i].getLocation());
	      ab[i].setTime(rs.getString(4));
	      requests.put("Time",ab[i].getTime());
	      i++;
	      
	    }*/}
	    
	   
	    /* if(choice.equalsIgnoreCase("yes"))
	     {
	      updateStatus(true,sp_id);
	     }
	     else
	     {
	    	updateStatus(false,sp_id);
	     }*/
	   
	   catch(SQLException e)
	   {
	    System.out.println(e);
	   }
	  return rs;
	}
	private void updateStatus(boolean b,int sp_id) {
		String update="UPDATE T_XBBNHFN_ADMIN SET STATUS=? WHERE SERVICE_PROVIDER_ID=?";
		try {
			ps=con.prepareStatement(update);
			if(b)
			{
				ps.setString(1,"Accepted");
			}
			else
			{
				ps.setString(2,"Rejected");
			}
				ps.setInt(2,sp_id);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void insertFeedback(int overall_rating,int cust_id) {
		String insertQuery="UPDATE T_XBBNHFN_ADMIN SET FEEDBACK=? WHERE CUSTOMER_ID=?";
		 try {
			ps=con.prepareStatement(insertQuery);
			ps.setInt(1,overall_rating);
			ps.setInt(2, cust_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	public boolean checkUserAlreadyBooked(int customer_id) {
		String check="SELECT STATUS FROM T_XBBNHFN_ADMIN WHERE CUSTOMER_ID=?";
		boolean truth=false;
		try{
			ps=con.prepareStatement(check);
			ps.setInt(1,customer_id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				if(rs.getString(1).equals("Accepted"))
				{
					truth=true;
				}
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return truth;
	}
	public ResultSet viewFeedback(int service_provider_id) {
		String Feedback="SELECT FEEDBACK,CUSTOMER_ID FROM T_XBBNHFN_ADMIN WHERE SERVICE_PROVIDER_ID=?";
		try
		{
			ps=con.prepareStatement(Feedback);
			ps.setInt(1, service_provider_id);
			rs=ps.executeQuery();
			/*while(rs.next()){
				System.out.println("Your feedback given by "+rs.getInt(2)+" is" +rs.getString(1));
			}*/
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return rs;
	}
}

