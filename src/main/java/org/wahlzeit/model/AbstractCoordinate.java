package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;
import java.util.ArrayList;

/**
 * Abstract coordinate class for all coordinate representations. The cartesian representation is default. 
 * All coordinate objects are convert to the cartesian one and then all the functions are performed, e.g. distance 
 * computing. So all subclasses must provide a conversion to the cartesian representation.
 * 
 * @author Elisabeth Hoppe
 * 
 * @version 3.0
 * 
 * @date 13.12.2015
 */

public abstract class AbstractCoordinate extends DataObject implements Coordinate{

	/**
	 *  for persistence issues
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Array list for storing all exisiting coordinate value objects so far. 
	 */
	static protected ArrayList<Coordinate> existingCoordinates = new ArrayList<Coordinate>();
	
	/**
	 * Lock for the static getInstance() methods in subclasses 
	 */
	protected static final Object Lock = new Object();
	
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
		
		assertIsADouble(distance);
		
		return distance;
		
	}
	
	/**
	 * Checks whether the new object which should be initialized already exists in the array list existingObjects. 
	 * 
	 * @methodtype  comparison
	 *
	 * @param newX The new x value
	 * @param newY The new y value
	 * @param newZ The new z value
	 * 
	 * @return The coordinate object, if it already exists, null otherwise
	 */
	protected static Coordinate checkAlreadyExists(double newX, double newY, double newZ){
		
		for(Coordinate currentCoordinate: existingCoordinates) {
			
			if( doTestDoubleEquality(currentCoordinate.getCoordinateX(), newX) 
					&& doTestDoubleEquality(currentCoordinate.getCoordinateY(), newY)
					&& doTestDoubleEquality(currentCoordinate.getCoordinateZ(), newZ) ) {
				
				// an object with the same values was found -> return it 
				return (Coordinate)currentCoordinate;
				
			}
		}
		
		// no object with the same values as the new one was found -> return null
		return null;
		
	}
	
	/**
	 * Helper method to compare two doubles with a delta value
	 * 
	 * @methodtype primitive helper
	 * 
	 * @param numberOne The first number
	 * @param numberTwo	The second number
	 * 
	 * @return true if the two numbers are equal, false otherwise
	 */
	protected static boolean doTestDoubleEquality(double numberOne, double numberTwo) {
		
		double epsilon = 0.01;
		
		if(Math.abs(numberOne - numberTwo) < epsilon) {
			return true;
		}
		return false;
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
	
		CartesianCoordinate thisCoordinate = this.getCartesianCoordinate();
		CartesianCoordinate otherCoordinate = ((Coordinate)coordinate).getCartesianCoordinate();
		
		if(  doTestDoubleEquality(thisCoordinate.getCoordinateX(), otherCoordinate.getCoordinateX()) 
				&& doTestDoubleEquality(thisCoordinate.getCoordinateY(), otherCoordinate.getCoordinateY()) 
				&& doTestDoubleEquality(thisCoordinate.getCoordinateZ(), otherCoordinate.getCoordinateZ()) ) {			
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
	 * Checks whether a object is a double number object. If not, throws exception.
	 * 
	 * @methodtype assertion
	 * 
	 * @param number The number to check
	 * 
	 */
	protected void assertIsADouble(double number){
		if(Double.isNaN(number)){
			throw new IllegalArgumentException("Some components are not numbers, but have to be.");
		}
	}
	
	/**
	  * The class invariant assertion method. Must be overridden in every concrete subclass.
	  * 
	  * @methodtype class invariant assertion
	  * */
	 protected abstract void assertClassInvariants();
	 
	
	/**
	 * Gets the coordinate as a cartesian coordinate. Must be overridden in every concrete subclass.
	 * 
	 * @methodtype conversion
	 * 
	 * @return The coordinate as CartesianCoordinate object
	 */
	 public abstract CartesianCoordinate getCartesianCoordinate();
	 
	 /**
	 * Gets the x value of the coordinate. Must be overridden in every concrete subclass.
	 * 
	 * @methodtype get
	 * 
	 * @return The x value of the coordinate
	 */
	 public abstract double getCoordinateX();
	 
	 /**
	 * Gets the y value of the coordinate. Must be overridden in every concrete subclass.
	 * 
	 * @methodtype get
	 * 
	 * @return The y value of the coordinate
	 */
	 public abstract double getCoordinateY();
	 
	 /**
	 * Gets the z value of the coordinate. Must be overridden in every concrete subclass.
	 * 
	 * @methodtype get
	 * 
	 * @return The z value of the coordinate
	 */
	 public abstract double getCoordinateZ();
	 
	
	 

}
