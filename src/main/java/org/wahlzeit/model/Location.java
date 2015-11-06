package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

/**
 * Location basic class 
 * 
 * 
 * 
 * @version 1.0
 * 
 * @date 1.11.2015
 */
public class Location extends DataObject{
	
	/**
	 * for persistence
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * members
	 */
	private String name;
	public Coordinate coordinate;
	
	/**
	 * @methodtype default constructor
	 * 
	 */
	public Location(){
		this.setName("defaultLocation");
		// cartesian is the default coordinate
		Coordinate c = new CartesianCoordinate();
		this.setCoordinate(c);
	}
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public Location(String name, Coordinate c){
		this.setName(name);
		this.setCoordinate(c);
	}
	

	/**
	 * @methodtype get
	 * 
	 * @return The name of the location
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param name The name to set 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @methodtype get
	 * 
	 * @return The coordinate of the location
	 */
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param coordinate The coordinate object to set 
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
}
