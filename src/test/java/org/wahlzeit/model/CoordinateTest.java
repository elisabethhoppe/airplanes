package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Cartesian Coordinate test class 
 * 
 * @version 2.0
 * 
 * @date 15.11.2015
 */
public class CoordinateTest {
	
	private CartesianCoordinate c1,c2,c3, c4, c5, c6, other1;
	private SphericCoordinate sp1, s1,s2,s3, s4, s5, s6, s7, s8, s9, s10, s11, s12;
	private double delta = 0.001;
	
	@Before
	public void setUp(){
		c1 = new CartesianCoordinate();
		c2 = new CartesianCoordinate(45,60,50);
		c3 = new CartesianCoordinate(20.5,20.4,20.3);
		c5 = new CartesianCoordinate(45,60,50);
		c6 = new CartesianCoordinate(0, 0, 6371);
		sp1 = new SphericCoordinate(0,50, 6371);
		
		s1 = new SphericCoordinate();
		s2 = new SphericCoordinate(20.0, 40.5);
		s3 = new SphericCoordinate(12.6, -120.0);
		s11 = new SphericCoordinate(20.0, 40.5);
		s12 = new SphericCoordinate(0.0, 0.0, 6371.0);
		other1 = new CartesianCoordinate(0.0, 0.0, 6371.0);
		
	}
	
	// default constructor
	
	@Test
	public void testDefaultConstructor() {
		assertEquals(0.0, c1.getCoordinateX(), delta);
		assertEquals(0.0, c1.getCoordinateY(), delta);
		assertEquals(0.0, c1.getCoordinateZ(), delta);
		assertEquals(0.0, s1.getLatitude(), delta);
		assertEquals(0.0, s1.getLongitude(), delta);
		assertEquals(6371.0, s1.getRadius(), delta);
	}
	
	// test boundaries
	
	@Test(expected = IllegalArgumentException.class)
	public void testLowLatitudeBoundaryShouldThrowException(){
		s5 = new SphericCoordinate(-91,0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHighLatitudeBoundaryShouldThrowException(){
		s6 = new SphericCoordinate(91, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLowLongitudeBoundaryShouldThrowException(){
		s7 = new SphericCoordinate(0, -181);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHighLongitudeBoundaryShouldThrowException(){
		s8 = new SphericCoordinate(0, 181);
	}
	
	@Test
	public void testHighestBoundaries(){
		s9 = new SphericCoordinate(90, 180);
	}
	
	@Test
	public void testLowestBoundaries(){
		s10 = new SphericCoordinate(-90, -180);
	}

	// distance computing
	
	@Test
	public void testDistance() {
		assertEquals(24.5, c2.getXDistance(c3), delta);
		assertEquals(39.6, c2.getYDistance(c3), delta);
		assertEquals(29.7, c2.getZDistance(c3), delta);
		assertEquals(55.23133169, c2.getDistance(c3), delta);
		
		assertEquals(7.4, s2.getLatitudeDistance(s3), delta);
		assertEquals(160.5, s2.getLongitudeDistance(s3), delta);
		assertEquals(3527.3497047014444, s2.getDistance(s3), delta);
	}
	
	@Test
	public void testDistanceWithOneObject() {
		assertEquals(0.0, c2.getDistance(c2), delta);
		assertEquals(0.0, s3.getDistance(s3), delta);
	}
	
	@Test
	public void testDistanceWithSphericCoordinate() {
		assertEquals(0.0, c6.getDistance(sp1), delta);
	}
	

	
	@Test
	public void testDistanceWithCartesian() {
		assertEquals(0.0, s12.getDistance(other1), delta);
	}
	
	
	@Test(expected=IllegalArgumentException.class) 
	public void testDistanceWithNullObjectShouldThrowException(){
		assertEquals(0.0, c2.getDistance(c4), delta);
	}
	
	// equality
	
	@Test
	public void testEquals() {
		assertFalse(c3.isEqual(c1));
		assertTrue(c3.isEqual(c3));
		assertTrue(c2.isEqual(c5));
		assertFalse(s3.isEqual(s1));
		assertTrue(s3.isEqual(s3));
		assertTrue(s2.isEqual(s11));
	}
	
	@Test
	public void testEqualsCartesianWithSpheric() {
		assertTrue(c6.isEqual(s1));
	}

	
	@Test
	public void testEqualsSphericWithCartesian() {
		assertTrue(s12.isEqual(other1));
	}
	
}
