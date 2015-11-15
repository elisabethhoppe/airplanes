package org.wahlzeit.model;



/**
 * Cartesian coordinate class
 * 
 * Represents a location based on cartesian coordinates
 * 
 * @version 2.0
 * 
 * @date 15.11.2015
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
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Coordinate must not bei null");
		}
		return this.getCoordinateX()-coordinate.getCoordinateX();
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
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Coordinate must not bei null");
		}
		return this.getCoordinateY()-coordinate.getCoordinateY();
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
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Coordinate must not bei null");
		}
		return this.getCoordinateZ()-coordinate.getCoordinateZ();
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

}
