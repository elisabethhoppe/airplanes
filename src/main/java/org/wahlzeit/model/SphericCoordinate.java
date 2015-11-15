package org.wahlzeit.model;


/**
 * Spheric Coordinate class
 * 
 * Represents a location based on spheric coordinate.
 * 
 * @version 2.0
 * 
 * @date 15.11.2015
 */
public class SphericCoordinate extends AbstractCoordinate  {
	
	
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
	
	/**
	 * @methodtype  default constructor
	 * 
	 */
	public SphericCoordinate(){
		this.setLatitude(0.0);
		this.setLongitude(0.0);
		// default radius value
		this.setRadius(6371.0);
	}
	
	/**
	 * @methodtype   constructor
	 * 
	 * @param latitude The latitude value
	 * @param longitude The longitude value
	 */
	public SphericCoordinate(double latitude, double longitude) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		//default radius value
		this.setRadius(6371.0);
	}
	
	/**
	 * @methodtype   constructor
	 * 
	 * @param latitude The latitude value
	 * @param longitude The longitude value
	 * @param radius The radius value
	 */
	public SphericCoordinate(double latitude, double longitude, double radius){
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setRadius(radius);
	}
	
	/**
	 * Gets the latitude value
	 * 
	 * @methodtype  get
	 * @methodproperties primitive  
	 *
	 * @return The latitude value
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude value
	 * 
	 * @methodtype  set
	 * @methodproperties composed
	 * 
	 * @param latitude The latitude value
	 */
	public void setLatitude(double latitude) {
		if(!checkLatitudeValidity(latitude)) {
			throw new IllegalArgumentException("Latitude value must be between -90 and 90.");
		}
		this.latitude = latitude;
	}
	
	/**
	 * Gets the longitude value
	 * 
	 * @methodtype  get
	 * @methodproperties primitive  
	 *
	 * @return The longitude value
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude value
	 * 
	 * @methodtype  set
	 * @methodproperties composed
	 * 
	 * @param longitude The longitude value
	 */
	public void setLongitude(double longitude) {
		if(!checkLongitudeValidity(longitude)) {
			throw new IllegalArgumentException("Longitude value must be between -180 and 180.");
		}
		this.longitude = longitude;
	}
	
	/**
	 * Gets the radius value
	 * 
	 * @methodtype  get
	 * @methodproperties primitive  
	 *
	 * @return The radius value
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * Sets the radius value
	 * 
	 * @methodtype  set
	 * @methodproperties composed
	 * 
	 * @param radius The radius value
	 */
	public void setRadius(double radius) {
		if(!checkRadiusValidity(radius)) {
			throw new IllegalArgumentException("Radius must not be smaller than 0");
		}
		this.radius = radius;
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
	 * Computes the longitude distance of this and another coordinate object.
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
	 * Checks whether a latitude value is valid (between -90 and 90)
	 * 
	 * @methodtype assertion
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
	 * @methodtype assertion 
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
	
	/**
	 * Checks whether a radius value is valid (greater than 0)
	 * 
	 * @methodtype assertion 
	 * 
	 * @param radius The value to check
	 * @return	true if the value is valid, false otherwise
	 */
	private boolean checkRadiusValidity(double radius) {
		if(radius > 0.0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the coordinate as a cartesian coordinate.
	 * 
	 * @methodtype conversion
	 *
	 * @return The coordinate as CartesianCoordinate object
	 */
	@Override
	public CartesianCoordinate getCartesianCoordinate() {
		double latitude = Math.toRadians(this.getLatitude());
		double longitude = Math.toRadians(this.getLongitude());
		double radius = this.getRadius();

		double x = radius * Math.cos(longitude) * Math.sin(latitude);
		double y = radius * Math.sin(longitude) * Math.sin(latitude);
		double z = radius * Math.cos(latitude);

		return new CartesianCoordinate(x, y, z);
	}

}
