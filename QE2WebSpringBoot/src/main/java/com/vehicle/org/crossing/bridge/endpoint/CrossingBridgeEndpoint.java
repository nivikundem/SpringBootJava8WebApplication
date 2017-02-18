package com.vehicle.org.crossing.bridge.endpoint;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.crossing.www.BridgeCrossingWS.SendCrossingDetails;
import com.crossing.www.BridgeCrossingWS.ObjectFactory;
import com.crossing.www.BridgeCrossingWS.SendCrossingDetailsResponse;
import com.vehicle.org.crossing.BCPDetailsPOJO;
import com.vehicle.org.crossing.BCPService;

@Endpoint
public class CrossingBridgeEndpoint {
	private static final Logger LOGGER = LoggerFactory
            .getLogger(CrossingBridgeEndpoint.class);


    private static final String NAMESPACE_URI = "http://www.crossing.com/BridgeCrossingWS/";

    @Autowired
	private BCPService bcpService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendCrossingDetails")
    @ResponsePayload
    public SendCrossingDetailsResponse getSendCrossingDetailsResponse(@RequestPayload SendCrossingDetails request) {

    	
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    	
    	Date today = Calendar.getInstance().getTime();        
     
    	
    	String vrn = request.getVrn();
    	String gateno = request.getGateno();
    	String direction = request.getDirection();
    	
    	BCPDetailsPOJO bcpDetailsPOJO = new BCPDetailsPOJO();
    	bcpDetailsPOJO.setDirection(direction);
    	bcpDetailsPOJO.setVrn(vrn);
    	bcpDetailsPOJO.setGateNumber(gateno);
    	bcpDetailsPOJO.setVehicleType("CAR");
    	bcpDetailsPOJO.setCrossingDateTime(df.format(today));
    	
    	bcpService.addVehicleRegistrationDetails(bcpDetailsPOJO);
    	       
        ObjectFactory factory = new ObjectFactory();
        SendCrossingDetailsResponse response = factory.createSendCrossingDetailsResponse();
        response.setOut(" VRN :: "+vrn + ", Gateno ::  "+gateno+", Direction :: "+direction);

       
       return response;
   }
}