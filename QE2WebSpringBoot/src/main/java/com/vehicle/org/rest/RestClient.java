package com.vehicle.org.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vehicle.org.proxama.ProxamaAPIPOJO;

@Component
public class RestClient {

	//http://localhost:2211/ProxamaAPI/ProxamaAPIApplication/api/store/1487228402700/a/b
	public static  String invokeRestClient(String urlStr){			
		RestTemplate restTemplate = new RestTemplate();
		String response=restTemplate.getForObject(urlStr, String.class);		
		return response;
	}
	

	public static  HashMap<String, String> invokeSearchClient(String urlStr){	
		
		RestTemplate restTemplate = new RestTemplate();	
		String response=restTemplate.getForObject(urlStr, String.class);
		
		HashMap<String, String> resultHashMap = new HashMap<>();
		try {
			resultHashMap = new ObjectMapper().readValue(response, HashMap.class);
		//	String value = resultHashMap.get("proxamaData");
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return resultHashMap;
	}
	
	
	
	
}
