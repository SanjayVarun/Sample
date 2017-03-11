package com.serviceprovider.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.serviceprovider.service.Connectionclass;

public class LoginDAO {
	
	Connection con=Connectionclass.getConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	public void insert(LoginDetailsBean lb)
	{
	    
		String insertQuery="INSERT INTO T_XBBNHFN_LOGINDETAILS VALUES(?,?,?)";
		try {
			System.out.println("Insert");
			ps=con.prepareStatement(insertQuery);
			ps.setInt(1, lb.getType());
			ps.setString(2,lb.getUsername());
			ps.setString(3,lb.getPassword());
			ps.execute();
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean check(LoginDetailsBean lb)
	{
		boolean truth=true;
		/*int t1=0;
		if(t.equals("Service Provider"))
		t1=2;
		else
			t1=1;*/
		String searchQuery="select username,password from T_XBBNHFN_LOGINDETAILS WHERE username=? and password=? and type=?";
		try{
			
		ps=con.prepareStatement(searchQuery);
		ps.setString(1,lb.getUsername());
		ps.setString(2,lb.getPassword());
		ps.setInt(3,lb.getType());
		rs=ps.executeQuery();
		if (!rs.isBeforeFirst()) {    
		    truth=false;
		  
		} 
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return truth;
	}
	public boolean isNewUser(String uname)
	{
		boolean truth=false;
		String searchQuery="SELECT USERNAME FROM T_XBBNHFN_LOGINDETAILS WHERE USERNAME=?";
		try {
			ps=con.prepareStatement(searchQuery);
			ps.setString(1, uname);
			rs=ps.executeQuery();
			if(rs==null)
			{
				truth=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return truth;
		
	}
	public int getCustomerId(String uname)
	{
		int cid=0;
		String searchQuery="SELECT DISTINCT CUSTOMER_ID FROM T_XBBNHFN_CUSTOMERDETAILS,T_XBBNHFN_LOGINDETAILS WHERE USERNAME=?";
		try{
		ps=con.prepareStatement(searchQuery);
		ps.setString(1,uname);
		rs=ps.executeQuery();
		while(rs.next()){
			cid=rs.getInt("CUSTOMER_ID");
		}
	}
	catch(SQLException e)
	{
		System.out.println(e);
		
	}
		return cid;
	}
	public int getSpId(String uname) {
		int spid=0;
		String search="SELECT DISTINCT SP_ID FROM T_XBBNHFN_PROVIDERDETAILS,T_XBBNHFN_LOGINDETAILS WHERE USERNAME=?";
		try{
		ps=con.prepareStatement(search);
		ps.setString(1, uname);
		rs=ps.executeQuery();
		while(rs.next())
		{
			spid=rs.getInt("SP_ID");
		}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return spid;
	}
}
