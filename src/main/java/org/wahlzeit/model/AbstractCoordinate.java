package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

/**
 * Abstract coordinate class for all coordinate representations. The cartesian representation is default. 
 * All coordinate objects are convert to the cartesian one and then all the functions are performed, e.g. distance 
 * computing. So all subclasses must provide a conversion to the cartesian representation.
 * 
 * 
 * @version 1.0
 * 
 * @date 15.11.2015
 */

public abstract class AbstractCoordinate extends DataObject implements Coordinate{

	/**
	 *  for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Computes the distance between two coordinates. The coordinates are both convert to cartesian 
	 * coordinates, this is the default representation of coordinates.
	 * 
	 * @methodtype  command 
	 *
	 * @param coordinate The another coordinate
	 * @return The distance
	 */
	@Override
	public double getDistance(Coordinate coordinate) {
		if(!checkCoordinateValidity(coordinate)) {
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
		
		CartesianCoordinate thisCoordinate = this.getCartesianCoordinate();
		CartesianCoordinate otherCoordinate = ((AbstractCoordinate)coordinate).getCartesianCoordinate();
		
		// now compute distance of two cartesian coordinates (pythagoras)
		double powerX = Math.pow(thisCoordinate.getXDistance(otherCoordinate), 2.0);
		double powerY = Math.pow(thisCoordinate.getYDistance(otherCoordinate), 2.0);
		double powerZ = Math.pow(thisCoordinate.getZDistance(otherCoordinate), 2.0);
		double distance = Math.sqrt(powerX + powerY + powerZ);
		return distance;
		
	}
	
	/**
	 * Tests whether this and another coordinates are equal. First converts the two coordinates into cartesian coordinates 
	 * and then tests whether they are equal.
	 * 
	 * @methodtype  comparison
	 *
	 * @param coordinate The another coordinate
	 * @return True if the two coordinates are equal, false if not
	 */
	public boolean isEqual(Coordinate coordinate) {
		if(!checkCoordinateValidity(coordinate)) {
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
		
		if(this == coordinate) {
			return true;
		}
		
		CartesianCoordinate thisCoordinate = this.getCartesianCoordinate();
		CartesianCoordinate otherCoordinate = ((AbstractCoordinate)coordinate).getCartesianCoordinate();
		
		if(thisCoordinate.getCoordinateX() == otherCoordinate.getCoordinateX()
				&& thisCoordinate.getCoordinateY() == otherCoordinate.getCoordinateY()
				&& thisCoordinate.getCoordinateZ() == otherCoordinate.getCoordinateZ()) {			
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Checks whether a coordinate object is valid (not equal null)
	 * 
	 * @methodtype assertion
	 * 
	 * @param coordinate The coordinate object to check
	 * @return	true if the object is valid, false if not
	 */
	protected boolean checkCoordinateValidity(Coordinate coordinate){
		if(coordinate == null){
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the coordinate as a cartesian coordinate. Must be overriden in every concrete subclass.
	 * 
	 * @methodtype conversion
	 * 
	 * @return The coordinate as CartesianCoordinate object
	 */
	 public abstract CartesianCoordinate getCartesianCoordinate();

}
