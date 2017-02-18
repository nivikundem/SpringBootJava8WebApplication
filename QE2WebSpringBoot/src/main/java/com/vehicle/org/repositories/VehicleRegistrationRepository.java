package com.vehicle.org.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vehicle.org.entities.VehicleRegistrationDetails;

public interface VehicleRegistrationRepository extends CrudRepository<VehicleRegistrationDetails, Integer> {

}
