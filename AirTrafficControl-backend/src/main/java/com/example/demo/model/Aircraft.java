package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Aircraft {

	@Id
	private String flightCode;
	
	@Enumerated(EnumType.STRING)
	private AircraftType type;
	
	@Enumerated(EnumType.STRING)
	private AircraftModel size;
	
	


	public String getFlightCode() {
		return flightCode;
	}


	public AircraftType getType() {
		return type;
	}



	public AircraftModel getSize() {
		return size;	
	}




	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}



	public void setType(AircraftType type) {
		this.type = type;
	}


	public void setSize(AircraftModel size) {
		this.size = size;
	}




	@Override
	public String toString() {
		return "Aircraft [ flightCode=" + flightCode + ", type=" + type + ", size=" + size + "]";
	}
	
	
	
	
	
	
}
