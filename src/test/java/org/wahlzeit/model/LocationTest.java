package org.wahlzeit.model;

import org.junit.Before;

/**
 * Location test class 
 * 
 * @version 1.0
 * 
 * @date 01.11.2015
 */
public class LocationTest {
	
	private Location l1,l2;
	private Coordinate c1;
	
	@Before
	public void initializeTest(){
		l1 = new Location();
		c1 = new Coordinate(90,30);
		l2 = new Location("meineLocation", c1);
	}
	
	

}
