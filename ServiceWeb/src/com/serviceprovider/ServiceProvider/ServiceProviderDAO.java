package com.serviceprovider.ServiceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.serviceprovider.service.Connectionclass;

public class ServiceProviderDAO {
                 
	Connection con=Connectionclass.getConnection();
	PreparedStatement ps=null;
	Scanner in=new Scanner(System.in);
	ResultSet rs=null;
	ServiceProviderBean spb=new ServiceProviderBean();
	
	public void insert(ServiceProviderBean sb)
	{
		
		String insertQuery="INSERT INTO T_XBBNHFN_PROVIDERDETAILS VALUES(?,?,?,?,?,?,?,?)";
		//String[] n=sb.getService_Type();
		int i=0;
		
			try{
				
			
			ps=con.prepareStatement(insertQuery);
			ps.setInt(1,sb.getService_provider_id());
			ps.setString(2,sb.getService_provider_name());
			ps.setString(3,sb.getService_provider_phone_number());
			ps.setString(4,sb.getService_provider_location());
			ps.setString(5,sb.getService_provider_from_time());
			ps.setString(6,sb.getService_provider_to_time());
		
			ps.setString(7,sb.getService_Type());
			
			ps.setString(8,sb.getSp_uname());
		    ps.execute();
		    i++;
			
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public List<ServiceProviderBean> search(String location,int servetype)
	{    List<ServiceProviderBean> searchlist=null;
		String searchQuery="SELECT DISTINCT * FROM T_XBBNHFN_PROVIDERDETAILS WHERE SP_LOCATION=? AND SERVICE_TYPE=?";
		
		try
		{
		searchlist=new ArrayList<ServiceProviderBean>();
		ps=con.prepareStatement(searchQuery);
		ps.setString(1,location);
		ps.setInt(2,servetype);
		
		rs=ps.executeQuery();
		while(rs.next())
		{
			//System.out.println(rs.getInt(1));
		    spb.setService_provider_id(rs.getInt(1));
		    String n=rs.getString(2);
			spb.setService_provider_name(n);
			//System.out.println();
			spb.setService_provider_phone_number(rs.getString(3));
			spb.setService_provider_location(rs.getString(4));
			spb.setService_provider_from_time(rs.getString(5));
			spb.setService_provider_to_time(rs.getString(6));
			searchlist.add(spb);
			
		}}
		
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return searchlist;
		
	}
	public String[] getTimings(int serviceprovider_id) {
		String searchQuery="SELECT SP_FROM,SP_TO FROM T_XBBNHFN_PROVIDERDETAILS WHERE SP_ID=?";
		String[] timings=new String[2];
		try {
			ps=con.prepareStatement(searchQuery);
			ps.setInt(1,serviceprovider_id);
			rs=ps.executeQuery();
			while(rs.next()){
				timings[0]=rs.getString("SP_FROM");
				timings[1]=rs.getString("SP_TO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timings;
		
		
	}

	public void getServiceProviderDetails(int spid) {
		
		String searchQuery="SELECT * FROM T_XBBNHFN_PROVIDERDETAILS WHERE SP_ID=?";
		try {
			ps=con.prepareStatement(searchQuery);
			ps.setInt(1, spid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Service Provider name : "+rs.getString(2));
				System.out.println("Service Provider phone number : "+rs.getString(3));
				System.out.println("Service Provider location : "+rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int  getService_provider_id(String uname) {
		String id="SELECT SP_ID FROM T_XBBNHFN_PROVIDERDETAILS WHERE SP_USERNAME=?";
		int Sid=0;
		try {
			ps=con.prepareStatement(id);
			ps.setString(1, uname);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Sid=rs.getInt(8);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Sid;
	}
	public List<ServiceProviderBean> display(String uname)
	{
		List<ServiceProviderBean> l=new ArrayList<ServiceProviderBean>();
		int rows;
		
		
		String query="SELECT * FROM T_XBBNHFN_PROVIDERDETAILS WHERE SP_USERNAME=?";
		try{
			ps=con.prepareStatement(query);
			ps.setString(1,uname);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
			spb.setService_provider_id(rs.getInt(1));
				spb.setService_provider_name(rs.getString(2));
				spb.setService_provider_phone_number(rs.getString(3));
				spb.setService_provider_location(rs.getString(4));
				spb.setService_provider_from_time(rs.getString(5));
				spb.setService_provider_to_time(rs.getString(6));
				
				spb.setService_Type(rs.getString(7));
				
				}
				
				l.add(spb);
				
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
		
	}

	
	
	
	
}
