package org.wahlzeit.model;

/**
 * A Factory for creating airplane photos and related objects.
 * 
 * @version 1.0
 * 
 * @date 1.11.2015
 *
 */
public class AirplanePhotoFactory extends PhotoFactory{
	
	
	/**
	 * @mathodtype default constructor
	 */
	protected AirplanePhotoFactory() {
		super();
	}
	
	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto() {
		return new AirplanePhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	@Override
	public Photo createPhoto(PhotoId id) {
		return new AirplanePhoto(id);
	}
}
