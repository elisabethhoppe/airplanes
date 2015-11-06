package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Cartesian Coordinate test class 
 * 
 * @version 1.0
 * 
 * @date 06.11.2015
 */
public class CartesianCoordinateTest {
	
	private CartesianCoordinate c1,c2,c3, c4;
	private double delta = 0.001;
	
	@Before
	public void setUp(){
		c1 = new CartesianCoordinate();
		c2 = new CartesianCoordinate(45,60,50);
		c3 = new CartesianCoordinate(20.5,20.4,20.3);
		
	}
	
	@Test
	public void testDefaultConstructor() {
		assertEquals(0.0, c1.getCoordinateX(), delta);
		assertEquals(0.0, c1.getCoordinateY(), delta);
		assertEquals(0.0, c1.getCoordinateZ(), delta);
	}
	
	@Test
	public void testDistance() {
		assertEquals(24.5, c2.getXDistance(c3), delta);
		assertEquals(39.6, c2.getYDistance(c3), delta);
		assertEquals(29.7, c2.getZDistance(c3), delta);
		assertEquals(55.23133169, c2.getDistance(c3), delta);
	}
	
	@Test
	public void testDistanceWithOneObject() {
		assertEquals(0.0, c2.getDistance(c2), delta);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testDistanceWithNullObjectShouldThrowException(){
		assertEquals(0.0, c2.getDistance(c4), delta);
	}
	
	@Test
	public void testEquals() {
		assertFalse(c3.equals(c1));
		assertTrue(c3.equals(c3));
	}
	
}
