package org.wahlzeit.model;

/**
 * This annotation class is for annotating pattern in the source code
 * 
 * @author Elisabeth Hoppe
 * 
 * @version 1.0
 * 
 * @date 03.12.2015
 */
public @interface Pattern {

	String name();
	
	String[] participants();

}
