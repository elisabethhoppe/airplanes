package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

/**
 * A Factory for creating airplane photos and related objects.
 * 
 * @version 1.0
 * 
 * @date 1.11.2015
 *
 */

@Pattern (
	name = "Singleton",
	participants = {
			"AirplanePhotoFactory"
	}
)
public class AirplanePhotoFactory extends PhotoFactory{
	
	private static final Logger log = Logger.getLogger(AirplanePhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static AirplanePhotoFactory instance = null;
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
	
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
			setInstance(new AirplanePhotoFactory());
		}

		return instance;
	}
	
	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(AirplanePhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PhotoFactory twice");
		}

		instance = photoFactory;
	}
	
}
