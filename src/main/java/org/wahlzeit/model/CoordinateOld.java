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
public class CoordinateOld extends DataObject{
	
	/**
	 * for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	private static double radius = 6371.0;
	
	/**
	 * members that represent a coordinate
	 */ 
	private double latitude;
	private double longitude;
	
	/**
	 * @methodtype default constructor
	 */
	public CoordinateOld(){
		this.setLatitude(0.0);
		this.setLongitude(0.0);
	}
	
	/**
	 * @methodtype constructor
	 */
	public CoordinateOld(double latitude, double longitude){
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
	public double getDistance(CoordinateOld coordinate){
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
		
		//  computes the distance with formula from Wikipedia (Great-circle distance)
		
		
		double sinusLatitudeThis = Math.sin(Math.toRadians(this.getLatitude()));
		double sinusLatitudeOther = Math.sin(Math.toRadians(coordinate.getLatitude()));
		double cosinusLatitudeThis = Math.cos(Math.toRadians(this.getLatitude()));
		double cosinusLatitudeOther = Math.cos(Math.toRadians(coordinate.getLatitude()));
		double cosinusLongitudeDistance = Math.cos(Math.toRadians(this.getLongitudeDistance(coordinate)));
		
		double distance = Math.acos( (sinusLatitudeThis*sinusLatitudeOther) + 
				 	(cosinusLatitudeThis*cosinusLatitudeOther*cosinusLongitudeDistance) ) * radius;
		
		
		
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
	public double getLatitudeDistance(CoordinateOld coordinate){
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
	public double getLongitudeDistance(CoordinateOld coordinate){
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
		return Math.abs(this.getLongitude() - coordinate.getLongitude());
	}
	
	/**
	 * Checks whether this coordinate object is equal to another object.
	 * 
	 * @methodtype  
	 * 
	 * @param coordinate The another coordinate object
	 * @return	true if equal, false if not
	 */
	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		}
		if(other instanceof CoordinateOld){
			CoordinateOld helper = (CoordinateOld) other;
			if(this.getLatitude() == helper.getLatitude()
					&& this.getLongitude() == helper.getLongitude()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks whether a coordinate object is valid (not equal null)
	 * 
	 * @methodtype helper 
	 * 
	 * @param coordinate The coordinate object to check
	 * @return	true if the object is valid, false if not
	 */
	private boolean checkCoordinateValidity(CoordinateOld coordinate){
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
