package org.wahlzeit.model;


/**
 * Spheric Coordinate class
 * 
 * Represents a location based on spheric coordinate.
 * 
 * @version 3.0
 * 
 * @date 20.11.2015
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
		
		assertIsADouble(latitude);
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
		assertLatitudeValidity(latitude);
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
		assertIsADouble(longitude);
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
		assertLongitudeValidity(longitude);	
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
		assertIsADouble(radius);
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
		assertRadiusValidity(radius);
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
		
		assertCoordinateValidity(coordinate);
		double distance = Math.abs(this.getLatitude() - coordinate.getLatitude());
		assertIsADouble(distance);
		return distance;
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
		
		assertCoordinateValidity(coordinate);
		double distance = Math.abs(this.getLongitude() - coordinate.getLongitude());
		assertIsADouble(distance);
		return distance;
	}
	
	/**
	 * Checks whether a latitude value is valid (between -90 and 90), otherwise throws exception
	 * 
	 * @methodtype assertion
	 * 
	 * @param latitude The value to check
	 */
	private void assertLatitudeValidity(double latitude){
		if( !(latitude >= -90 && latitude <= 90) ){
			throw new IllegalArgumentException("Latitude value must be between -90 and 90.");
		}
	}
	
	/**
	 * Checks whether a longitude value is valid (between -180 and 180), otherwise throws exception
	 * 
	 * @methodtype assertion 
	 * 
	 * @param longitude The value to check
	 * @return	true if the value is valid, false otherwise
	 */
	private void assertLongitudeValidity(double longitude){
		if( !(longitude >= -180 && longitude <= 180) ){
			throw new IllegalArgumentException("Longitude value must be between -180 and 180.");
		}
	}
	
	/**
	 * Checks whether a radius value is valid (greater than 0)
	 * 
	 * @methodtype assertion 
	 * 
	 * @param radius The value to check
	 * @return	true if the value is valid, false otherwise
	 */
	private void assertRadiusValidity(double radius) {
		if( !(radius > 0.0) ) {
			throw new IllegalArgumentException("Radius must not be smaller than 0");
		}
	}
	
	/**
	 * Checks whether a object is a double number object. If not, throws exception
	 * 
	 * @methodtype assertion
	 * 
	 * @param number The number to check
	 * 
	 */
	private void assertIsADouble(double number){
		if(Double.isNaN(number)){
			throw new IllegalArgumentException("Some components are not numbers, but have to be.");
		}
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

		assertIsADouble(x);
		assertIsADouble(y);
		assertIsADouble(z);
		
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public double getCoordinateX() {
		return this.getCartesianCoordinate().getCoordinateX();
	}

	@Override
	public double getCoordinateY() {
		return this.getCartesianCoordinate().getCoordinateY();
	}

	@Override
	public double getCoordinateZ() {
		return this.getCartesianCoordinate().getCoordinateZ();
	}
	
	
}
