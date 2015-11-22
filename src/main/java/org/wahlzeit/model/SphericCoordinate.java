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
		
		assertClassInvariants();
		
		this.setLatitude(0.0);
		this.setLongitude(0.0);
		// default radius value
		this.setRadius(6371.0);
		
		assertClassInvariants();
		
	}
	
	/**
	 * @methodtype   constructor
	 * 
	 * @param latitude The latitude value
	 * @param longitude The longitude value
	 */
	public SphericCoordinate(double latitude, double longitude) {
		
		assertClassInvariants();
		
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		//default radius value
		this.setRadius(6371.0);
		
		assertClassInvariants();
		
	}
	
	/**
	 * @methodtype   constructor
	 * 
	 * @param latitude The latitude value
	 * @param longitude The longitude value
	 * @param radius The radius value
	 */
	public SphericCoordinate(double latitude, double longitude, double radius){
		
		assertClassInvariants();
		
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setRadius(radius);
		
		assertClassInvariants();
		
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
		
		assertClassInvariants();
		
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
		
		assertClassInvariants();
		assertLatitudeValidity(latitude);
		
		this.latitude = latitude;
	
		assertClassInvariants();		
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
		
		assertClassInvariants();
		
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
		
		assertClassInvariants();
		assertLongitudeValidity(longitude);	
		
		this.longitude = longitude;

		assertClassInvariants();
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
		
		assertClassInvariants();
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
		
		assertClassInvariants();
		assertRadiusValidity(radius);
		
		this.radius = radius;
	
		assertClassInvariants();
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
		
		assertClassInvariants();
		assertCoordinateValidity(coordinate);
		
		double distance = Math.abs(this.getLatitude() - coordinate.getLatitude());
		
		assertIsADouble(distance);
		assertClassInvariants();
		
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
		
		assertClassInvariants();
		assertCoordinateValidity(coordinate);
		
		double distance = Math.abs(this.getLongitude() - coordinate.getLongitude());
		
		assertIsADouble(distance);
		assertClassInvariants();
		
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
     * The class invariant assertion method.
     * Checks whether the fields of the class are valid doubles.
     * 
     * @methodtype class invariant assertion
     * */
	@Override
	protected void assertClassInvariants() {
		
		assertIsADouble(this.latitude);
		assertIsADouble(this.longitude);
		assertIsADouble(this.radius);
		
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
		
		assertClassInvariants();
		
		double latitude = Math.toRadians(this.getLatitude());
		double longitude = Math.toRadians(this.getLongitude());
		double radius = this.getRadius();

		double x = radius * Math.cos(longitude) * Math.sin(latitude);
		double y = radius * Math.sin(longitude) * Math.sin(latitude);
		double z = radius * Math.cos(latitude);

		assertIsADouble(x);
		assertIsADouble(y);
		assertIsADouble(z);
		assertClassInvariants();
	
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public double getCoordinateX() {
		
		assertClassInvariants();
		
		return this.getCartesianCoordinate().getCoordinateX();
	}

	@Override
	public double getCoordinateY() {
		
		assertClassInvariants();
		
		return this.getCartesianCoordinate().getCoordinateY();
	}

	@Override
	public double getCoordinateZ() {
		
		assertClassInvariants();
		
		return this.getCartesianCoordinate().getCoordinateZ();
	}
	
	
}
