package com.vehicle.org.crossing;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vehicle.org.entities.VehicleRegistrationDetails;

public interface BCPRepository extends CrudRepository<BCPDetailsPOJO, Integer> {

	List<BCPDetailsPOJO> findByvrn(String vrn);
}
