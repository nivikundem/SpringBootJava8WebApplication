package com.vehicle.org.proxama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.org.entities.VehicleRegistrationDetails;
import com.vehicle.org.repositories.VehicleRegistrationRepository;

@Service
public class TokenRegistrationService {

	
	@Autowired
	private TokenRegistrationRepository tokenRegistrationRepository;
	
	public List<Long> getTokenRegistrationDetails(){	
		List<TokenRegistration> tokenRegistrationList = new ArrayList<>();
		List<Long> tokenRegistrationStringList = new ArrayList<>();
		tokenRegistrationRepository.findAll()
				.forEach(tokenRegistrationList::add);	
		
		tokenRegistrationList.forEach(tokenRegistration->{			
			tokenRegistrationStringList.add(tokenRegistration.getToken());
		
		});
		
		return tokenRegistrationStringList;
	}
	
	
	
	
	/*public List<BCPDetailsPOJO> getTokenRegistrationDetails(String vrn){			
		return bcpRepositoryRepository.findByvrn(vrn);
		
	}*/
	
	
	public void addTokenRegistrationDetails(TokenRegistration tokenRegistration) {
		tokenRegistrationRepository.save(tokenRegistration);		
	}
	
	
	
	

}
