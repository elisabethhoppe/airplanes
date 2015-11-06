package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Coordinate test class 
 * 
 * @version 2.0
 * 
 * @date 01.11.2015
 */
public class CoordinateOldTest {
	
	private CoordinateOld co1, co2, co3, co4, co5, co6, co7, co8, co9, co10, co11, co12, co13, co14;
	private double delta = 0.00001;
	
	@Before
	public void initializeTest(){
		co1 = new CoordinateOld();
		co2 = new CoordinateOld(10.0, -10.0);
		co3 = new CoordinateOld(-80.0, -70.0);
		co13 = new CoordinateOld(90,90);
		co14 = new CoordinateOld(90,90);
	}
	
	// boundary testing
	
	@Test(expected = IllegalArgumentException.class)
	public void testLowLatitudeBoundaryShouldThrowException(){
		co6 = new CoordinateOld(-91,0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHighLatitudeBoundaryShouldThrowException(){
		co7 = new CoordinateOld(91, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLowLongitudeBoundaryShouldThrowException(){
		co8 = new CoordinateOld(0, -181);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHighLongitudeBoundaryShouldThrowException(){
		co9 = new CoordinateOld(0, 181);
	}
	
	@Test
	public void testHighestBoundaries(){
		co4 = new CoordinateOld(90, 180);
	}
	
	@Test
	public void testLowestBoundaries(){
		co5 = new CoordinateOld(-90, -180);
	}
	
	// test the default constructor
	
	@Test
	public void testDefaultConstructor(){
		assertEquals(0.0, co1.getLatitude(), delta);
		assertEquals(0.0, co1.getLongitude(), delta);
	}
	
	// test the distance computing

	@Test
	public void testDistances(){
		assertEquals(90.0, co2.getLatitudeDistance(co3), delta);
		assertEquals(60.0, co2.getLongitudeDistance(co3), delta);
	}
	
	
	@Test
	public void testDistanceWithOneObject(){
		assertEquals(0.0, co3.getLatitudeDistance(co3), delta);
		assertEquals(0.0, co3.getLongitudeDistance(co3), delta);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDistanceWithNullObject(){
		assertEquals(0.0, co2.getLatitudeDistance(co10), delta);
	}
	
	@Test
	public void testDistanceInKM(){
		co11 = new CoordinateOld(52.517, 13.40);
		co12 = new CoordinateOld(35.70, 139.767);
		assertEquals(8918.95007053525, co11.getDistance(co12), delta);
		
	}
	
	// test equality
	@Test
	public void testEquality(){
		assertTrue(co13.equals(co14));
	}
}
