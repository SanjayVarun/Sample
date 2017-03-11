package com.serviceprovider.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.serviceprovider.service.Connectionclass;

public class CustomerDAO {
	Connection con=Connectionclass.getConnection();
	PreparedStatement stmt=null;
    ResultSet rs=null;

	public void insert(CustomerBean cbean)
	{
		
		String insertQuery="INSERT INTO T_XBBNHFN_CUSTOMERDETAILS VALUES(?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(insertQuery);
			stmt.setInt(1, cbean.getCustomer_id());
			stmt.setString(2, cbean.getCustomer_name());
			stmt.setString(3,cbean.getPhone_number());
			stmt.setString(4, cbean.getAddress());
			stmt.setString(5, cbean.getEmail_id());
			stmt.setString(6, cbean.getLocation());
			stmt.setString(7, cbean.getCus_uname());
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	public void displayCustomerDetails(int cust_id) {
           String searchQuery="SELECT * FROM T_XBBNHFN_CUSTOMERDETAILS WHERE CUSTOMER_ID=? ";
           try {
			stmt=con.prepareStatement(searchQuery);
			stmt.setInt(1,cust_id);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.println("Customer name : "+rs.getString(2));
				System.out.println("Customer phone number : "+rs.getString(3));
				System.out.println("Customer address : "+rs.getString(4));
				System.out.println("Customer email id : "+rs.getString(5));
				System.out.println("Customer Location : "+rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
		
	}


	public int getCustomer_id(String uname) {
		String custid="SELECT CUSTOMER_ID FROM T_XBBNHFN_CUSTOMERDETAILS WHERE CUSTOMER_USERNAME=?";
		int cid=0;
		try {
			stmt=con.prepareStatement(custid);
			stmt.setString(1, uname);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				cid=rs.getInt(7);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cid);
		return cid;
	}
	
	
}
