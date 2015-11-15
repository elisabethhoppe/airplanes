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
	 * Computes the distance between two cartesian coordinates with pythagoras
	 * 
	 * @methodtype  command
	 * @methodproperties template  
	 *
	 * @param coordinate The another coordinate
	 * @return The distance
	 */
	@Override
	public double getDistance(Coordinate coordinate) {
		
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
		
		CartesianCoordinate cCoordinate = getCartesianCoordinate(coordinate);
		
		// computing the distance with pythagoras
		double powerX = Math.pow(this.getXDistance(cCoordinate), 2.0);
		double powerY = Math.pow(this.getYDistance(cCoordinate), 2.0);
		double powerZ = Math.pow(this.getZDistance(cCoordinate), 2.0);
		double distance = Math.sqrt(powerX + powerY + powerZ);
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
		
		/*if(!(coordinate instanceof CartesianCoordinate)) {
			return false;
		}*/
		
		CartesianCoordinate cCoordinate = getCartesianCoordinate(coordinate);
		
		if(cCoordinate.getCoordinateX() == this.getCoordinateX()
				&& cCoordinate.getCoordinateY() == this.getCoordinateY()
				&& cCoordinate.getCoordinateZ() == this.getCoordinateZ()) {			
			return true;
		}
		
		return false;
		
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
	 * Gets the coordinate as a cartesian coordinate
	 * 
	 * @methodtype conversion
	 * 
	 * @param coordinate A coordinate to convert
	 * @return The coordinate as CartesianCoordinate object
	 */
	private CartesianCoordinate getCartesianCoordinate(Coordinate coordinate) {
		if (coordinate instanceof CartesianCoordinate) {
			return (CartesianCoordinate) coordinate;
		} 
		else if (coordinate instanceof SphericCoordinate) {
			return convertToCartesianCoordinate((SphericCoordinate) coordinate);
		}
		else {
			throw new IllegalArgumentException("This coordinate type is not known.");
		}
	}
	
	/**
	 * Does the conversion to a cartesian coordinate subclass 
	 * 
	 * @methodtype conversion
	 * 
	 * @param coordinate A coordinate to convert
	 * @return The coordinate as CartesianCoordinate object
	 */
	private CartesianCoordinate convertToCartesianCoordinate(SphericCoordinate coordinate) {

		double latitude = Math.toRadians(coordinate.getLatitude());
		double longitude = Math.toRadians(coordinate.getLongitude());
		double radius = coordinate.getRadius();

		double x = radius * Math.cos(longitude) * Math.sin(latitude);
		double y = radius * Math.sin(longitude) * Math.sin(latitude);
		double z = radius * Math.cos(latitude);

		return new CartesianCoordinate(x, y, z);
	}
	
	
	/**
	 * Checks whether a coordinate is valid ( not null )
	 * 
	 * @methodtype  assertion
	 * 
	 *
	 * @param coordinate The coordinate
	 * @return true if coordinate is not null, false if it is null
	 */
	private boolean checkCoordinateValidity(Coordinate coordinate){
		if(coordinate == null){
			return false;
		}
		return true;
	}

}
