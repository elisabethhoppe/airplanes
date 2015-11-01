package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

/**
 * A airplane photo class represents a user uploaded airplane photo.
 * 
 * @version 1.0
 * 
 * @date 1.11.2015
 *
 */

@Entity
public class AirplanePhoto extends Photo{
	
	/**
	 * Specific member of an airplane photo 
	 */
	
	 private AirplaneType type;
	 private double flightAltitude;
	 private LandType landType;
	 
	 /**
	 * @methodtype default constructor
	 * 
	 */
	public AirplanePhoto(){
		// just call the super constructor
		super();
		// set all values of this class to default
		this.setType(null);
		this.setFlightAltitude(0.0);
		this.setLandType(null);
	}
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public AirplanePhoto(AirplaneType type, double flightAltitude, LandType landType){
		super();
		this.setType(type);
		this.setFlightAltitude(flightAltitude);
		this.setLandType(landType);
	}
	 
	 /**
	 * @methodtype get
	 * 
	 * @return The type of tha airplane
	 */
	public AirplaneType getType() {
		return type;
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param type The type to set
	 */
	public void setType(AirplaneType type) {
		this.type = type;
	}
	
	/**
	 * @methodtype get
	 * 
	 * @return The flight altitude
	 */
	public double getFlightAltitude() {
		return flightAltitude;
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param flightAltitude the flight altitude to set 
	 */
	public void setFlightAltitude(double flightAltitude) {
		this.flightAltitude = flightAltitude;
	}
	
	
	public LandType getLandType() {
		return landType;
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param landType The land type to set
	 */
	public void setLandType(LandType landType) {
		this.landType = landType;
	}
	 
	
	
}

