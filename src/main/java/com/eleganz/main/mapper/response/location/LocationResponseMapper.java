package com.eleganz.main.mapper.response.location;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.eleganz.main.mapper.response.ResponseMapper;
import com.eleganz.main.model.domain.user.Location;
import com.eleganz.main.model.domain.user.UserDetail;
import com.eleganz.main.model.response.user.EventResponse;
import com.eleganz.main.model.response.user.LocationResponse;
import com.eleganz.main.model.response.user.PersonResponse;
import com.eleganz.main.model.response.user.UserDetailResponse;
import com.eleganz.main.model.response.user.UserResponse;

/**
 * <p>
 * LocationResponseMapper class. Mapper used to convert from {@link com.eleganz.main.model.domain.location.Location}
 * to {@link com.eleganz.main.model.response.location.LocationResponse}.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Component
public class LocationResponseMapper implements ResponseMapper<Location, LocationResponse> {

	/** {@inheritDoc} */
	@Override
	public LocationResponse convert(Location from) {
		if(from == null) {
			return null;
		}
		final LocationResponse result = new LocationResponse();
		result.setId(from.getId());
		result.setName(from.getName());
		result.setAddress(from.getAddress());
		result.setCity(from.getCity());
		result.setState(from.getState());
		result.setCountry(from.getCountry());
		result.setPostalCode(from.getPostalCode());
		result.setType(from.getType());

		final Set<EventResponse> events = from.getEvents().stream().map(e -> {
			EventResponse event = new EventResponse();
			event.setDate(e.getDate());
			event.setTime(e.getTime());
			switch(from.getType()) {
				case CHURCH:
					event.setChurchUserDetails(buildWeddingRelatedUserDetailsResponse(e.getChurchUserDetails()));
					break;
				case WEDDING:
					event.setWeddingUserDetails(buildWeddingRelatedUserDetailsResponse(e.getWeddingUserDetails()));
					break;
			}

			return event;
		}).collect(Collectors.toSet());
		result.setEvents(events);

		return result;
	}

	/**
	 * <p>
	 * Build a wedding related {@link com.eleganz.main.model.response.user.UserDetailResponse} based on 
	 * {@link com.eleganz.main.model.domain.user.UserDetail}.
	 * </p>
	 * 
	 * @param userDetail
	 *            {@link com.eleganz.main.model.domain.user.UserDetail}
	 * @return a {@link com.eleganz.main.model.response.user.UserDetailResponse} object.
	 */
	private UserDetailResponse buildWeddingRelatedUserDetailsResponse(UserDetail userDetail) {
		final UserDetailResponse result = new UserDetailResponse();
		result.setType(userDetail.getType());
		final PersonResponse bride = new PersonResponse();
		bride.setFirstName(userDetail.getBride().getFirstName());
		bride.setLastName(userDetail.getBride().getLastName());
		result.setBride(bride);
		final PersonResponse groom = new PersonResponse();
		groom.setFirstName(userDetail.getGroom().getFirstName());
		groom.setLastName(userDetail.getGroom().getLastName());
		result.setGroom(groom);
		final UserResponse user = new UserResponse();
		user.setId(userDetail.getUser().getId());
		user.setUsername(userDetail.getUser().getUsername());
		user.setEmail(userDetail.getUser().getEmail());
		user.setRole(userDetail.getUser().getRole());
		result.setUser(user);

		return result;
	}
}
