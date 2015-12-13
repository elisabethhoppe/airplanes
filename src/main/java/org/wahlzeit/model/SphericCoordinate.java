package org.wahlzeit.model;

import static org.wahlzeit.model.AbstractCoordinate.Lock;

/**
 * Spheric Coordinate class
 * 
 * Represents a location based on spheric coordinate.
 * 
 * @author Elisabeth Hoppe
 * 
 * @version 4.0
 * 
 * @date 13.12.2015
 */
public class SphericCoordinate extends AbstractCoordinate  {
	
	
	/**
	 * for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * members
	 */
	final private double latitude;
	final private double longitude;
	final private double radius;
	
	
	/**
	 * Method to get a default instance; returns a new object or an existing one
	 * 
	 * @return A new/existing spheric coordinate object with default values
	 */
	public static SphericCoordinate getInstance() {
		
		// delegation
		return getInstance(0.0,0.0,6371.0);
	}
	
	/**
	 * Method to get an instance with default radius value; returns a new object or an existing one
	 * 
	 * @return A new/existing spheric coordinate object with default values
	 */
	public static SphericCoordinate getInstance(double latitude, double longitude) {
		
		// delegation
		return getInstance(latitude, longitude, 6371.0);
	}
	
	/**
	 * Method to get an instance of spheric coordinate; returns a new or an existing one. First checks whether an object with these values already exists.
	 * 
	 * @param latitude The latitude value
	 * @param longitude The longitude value
	 * @param radius The radius value
	 * 
	 * @return A new/existing object with desired values
	 */
	public static SphericCoordinate getInstance(double latitude, double longitude, double radius) {
		
		
		double x = doConvertToX(latitude, longitude, radius);
		double y = doConvertToY(latitude, longitude, radius);
		double z = doConvertToZ(latitude, radius);
		
		Coordinate result = checkAlreadyExists(x,y,z);
		
		if(result == null || !(result instanceof SphericCoordinate) ) {
			
			// call constructor & create a new one, add it to the list
			synchronized(Lock) {
				result = checkAlreadyExists(x,y,z);
				if (result == null || !(result instanceof SphericCoordinate) ) {
					result = new SphericCoordinate(latitude, longitude, radius);
					existingCoordinates.add((Coordinate)result);
				}
			}
		}
		
		return (SphericCoordinate) result;
	}
	
	/**
	 * @methodtype   constructor
	 * 
	 * @param latitude The latitude value
	 * @param longitude The longitude value
	 * @param radius The radius value
	 */
	private SphericCoordinate(double latitude, double longitude, double radius){
		
		assertLatitudeValidity(latitude);
		assertLongitudeValidity(longitude);
		assertRadiusValidity(radius);
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		
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
		
		return latitude;
	}
	
	/**
	 * Sets the latitude value; returns a new object with the modiefied latitude value ( or an already exisiting object )
	 * 
	 * @methodtype  set
	 * @methodproperties composed
	 * 
	 * @param latitude The latitude value
	 * 
	 * @return A new/other object with the modified latitude value
	 */
	public SphericCoordinate setLatitude(double latitude) {
		
		assertLatitudeValidity(latitude);
		
		// create a new object with modified content
		SphericCoordinate result = new SphericCoordinate(latitude, this.getLongitude(), this.getRadius());
		
		assertClassInvariants();	
		
		// return the new object
		return result;
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
	 * Sets the longitude value; returns a new object with the modiefied longitude value ( or an already exisiting object )
	 * 
	 * @methodtype  set
	 * @methodproperties composed
	 * 
	 * @param longitude The longitude value
	 * 
	 * @return A new/other object with the modified longitude value
	 */
	public SphericCoordinate setLongitude(double longitude) {
		
		assertLongitudeValidity(longitude);	
		
		// create a new object with modified content
		SphericCoordinate result = new SphericCoordinate(this.getLatitude(), longitude, this.getRadius());
			
		assertClassInvariants();
		
		// return the new object
		return result;
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
		
		//assertClassInvariants();
		return radius;
		
	}
	
	/**
	 * Sets the radius value; returns a new object with the modiefied radius value ( or an already exisiting object )
	 * 
	 * @methodtype  set
	 * @methodproperties composed
	 * 
	 * @param radius The radius value
	 * 
	 * @return A new/other object with the modified longitude value
	 */
	public SphericCoordinate setRadius(double radius) {
		
		assertRadiusValidity(radius);
		
		// create a new object with modified content
		SphericCoordinate result = new SphericCoordinate(this.getLatitude(), this.getLongitude(), radius);
				
		assertClassInvariants();
		
		// return the new object
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
	private static void assertLatitudeValidity(double latitude){
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
	 */
	private static void assertLongitudeValidity(double longitude){
		if( !(longitude >= -180 && longitude <= 180) ){
			throw new IllegalArgumentException("Longitude value must be between -180 and 180.");
		}
	}
	
	/**
	 * Checks whether a radius value is valid (greater than 0), otherwise throws exception
	 * 
	 * @methodtype assertion 
	 * 
	 * @param radius The value to check
	 */
	private static void assertRadiusValidity(double radius) {
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
		
		
		double x = doConvertToX(this.getLatitude(), this.getLongitude(), this.getRadius());
		double y = doConvertToY(this.getLatitude(), this.getLongitude(), this.getRadius());
		double z = doConvertToZ(this.getLatitude(), this.getRadius());

		assertIsADouble(x);
		assertIsADouble(y);
		assertIsADouble(z);
		assertClassInvariants();
		
		return CartesianCoordinate.getInstance(x, y, z);
	}
	
	/**
	 * Computes the x value from latitude, longitude and radius values.
	 * 
	 * @methodtype primitive helper 
	 * 
	 * @param latitude The latitude value
	 * @param longitude The longitude value
	 * @param radius The radius value
	 * 
	 * @return The converted value
	 */
	 private static double doConvertToX(double latitude, double longitude, double radius) {
		 
		double radLatitude = Math.toRadians(latitude);
		double radLongitude = Math.toRadians(longitude);
		
		double x = radius * Math.cos(radLongitude) * Math.sin(radLatitude);
		
		return x;
	 }
	 
	 /**
	 * Computes the y value from latitude, longitude and radius values.
	 * 
	 * @methodtype primitive helper 
	 * 
	 * @param latitude The latitude value
	 * @param longitude The longitude value
	 * @param radius The radius value
	 * 
	 * @return The converted value
	 */
	 private static double doConvertToY(double latitude, double longitude, double radius) {
		 
		double radLatitude = Math.toRadians(latitude);
		double radLongitude = Math.toRadians(longitude);
		
		double y = radius * Math.sin(radLongitude) * Math.sin(radLatitude);
		
		return y;
	 }
	 
	 /**
	 * Computes the z value from latitude and radius values.
	 * 
	 * @methodtype primitive helper 
	 * 
	 * @param latitude The latitude value
	 * @param radius The radius value
	 * 
	 * @return The converted value
	 */
	 private static double doConvertToZ(double latitude, double radius) {
		 
		double radLatitude = Math.toRadians(latitude);
		double z = radius * Math.cos(radLatitude);
		
		return z;
	 }

	@Override
	public double getCoordinateX() {
		return doConvertToX(this.getLatitude(), this.getLongitude(), this.getRadius());
	}

	@Override
	public double getCoordinateY() {
		return doConvertToY(this.getLatitude(), this.getLongitude(), this.getRadius());
	}

	@Override
	public double getCoordinateZ() {
		return doConvertToZ(this.getLatitude(), this.getRadius());
	}
	
	
}
