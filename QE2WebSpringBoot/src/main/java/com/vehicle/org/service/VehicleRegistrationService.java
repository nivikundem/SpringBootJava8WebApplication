package com.vehicle.org.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.org.entities.VehicleRegistrationDetails;
import com.vehicle.org.repositories.VehicleRegistrationRepository;

@Service
public class VehicleRegistrationService {

	
	@Autowired
	private VehicleRegistrationRepository vehicleRegistrationRepository;
	
	public List<VehicleRegistrationDetails> getVehicleRegistrationDetails(){	
		List<VehicleRegistrationDetails> vehicleRegistrationDetails = new ArrayList<>();		
		vehicleRegistrationRepository.findAll()
				.forEach(vehicleRegistrationDetails::add);		
		return vehicleRegistrationDetails;
	}
	
	
	public void addVehicleRegistrationDetails(VehicleRegistrationDetails vehicleRegistrationDetails) {
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
	
	
	
	
}
