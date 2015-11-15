package org.wahlzeit.model;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Spheric Coordinate test class 
 * 
 * @version 2.0
 * 
 * @date 15.11.2015
 */
public class SphericCoordinateTest {
	
	private SphericCoordinate c1,c2,c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;
	private CartesianCoordinate other1;
	private double delta = 0.001;
	
	@Before
	public void setUp(){
		c1 = new SphericCoordinate();
		c2 = new SphericCoordinate(20.0, 40.5);
		c3 = new SphericCoordinate(12.6, -120.0);
		c11 = new SphericCoordinate(20.0, 40.5);
		c12 = new SphericCoordinate(0.0, 0.0, 6371.0);
		other1 = new CartesianCoordinate(0.0, 0.0, 6371.0);
		
	}
	
	// default constructor
	
	@Test
	public void testDefaultConstructor() {
		assertEquals(0.0, c1.getLatitude(), delta);
		assertEquals(0.0, c1.getLongitude(), delta);
		assertEquals(6371.0, c1.getRadius(), delta);
	}
	
	// test boundaries
	
	@Test(expected = IllegalArgumentException.class)
	public void testLowLatitudeBoundaryShouldThrowException(){
		c5 = new SphericCoordinate(-91,0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHighLatitudeBoundaryShouldThrowException(){
		c6 = new SphericCoordinate(91, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLowLongitudeBoundaryShouldThrowException(){
		c7 = new SphericCoordinate(0, -181);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHighLongitudeBoundaryShouldThrowException(){
		c8 = new SphericCoordinate(0, 181);
	}
	
	@Test
	public void testHighestBoundaries(){
		c9 = new SphericCoordinate(90, 180);
	}
	
	@Test
	public void testLowestBoundaries(){
		c10 = new SphericCoordinate(-90, -180);
	}
	
	// distance computing
	
	@Test
	public void testDistance() {
		//assertEquals(7.4, c2.getLatitudeDistance(c3), delta);
		//assertEquals(160.5, c2.getLongitudeDistance(c3), delta);
		assertEquals(3527.3497047014444, c2.getDistance(c3), delta);
	}
	
	@Test
	public void testDistanceWithOneObject() {
		assertEquals(0.0, c3.getDistance(c3), delta);
	}
	
	@Test
	public void testDistanceWithCartesian() {
		assertEquals(0.0, c12.getDistance(other1), delta);
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
		assertTrue(c2.isEqual(c11));
	}
	
	@Test
	public void testEqualsWithCartesian() {
		assertTrue(c12.isEqual(other1));
	}
	
}
