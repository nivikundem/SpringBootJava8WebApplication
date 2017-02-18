package com.vehicle.org.proxama;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;



import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToMap {

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = "[{\"token\":1487228402700,\"keyname\":\"a\",\"keyvalue\":\"b\"},{\"token\":1487228402700,\"keyname\":\"e\",\"keyvalue\":\"f\"}]";
  //    System.out.println(json);
      Map<String,Object> map = new HashMap<String,Object>();


      try {
		HashMap<String,Object> result =
			        new ObjectMapper().readValue(json, HashMap.class);
	} catch (JsonParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (JsonMappingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      
    //  List<Map<String,Object>> mapList = null ;
      
      try {
		map = mapper.readValue(json, new TypeReference<Map<String,String>>(){});
		
		//System.out.println(mapper.readValue(json, new TypeReference<Map<String,String>>(){}));
		//System.out.println(mapList);
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
     
      System.out.println(map);
      
	}

}
