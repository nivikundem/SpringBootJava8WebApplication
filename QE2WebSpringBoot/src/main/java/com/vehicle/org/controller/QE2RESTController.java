package com.vehicle.org.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.org.proxama.ProxamaAPIPOJO;
import com.vehicle.org.proxama.ProxamaAPIService;
import com.vehicle.org.proxama.ProxamaDataList;
import com.vehicle.org.proxama.TokenRegistration;
import com.vehicle.org.proxama.TokenRegistrationService;


@RestController
@RequestMapping(value="/ProxamaAPI/ProxamaAPIApplication/api")
public class QE2RESTController {	
	
	@Autowired
	private TokenRegistrationService tokenRegistrationService;
	
	
	@Autowired
	private ProxamaAPIService proxamaAPIService;
	
	
	
	@RequestMapping(value="/registration",method = RequestMethod.GET)
	public String getRegistrationToken(){				
		TokenRegistration tokenRegistration = new TokenRegistration();
		long token = new Date().getTime();
		tokenRegistration.setToken(token);
		tokenRegistrationService.addTokenRegistrationDetails(tokenRegistration);
	    return String.valueOf(token);
	   }
	
	
	
	  @RequestMapping(value="/store/{token}/{key}/{value}", method = RequestMethod.GET)        
	  public String setProxamaData(@PathVariable("token") Long token, @PathVariable("key") String key,@PathVariable("value") String value){
		  
		  String response = "Success";		 		   
		  if(proxamaAPIService.getProxamaAPI(key) != null){
			  response =  "Key ::" + key + " already exists in the table.";
		  }
		  else{
			  ProxamaAPIPOJO  proxamaAPIPOJO = new ProxamaAPIPOJO();
			  proxamaAPIPOJO.setToken(token);
			  proxamaAPIPOJO.setKeyname(key);
			  proxamaAPIPOJO.setKeyvalue(value);			  
			  proxamaAPIService.addProxamaAPI(proxamaAPIPOJO);			  
			  response = "Key ::" + key + "  Value:: " + value
						+ " stored successfully in the DB.";
		  }
		
		   return response;
	   }
	  
		     
	   @RequestMapping(value="/retrieve/{token}/{key}", method = RequestMethod.GET)       	   
	   public String getProxamaData(@PathVariable("token") Long token,@PathVariable("key") String key) {
		   String keyValue = null;		   		  
		   ProxamaAPIPOJO  proxamaAPIPOJO = proxamaAPIService.getProxamaAPIByTokenAndKey(token, key);
		   if(proxamaAPIPOJO != null){
			   keyValue =  proxamaAPIPOJO.getKeyvalue();
		   }
		   if (keyValue == null) {
				keyValue = "Sorry no records exists for this token:" + token
						+ " and key:" + key;
			}
		   return keyValue;		  
	   }
	         
	   @RequestMapping(value="/retrieve/{token}", method = RequestMethod.GET)       	   
	   public ProxamaDataList getProxamaData(@PathVariable("token") Long token){
		   ProxamaDataList proxamaDataList = new ProxamaDataList();		
			proxamaDataList.setProxamaData(proxamaAPIService.findBytoken(token));
		   return proxamaDataList;		  
	   }	   
	   
	   /*@GET       
	   @Path("/retrieve/{token}")
       @Produces(MediaType.APPLICATION_XML)	   
	   public ProxamaDataList getProxamaData(@PathParam("token") long token) throws SQLException{
		   return proxamaDetails.getProxamaDetails(token);		  
	   }*/
	   	   	
}
