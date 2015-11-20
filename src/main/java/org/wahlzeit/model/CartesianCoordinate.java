package org.wahlzeit.model;



/**
 * Cartesian coordinate class
 * 
 * Represents a location based on cartesian coordinates
 * 
 * @version 3.0
 * 
 * @date 20.11.2015
 */
public class CartesianCoordinate extends AbstractCoordinate {
	
	/**
	 * for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * members
	 * */
	private double coordinateX;
	private double coordinateY;
	private double coordinateZ;
	
	/**
	 * @methodtype  default constructor
	 * 
	 */
	public CartesianCoordinate() {
		this.setCoordinateX(0.0);
		this.setCoordinateY(0.0);
		this.setCoordinateZ(0.0);
	}
	
	/**
	 * @methodtype   constructor
	 * 
	 * @param x The x value
	 * @param y The y value
	 * @param z The z value
	 */
	public CartesianCoordinate(double x, double y, double z) {
		
		this.setCoordinateX(x);
		this.setCoordinateY(y);
		this.setCoordinateZ(z);
		
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
		assertIsADouble(coordinateX);
		return coordinateX;
	}
	
	/**
	 * Sets the x value
	 * 
	 * @methodtype  set
	 * @methodproperties primitive 
	 * 
	 * @param coordinateX The x value
	 */
	public void setCoordinateX(double coordinateX) {
		
		assertIsADouble(coordinateX);
		
		this.coordinateX = coordinateX;
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
		
		assertIsADouble(coordinateY);
		return coordinateY;
	}
	
	/**
	 * Sets the y value
	 * 
	 * @methodtype  set
	 * @methodproperties primitive  
	 *
	 * @param coordinateY The y value
	 */
	public void setCoordinateY(double coordinateY) {
		
		assertIsADouble(coordinateY);
		this.coordinateY = coordinateY;
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
		
		assertIsADouble(coordinateZ);
		return coordinateZ;
	}
	
	/**
	 * Sets the z value
	 * 
	 * @methodtype  set
	 * @methodproperties primitive  
	 *
	 * @param coordinateZ The z value
	 */
	public void setCoordinateZ(double coordinateZ) {
		
		assertIsADouble(coordinateZ);
		this.coordinateZ = coordinateZ;
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

}
