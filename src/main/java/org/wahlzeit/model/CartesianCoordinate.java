package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

/**
 * Cartesian coordinate class
 * 
 * Represents a location based on cartesian coordinates
 * 
 * @version 1.0
 * 
 * @date 5.11.2015
 */
public class CartesianCoordinate extends DataObject implements Coordinate {
	
	private double coordinateX;
	private double coordinateY;
	private double coordinateZ;
	
	public CartesianCoordinate() {
		this.setCoordinateX(0.0);
		this.setCoordinateY(0.0);
		this.setCoordinateZ(0.0);
	}
	
	public CartesianCoordinate(double x, double y, double z) {
		this.setCoordinateX(x);
		this.setCoordinateY(y);
		this.setCoordinateZ(z);
	}
	
	public double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}

	public double getCoordinateZ() {
		return coordinateZ;
	}

	public void setCoordinateZ(double coordinateZ) {
		this.coordinateZ = coordinateZ;
	}
	
	@Override
	public double getDistance(Coordinate coordinate) {
		
		// computing the distance with pythagoras
		double powerX = Math.pow(this.getXDistance((CartesianCoordinate) coordinate), 2.0);
		double powerY = Math.pow(this.getYDistance((CartesianCoordinate) coordinate), 2.0);
		double powerZ = Math.pow(this.getZDistance((CartesianCoordinate) coordinate), 2.0);
		double distance = Math.sqrt(powerX + powerY + powerZ);
		return distance;
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		if(this == coordinate) {
			return true;
		}
		
		if(this.getClass() != coordinate.getClass()) { 
			return false;
		}
		
		if(!(coordinate instanceof CartesianCoordinate)) {
			return false;
		}
		
		CartesianCoordinate sCoordinate = (CartesianCoordinate) coordinate;
		
		if(sCoordinate.getCoordinateX() == this.getCoordinateX()
				&& sCoordinate.getCoordinateY() == this.getCoordinateY()
				&& sCoordinate.getCoordinateZ() == this.getCoordinateZ()) {			
			return true;
		}
		
		return false;
		
	}
	
	public double getXDistance(CartesianCoordinate coordinate){
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Coordinate must not bei null");
		}
		return this.getCoordinateX()-coordinate.getCoordinateX();
	}
	
	public double getYDistance(CartesianCoordinate coordinate){
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Coordinate must not bei null");
		}
		return this.getCoordinateY()-coordinate.getCoordinateY();
	}
	
	public double getZDistance(CartesianCoordinate coordinate){
		if(!checkCoordinateValidity(coordinate)){
			throw new IllegalArgumentException("Coordinate must not bei null");
		}
		return this.getCoordinateZ()-coordinate.getCoordinateZ();
	}
	
	private boolean checkCoordinateValidity(Coordinate coordinate){
		if(coordinate == null){
			return false;
		}
		return true;
	}

}
