package com.vehicle.org.proxama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.org.entities.VehicleRegistrationDetails;
import com.vehicle.org.repositories.VehicleRegistrationRepository;

@Service
public class ProxamaAPIService {

	
	@Autowired
	private ProxamaAPIRepository proxamaAPIRepository;
		
	public ProxamaAPIPOJO getProxamaAPI(String key){		
		return proxamaAPIRepository.findOne(key);		
	}
	
	public ProxamaAPIPOJO getProxamaAPIByTokenAndKey(Long token,String key){		
		return proxamaAPIRepository.findByTokenAndKeyname(token, key)	;	
	}
	
	
	public void addProxamaAPI(ProxamaAPIPOJO proxamaAPIPOJO) {
		proxamaAPIRepository.save(proxamaAPIPOJO);		
	}
	
	
	
	public  List<ProxamaAPIPOJO> findBytoken(Long token){
		return proxamaAPIRepository.findBytoken(token);
	}

}
