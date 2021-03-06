package com.vehicle.org.crossing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;



@Configuration
public class CrossingDetailsMessageSenderConfiguration {
	

	    @Bean
	    Jaxb2Marshaller jaxb2Marshaller() {

	        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
	     // this package must match the package in the <generatePackage> specified in
	     			// pom.xml or wherever you moved your javaobjects which were creaed by generate.
	        jaxb2Marshaller
	                .setContextPath("com.crossing.www.BridgeCrossingWS");
	      
	        return jaxb2Marshaller;
	    }
	    
	    
	    @Bean
	    public WebServiceTemplate webServiceTemplate() {
	    	
	        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
	        webServiceTemplate.setMarshaller(jaxb2Marshaller());
	        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
	      /*  webServiceTemplate.setDefaultUri(
	                "http://localhost:8080/BridgeCrossingWS/services/BridgeCrossingPort");*/

	        webServiceTemplate.setDefaultUri(
	        		"http://localhost:2211/BridgeCrossingWS/services/BridgeCrossingPort");
	        return webServiceTemplate;
	    }
	
}
