package com.serviceprovider.springController;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.serviceprovider.ServiceProvider.*;


@RestController
@RequestMapping(value = "/service")


public class Controller {
	 
	  @RequestMapping(value = "/services" , method = RequestMethod.GET )
	  public List<ServiceProviderBean> getAppointmentDetails() {
  	ServiceProviderDAO sdao=new ServiceProviderDAO();
		ArrayList<ServiceProviderBean> list = (ArrayList<ServiceProviderBean>) sdao.selectAll();
		
		
  	return list;
    }
	 /* @RequestMapping(value="/services",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces={ MediaType.APPLICATION_JSON_VALUE})

	  public int insertAppointmentDetails(@RequestBody ServiceProviderBean ab){
		  ServiceProviderDAO adao=new ServiceProviderDAO();
		 
	    	int n;
	    	
	       n=adao.insert(ab);
			
			
	    	return n;
	  }}*/
	  

	/*@RequestMapping(value="/services",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces={ MediaType.APPLICATION_JSON_VALUE})	 
	public int deleteAppointmentDetails(@PathVariable int spid) {
  	ServiceProviderDAO adao=new ServiceProviderDAO();
  	int n;
  	n=adao.delete(spid);
		
		
  	return n;
    }*/
	  /*@RequestMapping(value = "/services" , method = RequestMethod.GET )
	  public int updateAppointmentDetails(){
		  ServiceProviderDAO adao=new ServiceProviderDAO();
	    	int n;
	    	n=adao.update(2);
			
			
	    	return n;
	  }*/
}

	

