package com.serviceprovider.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO{
	
		public static List<Servicebean> getDetails(int Service_Id){
			
			
			Connection conn = Connectionclass.getConnection();
			PreparedStatement stmt = null;
			List<Servicebean> details = null;
			ResultSet resultset = null;
			String searchQuery = "SELECT Service_Type from T_XBBNHFN_SERVICE1 where Service_Id = ?; ";
			try {
				 stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1, Service_Id);		
				
				 resultset = stmt.executeQuery();	
				
				 details = new ArrayList<Servicebean>();
				 
				while(resultset.next()) {
					Servicebean servicebean = new Servicebean();
					servicebean.setService_id((resultset.getInt("Service_id")));
			        details.add(servicebean);
							
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			finally{
				try {
					if(resultset!=null)
					resultset.close();
					if(stmt != null)					
					stmt.close();				
					conn.commit();
					if(conn != null)
					conn.close();
				}			
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			return details;
			
			
	}
		
}



