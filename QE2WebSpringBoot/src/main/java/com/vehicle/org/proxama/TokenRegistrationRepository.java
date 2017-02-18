package com.vehicle.org.proxama;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vehicle.org.entities.VehicleRegistrationDetails;

public interface TokenRegistrationRepository extends CrudRepository<TokenRegistration, Long> {

	//List<BCPDetailsPOJO> findByvrn(String vrn);
}
