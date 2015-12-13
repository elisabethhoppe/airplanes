package org.wahlzeit.model;



/**
 * Cartesian coordinate class
 * 
 * Represents a location based on cartesian coordinates
 * 
 * @author Elisabeth Hoppe
 * 
 * @version 4.0
 * 
 * @date 13.12.2015
 */
public class CartesianCoordinate extends AbstractCoordinate {
	
	/**
	 * for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * members
	 * */
	final private double coordinateX;
	final private double coordinateY;
	final private double coordinateZ;
	
	
	
	/**
	 * Method to get a default instance; returns a new object or an existing one
	 * 
	 * @return A new/existing cartesian coordinate object with default values
	 */
	public static CartesianCoordinate getInstance() {
		
		// delegation
		return getInstance(0.0,0.0,0.0);
	}
	
	/**
	 * Method to get an instance of cartesian coordinate; returns a new or an existing one. First checks whether an object with these values already exists.
	 * 
	 * @param x The x value
	 * @param y The y value
	 * @param z The z value
	 * 
	 * @return A new/existing object with desired values
	 */
	public static CartesianCoordinate getInstance(double x, double y, double z) {
		
		Coordinate result = checkAlreadyExists(x,y,z);
		
		if(result == null || !(result instanceof CartesianCoordinate) ) {
			
			// call constructor & create a new one, add it to the list
			synchronized(Lock) {
				result = checkAlreadyExists(x,y,z);
				if (result == null || !(result instanceof CartesianCoordinate) ) {
					result = new CartesianCoordinate(x,y,z);
					existingCoordinates.add((Coordinate)result);
				}
			}
		}
		
		return (CartesianCoordinate) result;
	}
	
	
	/**
	 * @methodtype   constructor
	 * 
	 * @param x The x value
	 * @param y The y value
	 * @param z The z value
	 */
	private CartesianCoordinate(double x, double y, double z) {
		
		assertIsADouble(x);
		assertIsADouble(y);
		assertIsADouble(z);
		
		coordinateX = x;
		coordinateY = y;
		coordinateZ = z;
		
		assertClassInvariants();
		
	}
	
	/**
	 * Gets the x value
	 * 
	 * @methodtype  get
	 * @methodproperties primitive  
	 *
	 * @return The x value
	 */
	public double getCoordinateX() {
		
		return coordinateX;
	}
	
	/**
	 * Sets the x value; returns a new object with the modiefied x value ( or an already exisiting object )
	 * 
	 * @methodtype  set
	 * @methodproperties primitive 
	 * 
	 * @param coordinateX The x value
	 * 
	 * @return A new/other object with the modified x value
	 */
	public CartesianCoordinate setCoordinateX(double coordinateX) {
		
		assertIsADouble(coordinateX);
		
		// creates new object with the modified x value or get an existing instance 
		CartesianCoordinate result = CartesianCoordinate.getInstance(coordinateX, this.getCoordinateY(), this.getCoordinateZ());
		
		assertClassInvariants();
		
		// return the new object
		return result;
	}
	
	/**
	 * Gets the y value
	 * 
	 * @methodtype  get
	 * @methodproperties primitive  
	 *
	 * @return The y value
	 */
	public double getCoordinateY() {

		return coordinateY;
	}
	
	/**
	 * Sets the y value; returns a new object with the modiefied y value ( or an already exisiting object )
	 * 
	 * @methodtype  set
	 * @methodproperties primitive  
	 *
	 * @param coordinateY The y value
	 * 
	 * @return A new/other object with the modified y value
	 */
	public CartesianCoordinate setCoordinateY(double coordinateY) {
	
		assertIsADouble(coordinateY);
		
		// creates new object with the modified y value or get an existing instance 
		CartesianCoordinate result = CartesianCoordinate.getInstance(this.getCoordinateX(), coordinateY, this.getCoordinateZ());
		
		assertClassInvariants();
		
		// return the new object
		return result;
	}
	
	/**
	 * Gets the z value
	 * 
	 * @methodtype  get
	 * @methodproperties primitive 
	 *  
	 * @return The z value
	 */
	public double getCoordinateZ() {
		
		return coordinateZ;
	}
	
	/**
	 * Sets the z value; returns a new object with the modiefied z value ( or an already exisiting object )
	 * 
	 * @methodtype  set
	 * @methodproperties primitive  
	 *
	 * @param coordinateZ The z value
	 * 
	 * @return A new/other object with the modified z value
	 */
	public CartesianCoordinate setCoordinateZ(double coordinateZ) {
		
		assertIsADouble(coordinateZ);
		
		// creates new object with the modified z value or get an existing instance 
		CartesianCoordinate result = CartesianCoordinate.getInstance(this.getCoordinateX(), this.getCoordinateY(), coordinateZ);
		
		assertClassInvariants();
		
		// return the new object
		return result;	
	}
	
	/**
	 * Computes the x distance
	 * 
	 * @methodtype  helper
	 * 
	 *
	 * @param coordinate The another coordinate
	 * @return The x distance value
	 */
	public double getXDistance(CartesianCoordinate coordinate){
		
		assertCoordinateValidity(coordinate);
		
		double distance = this.getCoordinateX()-coordinate.getCoordinateX();
		
		assertIsADouble(distance);
		
		return distance;
	}
	
	/**
	 * Computes the y distance
	 * 
	 * @methodtype  helper
	 * 
	 *
	 * @param coordinate The another coordinate
	 * @return The y distance value
	 */
	public double getYDistance(CartesianCoordinate coordinate){
		
		assertCoordinateValidity(coordinate);
		
		double distance = this.getCoordinateY()-coordinate.getCoordinateY();
		
		assertIsADouble(distance);
		
		return distance;
	}
	
	/**
	 * Computes the z distance
	 * 
	 * @methodtype  helper
	 * 
	 *
	 * @param coordinate The another coordinate
	 * @return The z distance value
	 */
	public double getZDistance(CartesianCoordinate coordinate){
		
		assertCoordinateValidity(coordinate);
		
		double distance = this.getCoordinateZ()-coordinate.getCoordinateZ();
		
		assertIsADouble(distance);
		
		return distance;
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
		
		return this;
	}
	
	/**
     * The class invariant assertion method.
     * Checks whether the fields of the class are valid doubles.
     * 
     * @methodtype class invariant assertion
     * */
	@Override
	protected void assertClassInvariants() {
		
		assertIsADouble(this.coordinateX);
		assertIsADouble(this.coordinateY);
		assertIsADouble(this.coordinateZ);
		
	}

}
