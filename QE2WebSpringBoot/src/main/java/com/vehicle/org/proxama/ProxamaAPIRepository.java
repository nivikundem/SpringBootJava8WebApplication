package com.vehicle.org.proxama;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vehicle.org.entities.VehicleRegistrationDetails;

public interface ProxamaAPIRepository extends CrudRepository<ProxamaAPIPOJO, String> {

	//ProxamaAPIPOJO findByToken(String token);
	ProxamaAPIPOJO findByTokenAndKeyname(Long token, String keyname);
	List<ProxamaAPIPOJO> findBytoken(Long token);
}
