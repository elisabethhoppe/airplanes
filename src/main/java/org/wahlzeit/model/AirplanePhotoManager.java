package org.wahlzeit.model;

/**
 *  A photo manager provides access to and manages airplane photos.
 * 
 * @version 1.0
 * 
 * @date 1.11.2015
 *
 */
@Pattern(
		name = "Facade", 
		participants = { "AirplanePhotoManager", "Clients" }
)
public class AirplanePhotoManager extends PhotoManager {
	
	/**
	 * @methodtype default constructor
	 */
	public AirplanePhotoManager() {
		super();
	}
	
}
