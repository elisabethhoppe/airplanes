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
		
		assertClassInvariants();
		
		this.setCoordinateX(0.0);
		this.setCoordinateY(0.0);
		this.setCoordinateZ(0.0);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype   constructor
	 * 
	 * @param x The x value
	 * @param y The y value
	 * @param z The z value
	 */
	public CartesianCoordinate(double x, double y, double z) {
		
		assertClassInvariants();
		
		this.setCoordinateX(x);
		this.setCoordinateY(y);
		this.setCoordinateZ(z);
		
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
		
		assertClassInvariants();
		
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
		
		assertClassInvariants();	
		assertIsADouble(coordinateX);
		
		this.coordinateX = coordinateX;
		
		assertClassInvariants();
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
		
		assertClassInvariants();
		
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
		
		assertClassInvariants();
		assertIsADouble(coordinateY);
		
		this.coordinateY = coordinateY;
		
		assertClassInvariants();
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
		
		assertClassInvariants();
		
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
		
		assertClassInvariants();
		assertIsADouble(coordinateZ);
		
		this.coordinateZ = coordinateZ;
		
		assertClassInvariants();
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
		
		assertClassInvariants();
		assertCoordinateValidity(coordinate);
		
		double distance = this.getCoordinateX()-coordinate.getCoordinateX();
		
		assertIsADouble(distance);
		assertClassInvariants();
		
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
		
		assertClassInvariants();
		assertCoordinateValidity(coordinate);
		
		double distance = this.getCoordinateY()-coordinate.getCoordinateY();
		
		assertIsADouble(distance);
		assertClassInvariants();
		
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
		
		assertClassInvariants();
		assertCoordinateValidity(coordinate);
		
		double distance = this.getCoordinateZ()-coordinate.getCoordinateZ();
		
		assertIsADouble(distance);
		assertClassInvariants();
		
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
		
		assertClassInvariants();
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
