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
	
	/**
	 * for serial issues
	 */
	private static final long serialVersionUID = 1L;

	/***
	 * Airplane manager
	 */
	private static AirplaneManager airplaneManager;
	
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
	private synchronized AirplaneManager getManagerInstance() {
		
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
	}
	
	
}

