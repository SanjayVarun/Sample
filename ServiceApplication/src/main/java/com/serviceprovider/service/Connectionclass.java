package com.serviceprovider.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionclass {
  private static Connection con;
   //private static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
         //String url = "jdbc:odbc:" + "DataSource"; 
        Class.forName("oracle.jdbc.driver.OracleDriver");
       /* Class.forName("org.apache.derby.jdbc.ClientDriver");*/
         
                    	try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			/*con=DriverManager.getConnection("jdbc:derby://10.78.233.58:1527/serviceprovider","user","pwd");*/
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
         
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
   }
}




