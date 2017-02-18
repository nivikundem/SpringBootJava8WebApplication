package com.vehicle.org.proxama;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token_registration_table")


public class TokenRegistration {
	public TokenRegistration() {
		}
	
	@Id
	@Column(name = "token", nullable = false)
	private long token;

	public long getToken() {
		return token;
	}

	public void setToken(long token) {
		this.token = token;
	}

	
	
	
	
}
