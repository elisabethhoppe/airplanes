package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

/**
 * A airplane type class represents an airplane type.
 * 
 * @author Elisabeth Hoppe
 * 
 * @version 1.0
 * 
 * @date 04.01.2016
 *
 */
public class AirplaneType extends DataObject{
	
	/**
	 * for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * attributes of the type
	 * */
	private AirplaneCategory airplaneCategory;
	private int flyingAltitude;
	private LandCategory landCategory;
	
	/**
	 * Super and subtypes of this type
	 * */
	protected AirplaneType superType = null;
	protected Set<AirplaneType> subTypes = new HashSet<AirplaneType>();
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public AirplaneType(AirplaneCategory category, int altitude, LandCategory landing){
		
		assert(category != null) : "Airplane categorie cannot be null";
		assert(altitude >= 0) : "Altitude cannot be < 0";
		assert(landing != null) : "Landing type cannot be null";
		
		this.airplaneCategory = category;
		this.flyingAltitude = altitude;
		this.landCategory = landing;
		
	}
	
	/**
	 * @methodtype get
	 * 
	 * Gets the super type of this type
	 * */
	public AirplaneType getSuperType() {
		return this.superType;
	}
	
	/**
	 * @methodtype get
	 * 
	 * Gets the iterator for the subtypes of this type
	 * */
	public Iterator<AirplaneType> getSubTypesIterator() {
		return subTypes.iterator();
	}
	
	/**
	 * Adds a subtype to the subtypes of this type
	 * */
	public void addSubType(AirplaneType at) {
		assert (at != null) : "Null cannot be set as a subtype";
		subTypes.add(at);
	}
	
	/**
	 * Checks whether an airplane instance is instance of this type
	 * 
	 * @return true if it is an instance, false if not
	 * */
	public boolean isInstance(Airplane airplane) {
		 assert (airplane != null) : "Airplane instance cannot be null";
		 
		 if (airplane.getType() == this) {
			 return true;
		 }
		 
		 for (AirplaneType type : subTypes) {
			 
			 if (type.isInstance(airplane)) {
				 return true;
			 }
			 
		 }
		 
		 return false;
	}
	
	/**
	 * Creates a new instance of an airplane and this type
	 * 
	 * @return a new airplane instance
	 * */
	public Airplane createInstance() {
		return new Airplane(this);
	}
	
	/**
	 * @methodtype get
	 * 
	 * Gets the airplane category
	 * */
	public AirplaneCategory getCategory(){
		return this.airplaneCategory;
	}
	
	/**
	 * @methodtype get
	 * 
	 * Gets the flying altitude
	 * */
	public int getAltitude(){
		
		return this.flyingAltitude;
	}
	
	/**
	 * @methodtype get
	 * 
	 * Gets the landing type 
	 * */
	public LandCategory getLanding(){
		return this.landCategory;
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param category The airplane category to set
	 */
	public void setCategory(AirplaneCategory category){
		this.airplaneCategory = category;
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param altitude The flying altitude to set
	 */
	public void setAltitude(int altitude){
		
		this.flyingAltitude = altitude;
	}
	
	/**
	 * @methodtype set
	 * 
	 * @param landing The land category to set
	 */
	public void setLanding(LandCategory landing){
		this.landCategory = landing;
	}
}


