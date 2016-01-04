package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

/**
 * A airplane photo class represents a user uploaded airplane photo.
 * 
 * @version 2.0
 * 
 * @date 04.01.2016
 *
 */

@Entity
public class AirplanePhoto extends Photo{
	
	/***
	 * Airplane manager
	 */
	private static AirplaneManager airplaneManager = null;
	
	/**
	 * Specific members of an airplane photo 
	 */
	
	 private Airplane airplane;
	 
	 /**
	 * @methodtype default constructor
	 * 
	 */
	public AirplanePhoto(){
		// call the super constructor
		super();
		// set all values of this class to default
		getManagerInstance().createAirplaneType("Deafult", AirplaneCategory.Default, (int) 0.0, LandCategory.Default);
		this.airplane = getManagerInstance().createAirplane("Default");
		
	}
	/**
	 * @methodtype constructor
	 * 
	 */
	public AirplanePhoto(PhotoId id){
		super(id);
	}
	
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public AirplanePhoto(String typeName, AirplaneCategory category, int altitude, LandCategory landing){
		super();
		
		getManagerInstance().createAirplaneType(typeName, category, altitude, landing);
		this.airplane=getManagerInstance().createAirplane(typeName);
	}
	 
	/**
	 * @methodtype get
	 * 
	 * Gets the airplane manager instance
	 * */
	private AirplaneManager getManagerInstance() {
		
		if(airplaneManager == null) {
			airplaneManager = new AirplaneManager();
			return airplaneManager;
		}
		
		else {
			return airplaneManager;
		}
	}
	
	
	 /**
	 * @methodtype get
	 * 
	 * @return The category of the airplane
	 */
	public AirplaneCategory getCategory() {
		return this.airplane.getType().getCategory();
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param type The type to set
	 */
	public void setCategory(AirplaneCategory category) {
		this.airplane.getType().setCategory(category);
	}
	
	/**
	 * @methodtype get
	 * 
	 * @return The flight altitude
	 */
	public int getFlightAltitude() {
		return this.airplane.getType().getAltitude();
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param flightAltitude the flight altitude to set 
	 */
	public void setFlightAltitude(int flightAltitude) {
		this.airplane.getType().setAltitude(flightAltitude);
	}
	
	/**
	 * @methodtype get
	 * 
	 * @return The land type
	 */
	public LandCategory getLandType() {
		return this.airplane.getType().getLanding();
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param landType The land type to set
	 */
	public void setLandType(LandCategory landType) {
		this.airplane.getType().setLanding(landType);
	}
	 
	/**
	 * @methodtype get
	 * 
	 * @return The airplane 
	 */
	public Airplane getAirplane() {
		return this.airplane;
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param Airplane The airplane to set
	 */
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
		incWriteCount();
	}
	
	
}

