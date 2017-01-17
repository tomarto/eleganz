package com.eleganz.main.controller.location;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleganz.main.exception.NotFoundException;
import com.eleganz.main.model.response.Response;
import com.eleganz.main.model.response.user.LocationResponse;
import com.eleganz.main.service.location.LocationService;

/**
 * <p>
 * LocationController class. Controller used to interact with UI.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Controller
@RequestMapping("/api")
public class LocationController {

	private final LocationService locationService;

	/**
	 * <p>
	 * Constructor for LocationController.
	 * </p>
	 * 
	 * @param locationService
	 *            a {@link com.eleganz.main.service.location.LocationService} object.
	 */
	@Autowired
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	/**
	 * <p>
	 * Retrieves a list of Location.
	 * </p>
	 * 
	 * @return a {@link com.eleganz.main.model.response.Response<Collection<LocationResponse>>} object.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/location", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<Collection<LocationResponse>> getLocations() {
		return new Response<>(locationService.getAllLocations());
	}

	/**
	 * <p>
	 * Retrieves a single Location based on the id.
	 * </p>
	 * 
	 * @param id
	 *            a {@link java.lang.Long} object.
	 * @return a {@link com.eleganz.main.model.response.Response<LocationResponse>} object.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/location/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Response<LocationResponse> getLocation(@PathVariable Long id) {
		return new Response<>(locationService.getLocationById(id)
				.orElseThrow(() -> new NotFoundException(
						String.format("No se encontró el lugar con ID: %s", id.toString()))));
	}
}
