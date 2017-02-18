package com.vehicle.org.crossing;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Table(name = "BRIDGE_CROSSING_PERFORMANCE")

//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="vehicleregCache")
public class BCPDetailsPOJO {
	public BCPDetailsPOJO() {
		}
	
	/*@Id
	@GeneratedValue
	@Column(name = "UID", nullable = false)
	private int uid;
	
	@Column(name = "VRN", nullable = false)
	private String vrn;
	
	@Column(name = "VEHICLE_TYPE", nullable = false)
	private String vehicleType;*/

	@Id
	@GeneratedValue
	@Column(name = "UID", nullable = false)
	private int uid;
	
	private String gateNumber;
	private String vehicleType;
	private String direction;
	private String vrn;
	
	@Column(name = "CROSSING_DATETIME")
	private String crossingDateTime;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getGateNumber() {
		return gateNumber;
	}
	public void setGateNumber(String gateNumber) {
		this.gateNumber = gateNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getVrn() {
		return vrn;
	}
	public void setVrn(String vrn) {
		this.vrn = vrn;
	}
	public String  getCrossingDateTime() {
		return crossingDateTime;
	}
	public void setCrossingDateTime(String crossingDateTime) {
		this.crossingDateTime = crossingDateTime;
	}
	
	
	
	
	
}
