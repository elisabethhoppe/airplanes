package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

/**
 * Coordinate basic class 
 * 
 * A coordinate represents a location.
 * 
 * @version 1.0
 * 
 * @date 25.10.2015
 */
public class Coordinate extends DataObject{
	
	/**
	 * for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * members that represent a coordinate
	 */ 
	private double m_dLatitude;
	private double m_dLongitude;
	
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
		if(latitude >= -90 && latitude <= 90){
			this.m_dLatitude = latitude;
		}
		else{
			throw new IllegalArgumentException("Value of latitude is invalid.");
		}
	}
	
	/**
	 * @methodtype set
	 */
	private void setLongitude(double longitude){
		if(longitude >= -180 && longitude <= 180){
			this.m_dLongitude = longitude;
		}
		else{
			throw new IllegalArgumentException("Value of longitude is invalid.");
		}
	}
	
	/**
	 * @methodtype get
	 */
	public double getLatitude(){
		return this.m_dLatitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getLongitude(){
		return this.m_dLongitude;
	}
	
	/**
	 * Computes the difference between this coordinate and another one.
	 * 
	 * @methodtype composed 
	 * 
	 * @param coordinate The another coordinate
	 * @return A coordinate object with the distance information
	 */
	public Coordinate getDistance(Coordinate coordinate){
		if(coordinate == null){
			throw new NullPointerException("Argument coordinate object is null");
		}
		Coordinate result = new Coordinate(getLatitudeDistance(coordinate), getLongitudeDistance(coordinate));
		return result;
	}
	
	/**
	 * Computes the latitude distance of this and another coordinate object.
	 * 
	 * @methodtype helper 
	 * 
	 * @param coordinate The another coordinate object
	 * @return	The distance of latitudes
	 */
	private double getLatitudeDistance(Coordinate coordinate){
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
	private double getLongitudeDistance(Coordinate coordinate){
		return Math.abs(this.getLongitude() - coordinate.getLongitude());
	}
}
