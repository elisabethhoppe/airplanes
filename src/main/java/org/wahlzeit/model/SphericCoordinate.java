package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

/**
 * Spheric Coordinate class
 * 
 * Represents a location based on spheric coordinate.
 * 
 * @version 1.0
 * 
 * @date 5.11.2015
 */
public class SphericCoordinate extends DataObject implements Coordinate  {
	
	/**
	 * for persistence issues
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * members
	 */
	private double latitude;
	private double longitude;
	private double radius;
	
	public SphericCoordinate(){
		this.setLatitude(0.0);
		this.setLongitude(0.0);
		// default radius value
		this.setRadius(6371);
	}
	
	public SphericCoordinate(double latitude, double longitude) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		//default radius value
		this.setRadius(6371);
	}
	
	public SphericCoordinate(double latitude, double longitude, double radius){
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setRadius(radius);
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		if(!checkLatitudeValidity(latitude)) {
			throw new IllegalArgumentException("Latitude value must be between -90 and 90.");
		}
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		if(!checkLongitudeValidity(longitude)) {
			throw new IllegalArgumentException("Longitude value must be between -180 and 180.");
		}
		this.longitude = longitude;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(!checkRadiusValidity(radius)) {
			throw new IllegalArgumentException("Radius must not be smaller than 0");
		}
		this.radius = radius;
	}

	@Override
	public double getDistance(Coordinate coordinate) {
		
		if(!checkCoordinateValidity((SphericCoordinate) coordinate)){
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
		
		SphericCoordinate sCoordinate = (SphericCoordinate) coordinate;
		
		//  computes the distance with formula from Wikipedia (Great-circle distance)
		
		double sinusLatitudeThis = Math.sin(Math.toRadians(this.getLatitude()));
		double sinusLatitudeOther = Math.sin(Math.toRadians(sCoordinate.getLatitude()));
		double cosinusLatitudeThis = Math.cos(Math.toRadians(this.getLatitude()));
		double cosinusLatitudeOther = Math.cos(Math.toRadians(sCoordinate.getLatitude()));
		double cosinusLongitudeDistance = Math.cos(Math.toRadians(this.getLongitudeDistance(sCoordinate)));
		
		double distance = Math.acos( (sinusLatitudeThis*sinusLatitudeOther) + 
				 	(cosinusLatitudeThis*cosinusLatitudeOther*cosinusLongitudeDistance) ) * radius;
		
		
		
		return distance;
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		if(this == coordinate) {
			return true;
		}
		if(this.getClass() != coordinate.getClass()) { 
			return false;
		}
		
		if(!(coordinate instanceof SphericCoordinate)) {
			return false;
		}
		
		SphericCoordinate sCoordinate = (SphericCoordinate) coordinate;
		if(sCoordinate.getLatitude() == this.getLatitude()
				&& sCoordinate.getLongitude() == this.getLongitude()
				&& sCoordinate.getRadius() == this.getRadius()) {			
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Computes the latitude distance of this and another coordinate object.
	 * 
	 * @methodtype helper 
	 * 
	 * @param coordinate The another coordinate object
	 * @return	The distance of latitudes
	 */
	public double getLatitudeDistance(SphericCoordinate coordinate){
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
	public double getLongitudeDistance(SphericCoordinate coordinate){
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
	private boolean checkCoordinateValidity(SphericCoordinate coordinate){
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
	
	private boolean checkRadiusValidity(double radius) {
		if(radius > 0.0) {
			return true;
		}
		return false;
	}

}
