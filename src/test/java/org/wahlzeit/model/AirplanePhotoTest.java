package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Airplane photo test class 
 * 
 * @version 2.0
 * 
 * @date 11.01.2016
 */

public class AirplanePhotoTest {
	
	private AirplanePhoto p1;
	
	@Before
	public void setUp(){	
		p1 = new AirplanePhoto("Boeing", AirplaneCategory.LangstreckenJet, 20000, LandCategory.Landflugzeug);
	}

	
	
	// constructor
	
	@Test
	public void testConstructor() {	
		assertEquals(p1.getAirplane().getType().getCategory(), AirplaneCategory.LangstreckenJet);
		assertEquals(p1.getAirplane().getType().getAltitude(), 20000);
		assertEquals(p1.getAirplane().getType().getLanding(), LandCategory.Landflugzeug);
	}
	
	
}
