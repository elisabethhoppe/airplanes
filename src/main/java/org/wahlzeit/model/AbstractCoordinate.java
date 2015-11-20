package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

/**
 * Abstract coordinate class for all coordinate representations. The cartesian representation is default. 
 * All coordinate objects are convert to the cartesian one and then all the functions are performed, e.g. distance 
 * computing. So all subclasses must provide a conversion to the cartesian representation.
 * 
 * 
 * @version 2.0
 * 
 * @date 20.11.2015
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
	public double getDistance(Coordinate coordinate) {
		
		assertCoordinateValidity(coordinate);
		
		CartesianCoordinate thisCoordinate = this.getCartesianCoordinate();
		CartesianCoordinate otherCoordinate = ((Coordinate)coordinate).getCartesianCoordinate();
		
		// now compute distance of two cartesian coordinates (pythagoras)
		double powerX = Math.pow(thisCoordinate.getXDistance(otherCoordinate), 2.0);
		double powerY = Math.pow(thisCoordinate.getYDistance(otherCoordinate), 2.0);
		double powerZ = Math.pow(thisCoordinate.getZDistance(otherCoordinate), 2.0);
		double distance = Math.sqrt(powerX + powerY + powerZ);
		
		assert distance!=Double.NaN;
		
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
		
		assertCoordinateValidity(coordinate);
			
		if(this == coordinate) {
			return true;
		}
		
		double epsilon = 0.01;
		
		CartesianCoordinate thisCoordinate = this.getCartesianCoordinate();
		CartesianCoordinate otherCoordinate = ((Coordinate)coordinate).getCartesianCoordinate();
		
		if( (Math.abs(thisCoordinate.getCoordinateX() - otherCoordinate.getCoordinateX()) < epsilon)
				&& (Math.abs(thisCoordinate.getCoordinateY() - otherCoordinate.getCoordinateY()) < epsilon)
				&& (Math.abs(thisCoordinate.getCoordinateZ() - otherCoordinate.getCoordinateZ()) < epsilon) ) {			
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
	protected void assertCoordinateValidity(Coordinate coordinate){
		if(coordinate == null){
			throw new IllegalArgumentException("Argument coordinate object is null");
		}
	}
	
	/**
	 * Gets the coordinate as a cartesian coordinate. Must be overriden in every concrete subclass.
	 * 
	 * @methodtype conversion
	 * 
	 * @return The coordinate as CartesianCoordinate object
	 */
	 public abstract CartesianCoordinate getCartesianCoordinate();
	 
	 /**
	 * Gets the x value of the coordinate. Must be overriden in every concrete subclass.
	 * 
	 * @methodtype get
	 * 
	 * @return The x value of the coordinate
	 */
	 public abstract double getCoordinateX();
	 
	 /**
	 * Gets the y value of the coordinate. Must be overriden in every concrete subclass.
	 * 
	 * @methodtype get
	 * 
	 * @return The y value of the coordinate
	 */
	 public abstract double getCoordinateY();
	 
	 /**
	 * Gets the z value of the coordinate. Must be overriden in every concrete subclass.
	 * 
	 * @methodtype get
	 * 
	 * @return The z value of the coordinate
	 */
	 public abstract double getCoordinateZ();
	 
	 /**
	  * The class invariant assertion method. Checks whether the coordinate is equal with itself.
	  * */
	 

}
