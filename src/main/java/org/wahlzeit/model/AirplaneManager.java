package org.wahlzeit.model;

import java.util.HashMap;

import org.wahlzeit.services.DataObject;

/**
 * A airplane manager class manages all the airplanes and airplane types.
 * 
 * @author Elisabeth Hoppe
 * 
 * @version 1.0
 * 
 * @date 04.01.2016
 *
 */
public class AirplaneManager extends DataObject{
	
	/**
	 * for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Maps for airplane instances and their types
	 * */
	private HashMap<Integer, Airplane> airplanes = new HashMap<Integer, Airplane>();
	private HashMap<String, AirplaneType> airplaneTypes = new HashMap<String, AirplaneType>();
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public Airplane createAirplane(String typeName) {
		
		AirplaneType at = getAirplaneType(typeName);
		assert (at != null) : "Invalid airplane type name";
		Airplane resultAirplane = at.createInstance();
		airplanes.put(resultAirplane.getId(), resultAirplane);
		return resultAirplane;
		
	} 
	
	/**
	 * Creates new airplane type (only if it doesn't already exists) and adds it to the types map.
	 * */
	public synchronized void createAirplaneType(String typeName, AirplaneCategory category, int altitude, LandCategory landing) {
		assert(!airplaneTypes.containsKey(typeName)):"Airplane type already exists";
		
		AirplaneType type = new AirplaneType(category, altitude, landing);
		airplaneTypes.put(typeName, type);
	
		
	} 
	
	/**
	 * @methodtype get
	 * 
	 * Gets the type object with the typename
	 * 
	 * @param typeName The name of the type
	 * 
	 * @return The type object if it exists, else null
	 * */
	public synchronized AirplaneType getAirplaneType(String typeName){
		
		if(airplaneTypes.containsKey(typeName)) {
			return airplaneTypes.get(typeName);
		}
		else {
			return null;
		}
	}

}
