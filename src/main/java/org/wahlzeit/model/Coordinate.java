package org.wahlzeit.model;

public interface Coordinate {
	
	public double getDistance(Coordinate coordinate);
	public boolean isEqual(Coordinate coordinate);
	
	/**
	 * methods for default representation of a coordinate type 
	 * */
	public CartesianCoordinate getCartesianCoordinate();
	public double getCoordinateX();
	public double getCoordinateY();
	public double getCoordinateZ();

}
