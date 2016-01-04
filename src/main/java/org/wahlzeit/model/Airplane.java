package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

/**
 * A airplane class represents the instance of an airplane type.
 * 
 * @author Elisabeth Hoppe
 * 
 * @version 1.0
 * 
 * @date 04.01.2016
 *
 */
public class Airplane extends DataObject{
	
	/**
	 * for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The type of this instance
	 * */
	private AirplaneType airplaneType = null;
	
	/**
	 * IDs 
	 * */
	private static int idCounter = 0;
	private int id;
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public Airplane(AirplaneType at) {
		
		assert(at!=null) : "Null cannot be set as type";
		
		this.airplaneType = at;
		
		id = idCounter;
		idCounter++;
	}
	
	/**
	 * @methodtype get
	 * 
	 * Gets the airplane type
	 * */
	public AirplaneType getType() {
		
		return this.airplaneType;
	}
	
	
	/**
	 * @methodtype get
	 * 
	 * Gets the id of this instance
	 * */
	public int getId(){
		return this.id;
	}
	
}
