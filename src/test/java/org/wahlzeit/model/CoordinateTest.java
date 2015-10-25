package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Coordinate test class 
 * 
 * @version 1.0
 * 
 * @date 25.10.2015
 */
public class CoordinateTest {
	
	private Coordinate co1, co2, co3, co4, co5, co6, co7, co8, co9, co10;
	private double delta = 0.00001;
	
	@Before
	public void initializeTest(){
		co1 = new Coordinate();
		co2 = new Coordinate(10.0, -10.0);
		co3 = new Coordinate(-80.0, -70.0);
	}
	
	// boundary testing
	
	@Test(expected = IllegalArgumentException.class)
	public void testLowLatitudeBoundaryShouldThrowException(){
		co6 = new Coordinate(-91,0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHighLatitudeBoundaryShouldThrowException(){
		co7 = new Coordinate(91, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLowLongitudeBoundaryShouldThrowException(){
		co8 = new Coordinate(0, -181);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHighLongitudeBoundaryShouldThrowException(){
		co9 = new Coordinate(0, 181);
	}
	
	@Test
	public void testHighestBoundaries(){
		co4 = new Coordinate(90, 180);
	}
	
	@Test
	public void testLowestBoundaries(){
		co5 = new Coordinate(-90, -180);
	}
	
	// test the default constructor
	@SuppressWarnings("deprecation")
	@Test
	public void testDefaultConstructor(){
		assertEquals(0.0, co1.getLatitude(), delta);
		assertEquals(0.0, co1.getLongitude(), delta);
	}
	
	// test the distance computing
	@SuppressWarnings("deprecation")
	@Test
	public void testDistances(){
		assertEquals(90.0, co2.getDistance(co3).getLatitude(), delta);
		assertEquals(60.0, co2.getDistance(co3).getLongitude(), delta);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testDistanceWithOneObject(){
		assertEquals(0.0, co3.getDistance(co3).getLatitude(), delta);
		assertEquals(0.0, co3.getDistance(co3).getLongitude(), delta);
	}
	
	@SuppressWarnings("deprecation")
	@Test(expected = NullPointerException.class)
	public void testDistanceWithNullObject(){
		assertEquals(0.0, co2.getDistance(co10).getLatitude());
	}
}