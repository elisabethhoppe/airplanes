package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

/**
 * Spheric Coordinate class
 * 
 * Represents a location based on spheric coordinate.
 * 
 * @version 2.0
 * 
 * @date 15.11.2015
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
	
	/**
	 * @methodtype  default constructor
	 * 
	 */
	public SphericCoordinate(){
		this.setLatitude(0.0);
		this.setLongitude(0.0);
		// default radius value
		this.setRadius(6371);
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
		this.setRadius(6371);
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
	 * Computes the distance between two spheric coordinates with great circle distance formel
	 * 
	 * @methodtype  command
	 * @methodproperties template  
	 *
	 * @param coordinate The another coordinate
	 * @return The distance
	 */
	@Override
	public double getDistance(Coordinate coordinate) {
		
		if(!checkCoordinateValidity((SphericCoordinate) coordinate)){
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
		
		SphericCoordinate sCoordinate = getSphericCoordinate(coordinate);
		
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
	
	/**
	 * Tests whether this and another coordinates are equal
	 * 
	 * @methodtype  comparison
	 * @methodproperties template  
	 *
	 * @param coordinate The another coordinate
	 * @return True if the two coordinates are equal, false if not
	 */
	@Override
	public boolean isEqual(Coordinate coordinate) {
		if(this == coordinate) {
			return true;
		}
		
		/*if(this.getClass() != coordinate.getClass()) { 
			return false;
		}*/
		
		/*if(!(coordinate instanceof SphericCoordinate)) {
			return false;
		}*/
		
		SphericCoordinate sCoordinate = getSphericCoordinate(coordinate);
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
	 * Gets the coordinate as a spheric coordinate
	 * 
	 * @methodtype conversion
	 * 
	 * @param coordinate A coordinate to convert
	 * @return The coordinate as SphericCoordinate object
	 */
	private SphericCoordinate getSphericCoordinate(Coordinate coordinate) {
		if (coordinate instanceof SphericCoordinate) {
			return (SphericCoordinate) coordinate;
		} 
		else if (coordinate instanceof CartesianCoordinate) {
			return convertToSphericCoordinate((CartesianCoordinate) coordinate);
		} 
		else {
			throw new IllegalArgumentException("This coordinate type is not known.");
		}
	}

	/**
	 * Does the conversion to a spheric coordinate subclass 
	 * 
	 * @methodtype conversion
	 * 
	 * @param coordinate A coordinate to convert
	 * @return The coordinate as SphericCoordinate object
	 */
	private SphericCoordinate convertToSphericCoordinate(CartesianCoordinate coordinate) {
		double xValue = coordinate.getCoordinateX();
		double yValue = coordinate.getCoordinateY();
		double zValue = coordinate.getCoordinateZ();

		double radius = Math.sqrt(xValue * xValue + yValue * yValue + zValue * zValue);
		double latitude = Math.toDegrees(Math.acos(zValue / radius));
		double longitude = Math.toDegrees(Math.atan2(yValue, xValue));

		return new SphericCoordinate(latitude, longitude, radius);
	}

	
	/**
	 * Checks whether a coordinate object is valid (not equal null)
	 * 
	 * @methodtype assertion
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

}
