package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

/**
 * Coordinate basic class 
 * 
 * A coordinate represents a location.
 * 
 * @version 2.0
 * 
 * @date 1.11.2015
 */
public class Coordinate extends DataObject{
	
	/**
	 * for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * members that represent a coordinate
	 */ 
	private double latitude;
	private double longitude;
	
	/**
	 * @methodtype default constructor
	 */
	public Coordinate(){
		this.setLatitude(0.0);
		this.setLongitude(0.0);
	}
	
	/**
	 * @methodtype constructor
	 */
	public Coordinate(double latitude, double longitude){
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}
	
	/**
	 * @methodtype set
	 */
	private void setLatitude(double latitude){
		if(checkLatitudeValidity(latitude)){
			this.latitude = latitude;
		}
		else{
			throw new IllegalArgumentException("Value of latitude is invalid.");
		}
	}
	
	/**
	 * @methodtype set
	 */
	private void setLongitude(double longitude){
		if(checkLongitudeValidity(longitude)){
			this.longitude = longitude;
		}
		else{
			throw new IllegalArgumentException("Value of longitude is invalid.");
		}
	}
	
	/**
	 * @methodtype get
	 */
	public double getLatitude(){
		return this.latitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getLongitude(){
		return this.longitude;
	}
	
	/**
	 * Computes the distance between this coordinate and another one.
	 * 
	 * @methodtype composed 
	 * 
	 * @param coordinate The another coordinate
	 * @return kilometers value between the two coordinates
	 */
	public double getDistance(Coordinate coordinate){
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
		
		//  computes the distance with formula from Wikipedia (Great-circle distance)
		//  first compute the angel, then the distance in kilometer
		
		double sinusLatitudeThis = Math.sin(this.getLatitude());
		double sinusLatitudeOther = Math.sin(coordinate.getLatitude());
		double cosinusLatitudeThis = Math.cos(this.getLatitude());
		double cosinusLatitudeOther = Math.cos(coordinate.getLatitude());
		double cosinusLongitudeDistance = Math.cos(this.getLongitudeDistance(coordinate));
		
		double angle = Math.acos( (sinusLatitudeThis*sinusLatitudeOther) + 
				 	(cosinusLatitudeThis*cosinusLatitudeOther*cosinusLongitudeDistance) );
		
		// assumption: radius of earth 6370 km
		double distance = (angle/360.0) * 40000;
		
		return distance;
	}
	
	/**
	 * Computes the latitude distance of this and another coordinate object.
	 * 
	 * @methodtype helper 
	 * 
	 * @param coordinate The another coordinate object
	 * @return	The distance of latitudes
	 */
	public double getLatitudeDistance(Coordinate coordinate){
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
		return Math.abs(this.getLatitude() - coordinate.getLatitude());
	}
	
	/**
	 * Computes the lontitude distance of this and another coordinate object.
	 * 
	 * @methodtype helper 
	 * 
	 * @param coordinate The another coordinate object
	 * @return	The distance of lontitudes
	 */
	public double getLongitudeDistance(Coordinate coordinate){
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
		return Math.abs(this.getLongitude() - coordinate.getLongitude());
	}
	
	/**
	 * Checks whether a coordinate object is valid (not equal null)
	 * 
	 * @methodtype helper 
	 * 
	 * @param coordinate The coordinate object to check
	 * @return	true if the object is valid, false if not
	 */
	private boolean checkCoordinateValidity(Coordinate coordinate){
		if(coordinate == null){
			return false;
		}
		return true;
	}
	
	/**
	 * Checks whether a latitude value is valid (between -90 and 90)
	 * 
	 * @methodtype helper 
	 * 
	 * @param latitude The value to check
	 * @return	true if the value is valid, false otherwise
	 */
	private boolean checkLatitudeValidity(double latitude){
		if(latitude >= -90 && latitude <= 90){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks whether a longitude value is valid (between -180 and 180)
	 * 
	 * @methodtype helper 
	 * 
	 * @param longitude The value to check
	 * @return	true if the value is valid, false otherwise
	 */
	private boolean checkLongitudeValidity(double longitude){
		if(longitude >= -180 && longitude <= 180){
			return true;
		}
		return false;
	}
	
	
}
