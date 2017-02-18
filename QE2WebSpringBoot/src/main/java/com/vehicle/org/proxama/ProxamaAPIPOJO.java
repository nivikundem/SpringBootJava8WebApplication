package com.vehicle.org.proxama;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proxama_api_table")


public class ProxamaAPIPOJO {
	public ProxamaAPIPOJO() {
		}
	
	
	@Column(name = "token", nullable = false)
	private Long token;

	@Id
	@Column(name = "keyname", nullable = false)
	private String keyname;
	
	@Column(name = "keyvalue")
	private String keyvalue;
	
	

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getKeyvalue() {
		return keyvalue;
	}

	public void setKeyvalue(String keyvalue) {
		this.keyvalue = keyvalue;
	}

	
	
	
	
}
