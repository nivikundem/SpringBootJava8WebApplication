package com.vehicle.org.crossing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.org.entities.VehicleRegistrationDetails;
import com.vehicle.org.repositories.VehicleRegistrationRepository;

@Service
public class BCPService {

	
	@Autowired
	private BCPRepository bcpRepositoryRepository;
	
	public List<BCPDetailsPOJO> getBCPDetails(){	
		List<BCPDetailsPOJO> bcpDetailsPOJOList = new ArrayList<>();		
		bcpRepositoryRepository.findAll()
				.forEach(bcpDetailsPOJOList::add);		
		return bcpDetailsPOJOList;
	}
	
	
	
	public List<BCPDetailsPOJO> getBCPDetailsPOJO(String vrn){			
		return bcpRepositoryRepository.findByvrn(vrn);
		
	}
	
	
	public void addVehicleRegistrationDetails(BCPDetailsPOJO bcpDetailsPOJO) {
		bcpRepositoryRepository.save(bcpDetailsPOJO);		
	}
	
	
	
	/*public void addVehicleRegistrationDetails(VehicleRegistrationDetails vehicleRegistrationDetails) {
		vehicleRegistrationRepository.save(vehicleRegistrationDetails);		
	}
	
	public void deleteVehicleRegistrationDetails(Integer id) {	
		vehicleRegistrationRepository.delete(id);		
	}
	
	
	
	 public VehicleRegistrationDetails getVehicleRegistrationDetails(Integer id){			
			return vehicleRegistrationRepository.findOne(id);
			
		}
	public void updateVehicleRegistrationDetails(VehicleRegistrationDetails vehicleRegistrationDetails) {			
		vehicleRegistrationRepository.save(vehicleRegistrationDetails);
	}
	*/
	
	

}
