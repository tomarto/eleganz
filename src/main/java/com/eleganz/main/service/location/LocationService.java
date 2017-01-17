package com.eleganz.main.service.location;

import java.util.Collection;
import java.util.Optional;

import com.eleganz.main.model.response.user.LocationResponse;

/**
 * <p>
 * LocationService interface. Service used for user actions.
 * </p>
 * 
 * @author Omar Ortiz.
 */
public interface LocationService {

	/**
	 * <p>
	 * Retrieves a collection of all {@link com.eleganz.main.model.response.user.LocationResponse}.
	 * </p>
	 * 
	 * @return a {@link java.util.Collection<LocationResponse>} object.
	 */
	Collection<LocationResponse> getAllLocations();

	/**
	 * <p>
	 * Retrieves a single {@link com.eleganz.main.model.response.user.LocationResponse} from its id.
	 * </p>
	 * 
	 * @param id
	 *            {@link java.lang.Long}
	 * @return a {@link java.util.Optional<LocationResponse>} object.
	 */
	Optional<LocationResponse> getLocationById(long id);
}
