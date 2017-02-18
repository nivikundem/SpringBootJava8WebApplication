package com.vehicle.org.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.google.gson.Gson;
import com.vehicle.org.crossing.BCPService;
import com.vehicle.org.crossing.CrossingDetailsMessageSender;
import com.vehicle.org.entities.VehicleRegistrationDetails;
import com.vehicle.org.jms.JmsClientService;
import com.vehicle.org.proxama.TokenRegistrationService;
import com.vehicle.org.rest.RestClient;
import com.vehicle.org.service.VehicleRegistrationService;




//http://localhost:2211/VehicleRegistrationView
//http://localhost:2211/BridgeCrossingWS/services/BridgeCrossingPort.wsdl
//http://localhost:2211/ProxamaAPI/ProxamaAPIApplication/api/store/1487228402700/a/b
// http://localhost:2211/ProxamaAPI/ProxamaAPIApplication/api/registration
// http://localhost:2211/ProxamaAPI/ProxamaAPIApplication/api/retrieve/1487276157906

@Controller
public class QE2Controller {
	
	@Autowired
	private VehicleRegistrationService vehicleRegistrationService;
	
	@Autowired
	private BCPService bcpService;
	
	
	@Autowired
    JmsClientService jsmClientService;
	
	     
	 @Autowired
	 private WebServiceTemplate webServiceTemplate;
	 
	 
	 @Autowired
	 private TokenRegistrationService tokenRegistrationService;
	 
	 
	//public final static String BASE_URL = "http://localhost:8080/ProxamaAPI/ProxamaAPIApplication/api/";
	 //http://localhost:2211/ProxamaAPI/ProxamaAPIApplication/api/store/1487228402700/e/f
	 public final static String BASE_URL = "http://localhost:2211/ProxamaAPI/ProxamaAPIApplication/api/";
	 
	 
	@RequestMapping(value = {"/","/VehicleRegistrationView"})
    public String listVehicleRegistrationDetails(Map<String, Object> map) {     	
         map.put("vehicleRegistrationDetailsList", vehicleRegistrationService.getVehicleRegistrationDetails());         
        return "VehicleRegistrationView";
    }
    
    
	
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public String addVehicleRegistrationDetails(@ModelAttribute("vehicleRegistrationDetails")
	    VehicleRegistrationDetails vehicleRegistrationDetail, BindingResult result) { 
		 vehicleRegistrationService.addVehicleRegistrationDetails(vehicleRegistrationDetail); 
	        return "redirect:/VehicleRegistrationView";
	    }
	 
	  @RequestMapping("/delete/{uid}")
	    public String deleteVehicleRegistrationDetails(@PathVariable("uid")
	    Integer uid) {
		  vehicleRegistrationService.deleteVehicleRegistrationDetails(uid);
	        return "redirect:/VehicleRegistrationView";
	    } 
	 

	  
	  
	  @RequestMapping(value="/edit")
	  public String editVehicleRegistrationDetails(@RequestParam(required = false)  Integer uid,@RequestParam(required = false) String ddlVehicleType) {       
		  VehicleRegistrationDetails vehicleRegistrationDetails = vehicleRegistrationService.getVehicleRegistrationDetails(uid);
		  vehicleRegistrationDetails.setVehicleType(ddlVehicleType);
		  vehicleRegistrationService.updateVehicleRegistrationDetails(vehicleRegistrationDetails);      
		  return "redirect:/VehicleRegistrationView";
	  }
	  
	  
	  
	    
    
	    @RequestMapping(value = "/AboutView", method = RequestMethod.GET)
		public String getAboutView(Model model) {
			return "AboutView";
		}
	    
	    
	    
	    
		@RequestMapping(value = "/SendMessageView", method = RequestMethod.GET)
		public String sendActiveMqMessage(Model model) {				
			 String message = null;			
			 message = new Gson().toJson(vehicleRegistrationService.getVehicleRegistrationDetails() );
			 jsmClientService.send(message);			
			 model.addAttribute("message", message);		
			 return "SendMessageView";
		}
		
	    
	       
		
		
		 @RequestMapping(value = "/ActivityView", method = RequestMethod.GET)
			public String getCrossingDetailsList(
					@RequestParam(required = false) String quickSearchTextbox,
					@RequestParam(required = false) String sortField,	
					@RequestParam(required = false) String vrn,	
					@RequestParam(required = false) String direction,	
					@RequestParam(required = false) String gateNumber,	
					ModelMap model) throws SQLException {

		    
		    	
		    	if(isObjectNotNull(vrn)&&isObjectNotNull(direction)&&isObjectNotNull(gateNumber)){
		    		if(vrn.trim().length()>0){
						vrn = vrn.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
					}			
					
		    		CrossingDetailsMessageSender cr=new CrossingDetailsMessageSender();
		    	
		    		cr.CrossingDetails(vrn.toUpperCase(), gateNumber.toUpperCase(), direction.toUpperCase(),webServiceTemplate);
					
		    	}
		    	
				String quickSearchTextboxVar = "ALL";
				if (quickSearchTextbox != null) {
					quickSearchTextboxVar = quickSearchTextbox;					
					model.addAttribute("crossingDetailsObjList", bcpService.getBCPDetailsPOJO(quickSearchTextbox));
				}
				else{
					model.addAttribute("crossingDetailsObjList", bcpService.getBCPDetails());
				}
					
				String sortString = "crossing_datetime";
				if (sortField != null) {
					sortString = sortField;
				}	
				/*model.addAttribute("crossingDetailsObjList", CrossingActivityObjModel
						.getActivityDetailsResultList(quickSearchTextboxVar, sortString
								));*/
				
				
				
				
		//		System.out.println("crossingDetailsObjList  ::"+bcpService.getBCPDetails());
				return "ActivityView";
			}
	    
		 
		 
		 
		 
		 @RequestMapping(value = "/TokenRegistrationView", method = RequestMethod.GET)
			public String getTokenDetails(	
					@RequestParam(required = false) String registrationField,
					@RequestParam(required = false) String token,
					@RequestParam(required = false) String key,
					@RequestParam(required = false) String value,
					@RequestParam(required = false) String searchToken,
					@RequestParam(required = false) String searchKey,			
					ModelMap model) throws SQLException {
			 
			 			 
			   if(isObjectNotNull(registrationField)){					
					model.addAttribute("registrationClientResponse", RestClient.invokeRestClient(BASE_URL+"registration"));
				}
			  
			   model.addAttribute("registrationObjList", tokenRegistrationService.getTokenRegistrationDetails());			
			   
			   if(isObjectNotNull(token)&&isObjectNotNull(key)&&isObjectNotNull(value)){
					model.addAttribute("saveClientResponse", RestClient.invokeRestClient(BASE_URL+"store/"+token+"/"+key+"/"+value));
				}
			   String searchUrl = BASE_URL;
				
				if(isObjectNotNull(searchToken) && isObjectNotNull(searchKey) && !searchKey.isEmpty()){
					searchUrl = searchUrl+"retrieve/"+searchToken+"/"+searchKey;
					model.addAttribute("searchClientResponse", RestClient.invokeRestClient(searchUrl));
				}					
				
				else if(isObjectNotNull(searchToken)){
					searchUrl = searchUrl+"retrieve/"+searchToken;
					model.addAttribute("searchClientResponseMap", RestClient.invokeSearchClient(searchUrl));
				}
				
				return "TokenRegistrationView";
			}
			
		 			

	    
	    private boolean isObjectNotNull(Object obj){
			if(obj != null){
				return true;
			}
			else{
				return false;
			}
		}		    
}

