package com.vehicle.org.crossing;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.crossing.www.BridgeCrossingWS.ObjectFactory;
import com.crossing.www.BridgeCrossingWS.SendCrossingDetails;
import com.crossing.www.BridgeCrossingWS.SendCrossingDetailsResponse;


@Service
public class CrossingDetailsMessageSender   {


	/**
	 * To send the crossing details using webservice url
	 * @param vrn
	 * @param gateNumber
	 * @param direction
	 */
	public  void CrossingDetails(String vrn, String gateNumber,
			String direction, WebServiceTemplate webServiceTemplate) {
	
					        
	        ObjectFactory factory = new ObjectFactory();	        
	        SendCrossingDetails sendCrossingDetails = factory.createSendCrossingDetails();	
			sendCrossingDetails.setGateno(gateNumber);
			sendCrossingDetails.setVrn(vrn);
			sendCrossingDetails.setDirection(direction);
			
			SendCrossingDetailsResponse response = (SendCrossingDetailsResponse) webServiceTemplate
	                .marshalSendAndReceive(sendCrossingDetails);
		
		   System.out.println("response ::: "+response);
	}

}
